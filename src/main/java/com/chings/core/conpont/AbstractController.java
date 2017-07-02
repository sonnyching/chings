package com.chings.core.conpont;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;

public class AbstractController<T> {
	
	protected Page<T> page;
	
	protected String responseString;//响应字符串
	
	/**
	 * 
	 * @param state 状态（0失败，1成功）
	 * @param info
	 * @return
	 */
	public String createResponseString(int state,String info ){
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("state", state);
		jsonObject.put("info", info);
		
		return jsonObject.toJSONString();
		
	}
	
	/**
	 * 向前端返回字符串
	 */
	public void printString(HttpServletResponse res,String str){
		res.setCharacterEncoding("UTF-8");
		PrintWriter writer = null;
		try {
			writer = res.getWriter();
			writer.println(str);
		} catch (IOException e) {
			
		}
	}
	
//	/**
//	 * 向前端返回字符串
//	 */
//	public void printJsonString(HttpServletResponse res,List<>){
//		res.setCharacterEncoding("UTF-8");
//		PrintWriter writer = null;
//		try {
//			writer = res.getWriter();
//			writer.println(str);
//		} catch (IOException e) {
//			
//		}
//	}
//	
	
	
}
