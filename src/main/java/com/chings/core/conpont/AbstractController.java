package com.chings.core.conpont;

import net.sf.json.JSONObject;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AbstractController<T> {
	
	protected Page<T> page;
	
	protected String responseString;//响应字符串
	
	/**
	 *
	 * @param code 状态（0失败，1成功）
	 * @param info
	 * @return
	 */
	public String createResponseString(int code,String info ){

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("code", code);
		jsonObject.put("info", info);

		return jsonObject.toString();

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
