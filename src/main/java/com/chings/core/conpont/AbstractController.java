package com.chings.core.conpont;

import com.chings.core.exception.AbsException;
import com.chings.core.model.User;
import com.chings.core.utils.Constant;
import com.chings.core.utils.JsonDateValueProcessor;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class AbstractController<T> {
	
	protected Page<T> page;
	
	protected String responseString;//响应字符串

	/**
	 *
	 * @param code 状态（0失败，1成功）
	 * @param data
	 * @return
	 */
	public JSONObject createJSONObject(int code,String info,Object data){

		JSONObject jsonObject = new JSONObject();
		Map map = new HashMap<String,Object>();
		map.put("code", code);
		map.put("info", info);
		map.put("data", data);

		//时间格式转换
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());

		jsonObject.putAll(map,jsonConfig);

		return jsonObject;

	}

	public JSONObject createJSONObject(AbsException e, Object data){

		JSONObject jsonObject = new JSONObject();
		Map map = new HashMap<String,Object>();
		map.put("code", e.getCode());
		map.put("info", e.getMsg());
		map.put("data", data);

		//时间格式转换
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());

		jsonObject.putAll(map,jsonConfig);

		return jsonObject;

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

	public User getCurrUser(HttpSession session){
		return (User)session.getAttribute(session.getId());
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
