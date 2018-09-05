package com.subhash.jukebox.skills.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONUtils {

	public static <T> T JSONToObject(String json,Class<T> clazz){
		try {
			
			ObjectMapper mapper = new ObjectMapper();
			return mapper.readValue(json, clazz);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static <T> String ObjectToJSON(T object) {
		
		try {
			ObjectMapper mapper = new ObjectMapper();
			return mapper.writeValueAsString(object);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
