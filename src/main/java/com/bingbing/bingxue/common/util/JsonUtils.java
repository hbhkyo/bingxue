package com.bingbing.bingxue.common.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.beanutils.BeanMap;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {

	private final static ObjectMapper objectMapper = new ObjectMapper();

	public static String obj2json(Object obj) {
		try {
			return objectMapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static <T> T json2obj(String jsonStr, Class<T> clazz) {
		try {
			return objectMapper.readValue(jsonStr, clazz);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public static Map<String, Object> json2map(String jsonStr) {
		try {
			return objectMapper.readValue(jsonStr, Map.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static <T> Map<String, T> json2map(String jsonStr, Class<T> clazz) {
		try {
			Map<String, Map<String, Object>> map = objectMapper.readValue(
					jsonStr, new TypeReference<Map<String, T>>() {
					});
			Map<String, T> result = new HashMap<String, T>();
			for (Entry<String, Map<String, Object>> entry : map.entrySet()) {
				result.put(entry.getKey(), map2obj(entry.getValue(), clazz));
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static <T> List<T> json2list(String jsonArrayStr, Class<T> clazz) {
		try {
			List<Map<String, Object>> list = objectMapper.readValue(
					jsonArrayStr, new TypeReference<List<T>>() {
					});
			List<T> result = new ArrayList<T>();
			for (Map<String, Object> map : list) {
				result.add(map2obj(map, clazz));
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static <T> T map2obj(Map<String, Object> map, Class<T> clazz) {
		return objectMapper.convertValue(map, clazz);
	}

	public static Map<String, String> obj2map(Object obj) {
		Map<String, String> map = new HashMap<String, String>(); 
		BeanMap beanMap = new BeanMap(obj);
		for (Object key : beanMap.keySet()) {
			if("class".equals((String) key)){
				continue;
			}
            map.put((String) key,(String) beanMap.get(key));  
        }  
		return map;
	}
	
}