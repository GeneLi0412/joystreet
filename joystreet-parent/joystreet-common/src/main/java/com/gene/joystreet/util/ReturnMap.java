package com.gene.joystreet.util;

import java.util.HashMap;
import java.util.Map;

public class ReturnMap {
	
	public static Map<String, Object> success(String message, Object object){
		Map<String, Object> base = new HashMap<>();
		base.put("error", false);
		base.put("message", message);
		base.put("data", object);
		return base;
	}
	
	public static Map<String, Object> success(Object object){
		Map<String, Object> base = new HashMap<>();
		base.put("error", false);
		base.put("message", "操作成功");
		base.put("data", object);
		return base;
	}
	
	public static Map<String, Object> success(){
		Map<String, Object> base = new HashMap<>();
		base.put("error", false);
		base.put("message", "操作成功");
		return base;
	}
	
	public static Map<String, Object> error(String message, Object object){
		Map<String, Object> base = new HashMap<>();
		base.put("error", true);
		base.put("message", message);
		base.put("data", object);
		return base;
	}
	
	public static Map<String, Object> error(String message){
		Map<String, Object> base = new HashMap<>();
		base.put("error", true);
		base.put("message", message);
		return base;
	}
	
	public static Map<String, Object> error(Object object){
		Map<String, Object> base = new HashMap<>();
		base.put("error", true);
		base.put("message", "操作失败");
		base.put("data", object);
		return base;
	}
	
	public static Map<String, Object> error(){
		Map<String, Object> base = new HashMap<>();
		base.put("error", true);
		base.put("message", "操作失败");
		return base;
	}
}
