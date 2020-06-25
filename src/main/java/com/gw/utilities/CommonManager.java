
package com.gw.utilities;

public class CommonManager 
{	
	   private static CommonManager instance = new CommonManager();
	   ThreadLocal<Common> common = new ThreadLocal<Common>();
	   
	   public static CommonManager getInstance()
	   {
	      return instance;
	   }
				   
	   public Common getCommon() 
	   {
	      return common.get();
	   }
	   
	   public void setCommon(Common com){
		   common.set(com);
	   }

}
