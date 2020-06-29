package com.gw.utilities;

import java.util.*;
import java.sql.*;

import org.apache.log4j.Logger;

import com.gw.driver.LoggerClass;

public class DBConnectionManager {

	String databaseUrl = "jdbc:oracle:thin:@XDHFD2-OLTPNP-SCAN:1521/BI2D.THEHARTFORD.COM";
	//String userName = "compasuser";
	String userName = "cpg1954";
	String password = "Tiger2203"; 
	/*String databaseUrl = "jdbc:oracle:thin:@MXL3450R40:1521/XE";
	//String userName = "compasuser";
	String userName = "compasqauser";
	//String password = "password123";
	String password = "password456";*/
	//static Logger log = Logger.getLogger(DBConnectionManager.class);
	
	//String password = "password456";
	//static Logger log = Logger.getLogger(DBConnectionManager.class);
	private static org.apache.log4j.Logger loggers;
	private org.apache.log4j.Logger log  = LoggerClass.getThreadLogger("Thread" + Thread.currentThread().getName(),ThreadCache.getInstance().getProperty("TCID"));
	final int MAX_POOL_SIZE = 15;

	Vector<Connection> connectionPool = new Vector<Connection>();

	private static DBConnectionManager dbConnectionManager = new DBConnectionManager();

	public static DBConnectionManager getInstance() {
		return dbConnectionManager;
	}

	private DBConnectionManager() {
		initialize();
	}

	public DBConnectionManager(
			// String databaseName,
			String databaseUrl, String userName, String password) {
		this.databaseUrl = databaseUrl;
		this.userName = userName;
		this.password = password;
		initialize();
	}

	private void initialize() {
		// Here we can initialize all the information that we need
		initializeConnectionPool();
	}

	private void initializeConnectionPool() {
		while (!checkIfConnectionPoolIsFull()) {
			System.out.println("Connection Pool is NOT full. Proceeding with adding new connections");
			// Adding new connection instance until the pool is full
			connectionPool.addElement(createNewConnectionForPool());
		}
		System.out.println("Connection Pool is full.");
	}

	private synchronized boolean checkIfConnectionPoolIsFull() {

		// Check if the pool size
		if (connectionPool.size() < 5) {
			return false;
		}

		return true;
	}

	// Creating a connection
	private Connection createNewConnectionForPool() {
		Connection connection = null;

		try {
			// Class.forName("oracle.jdbc.driver.OracleDriver");
			// connection=DriverManager.getConnection(
			// databaseUrl,userName,password);
			/*
			 * Class.forName("net.ucanaccess.jdbc.UcanaccessDriver"); //String url =
			 * "jdbc:ucanaccess:////ad1.prod/hig/commercial/ComPAS/temp/E2E/Binit/E2EMASTERDB_be.accdb"
			 * ; String url = PCConstants.E2e_DB; connection =
			 * DriverManager.getConnection(url);
			 */
			/*
			 * String databaseUrl = "jdbc:oracle:thin:@MXL3450R40:1521/XE"; String userName
			 * = "compasqauser"; String password = "password123";
			 */
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection(databaseUrl, userName, password);

		} catch (SQLException sqle) {
			System.err.println("SQLException: " + sqle);
			return null;
		} catch (ClassNotFoundException cnfe) {
			System.err.println("ClassNotFoundException: " + cnfe);
			return null;
		}

		return connection;
	}

	public synchronized Connection getConnectionFromPool() {
		// Check if there is a connection available.
		Connection returnConnection = null;
		if (connectionPool.size() > 0) {

			for (Connection connection : connectionPool)// while (cnt <
														// MAX_POOL_SIZE)
			{
				try {
					Statement stmt = connection.createStatement();
					int result = 0;
					ResultSet rs = stmt.executeQuery("select 1 from dual");
					while (rs.next()) {
						result = rs.getInt(1);
					}
					if (result == 1) {
						returnConnection = connection;
						connectionPool.removeElement(connection);
						log.info("Found valid connection");
						rs.close();
						stmt.close();
						break;
					} else {
						// connectionPool.removeElementAt(0);
						connectionPool.removeElement(connection);
						initializeConnectionPool();
					}
				} catch (Exception e) {
					log.error("Error getting connection from connection pool", e);
				}
			}
		} else {
			initializeConnectionPool();
			returnConnection = (Connection) connectionPool.firstElement();
			connectionPool.removeElementAt(0);
		}
		// Giving away the connection from the connection pool
		return returnConnection;
	}

	public synchronized void returnConnectionToPool(Connection connection) {
		// Adding the connection from the client back to the connection pool
		connectionPool.addElement(connection);
	}

	// Closing Statement
	public void closeStatement(Statement st) {
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				log.error("Closing Statement: " + e);
			}
		}
	}

	// Closing Prepared Statement
	public void closePreparedStatement(PreparedStatement pst) {
		if (pst != null) {
			try {
				pst.close();
			} catch (SQLException e) {
				log.error("Closing Statement: " + e);
			}
		}
	}

	// Closing Result set
	public void closeResultSet(ResultSet rs) {

		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				log.error("Closing Result Set: " + e);
			}
		}
	}

}
