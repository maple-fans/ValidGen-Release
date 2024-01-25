package entities;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;import java.util.ArrayList;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


import org.json.JSONArray;
import org.json.JSONException;

public class SaleJsonUtils{
	
	
	public static List<HashMap<String, Object>> getJsonList(String json) {
	    	List<HashMap<String, Object>> dataList;
	    	   
	    	   dataList = new ArrayList<>();
	    	   
	    	   try {
	    	   	
	    	   	JsonObject respJson=new JsonParser().parse(json).getAsJsonObject();
	    	   	
	    	   	System.out.println(respJson);
	    	   	
	    	   	   JSONObject rootObject = new JSONObject(respJson.toString());
	
	            JSONArray dataArray = rootObject.getJSONArray("Sale");

	            for (int i = 0; i < dataArray.length(); i++) {
	
	   JSONObject sonObject = dataArray.getJSONObject(i);
	   
	   String TimeStr = String.valueOf(sonObject.get("Time"));
	   String IsCompleteStr = String.valueOf(sonObject.get("IsComplete"));
	   String AmountStr = String.valueOf(sonObject.get("Amount"));
	   String IsReadytoPayStr = String.valueOf(sonObject.get("IsReadytoPay"));

			                
			        HashMap<String, Object> map = new HashMap<>(); 
					map.put("Time", TimeStr);
					map.put("IsComplete", IsCompleteStr);
					map.put("Amount", AmountStr);
					map.put("IsReadytoPay", IsReadytoPayStr);
	
	                dataList.add(map);
	}
	return dataList;
	
	} catch (JSONException e) {
	    e.printStackTrace();
	}
	return null;
	}

	
	}	
			
