
package com.gw.utilities;

public class ThreadCache {
	
	private static ThreadCache instance = new ThreadCache();
	
	public static ThreadCache getInstance()
	{
		return instance;
	}
    ThreadLocal<ThreadCacheManager> tc = new ThreadLocal<ThreadCacheManager>();

			   
   	public ThreadCacheManager getThreadCacheManager() 
   	{
   		return tc.get(); 
   	}

    public void setThreadCacheManager(ThreadCacheManager tm)
    {
    	tc.set(tm);
    }

}
