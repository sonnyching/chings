package com.chings.core.conpont;

import com.chings.core.model.User;
import com.chings.core.utils.Constant;
import net.sf.json.JSONObject;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

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
		jsonObject.put("code", code);
		jsonObject.put("info", info);
		jsonObject.put("data", data);

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
		return (User)session.getAttribute(Constant.PRE_LOGIN+session.getId());
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
