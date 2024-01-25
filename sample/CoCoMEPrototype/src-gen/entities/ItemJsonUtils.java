package entities;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;import java.util.ArrayList;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


import org.json.JSONArray;
import org.json.JSONException;

public class ItemJsonUtils{
	
	
	public static List<HashMap<String, Object>> getJsonList(String json) {
	    	List<HashMap<String, Object>> dataList;
	    	   
	    	   dataList = new ArrayList<>();
	    	   
	    	   try {
	    	   	
	    	   	JsonObject respJson=new JsonParser().parse(json).getAsJsonObject();
	    	   	
	    	   	System.out.println(respJson);
	    	   	
	    	   	   JSONObject rootObject = new JSONObject(respJson.toString());
	
	            JSONArray dataArray = rootObject.getJSONArray("Item");

	            for (int i = 0; i < dataArray.length(); i++) {
	
	   JSONObject sonObject = dataArray.getJSONObject(i);
	   
	   String BarcodeStr = String.valueOf(sonObject.get("Barcode"));
	   String NameStr = String.valueOf(sonObject.get("Name"));
	   String PriceStr = String.valueOf(sonObject.get("Price"));
	   String StockNumberStr = String.valueOf(sonObject.get("StockNumber"));
	   String OrderPriceStr = String.valueOf(sonObject.get("OrderPrice"));

			                
			        HashMap<String, Object> map = new HashMap<>(); 
					map.put("Barcode", BarcodeStr);
					map.put("Name", NameStr);
					map.put("Price", PriceStr);
					map.put("StockNumber", StockNumberStr);
					map.put("OrderPrice", OrderPriceStr);
	
	                dataList.add(map);
	}
	return dataList;
	
	} catch (JSONException e) {
	    e.printStackTrace();
	}
	return null;
	}

	
	}	
			
