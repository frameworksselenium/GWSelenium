package com.gw.utilities;

import java.util.HashMap;

public class  ThreadCacheManager {
	
	HashMap<String,String> mh = new HashMap<String,String>(); 

	 public void setObject(String key, String value)
		{
		 	mh.put(key, value);
		}
    public String getObject(String ff)
	{
		String retuValue = null;
		if(mh.containsKey(ff))
		{
		  retuValue = mh.get(ff);
		}
		return retuValue;
	}
    
}
