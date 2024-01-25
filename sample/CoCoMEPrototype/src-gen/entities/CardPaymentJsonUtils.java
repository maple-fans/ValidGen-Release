package entities;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;import java.util.ArrayList;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


import org.json.JSONArray;
import org.json.JSONException;

public class CardPaymentJsonUtils{
	
	
	public static List<HashMap<String, Object>> getJsonList(String json) {
	    	List<HashMap<String, Object>> dataList;
	    	   
	    	   dataList = new ArrayList<>();
	    	   
	    	   try {
	    	   	
	    	   	JsonObject respJson=new JsonParser().parse(json).getAsJsonObject();
	    	   	
	    	   	System.out.println(respJson);
	    	   	
	    	   	   JSONObject rootObject = new JSONObject(respJson.toString());
	
	            JSONArray dataArray = rootObject.getJSONArray("CardPayment");

	            for (int i = 0; i < dataArray.length(); i++) {
	
	   JSONObject sonObject = dataArray.getJSONObject(i);
	   
	   String CardAccountNumberStr = String.valueOf(sonObject.get("CardAccountNumber"));
	   String ExpiryDateStr = String.valueOf(sonObject.get("ExpiryDate"));

			                
			        HashMap<String, Object> map = new HashMap<>(); 
					map.put("CardAccountNumber", CardAccountNumberStr);
					map.put("ExpiryDate", ExpiryDateStr);
	
	                dataList.add(map);
	}
	return dataList;
	
	} catch (JSONException e) {
	    e.printStackTrace();
	}
	return null;
	}

	
	}	
			
