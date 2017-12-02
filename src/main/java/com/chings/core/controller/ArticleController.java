package com.chings.core.controller;

import com.alibaba.fastjson.JSONArray;
import com.chings.core.conpont.AbstractController;
import com.chings.core.conpont.Page;
import com.chings.core.exception.UserNotLogin;
import com.chings.core.model.Article;
import com.chings.core.model.User;
import com.chings.core.service.IArticleService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

//import com.alibaba.fastjson.JSONObject;

@Controller
@RequestMapping("/article")
public class ArticleController extends AbstractController<Article>{
	
	@Autowired
	private IArticleService articleService;
	
	@RequestMapping("/page")
	public void pageArticle(HttpServletRequest request,HttpServletResponse res,Model model,int currentPage){

		if(currentPage<=0){
			currentPage = 1;
		}

		Page<Article> page1 = new Page<Article>();
		page1.setCurrentPage(currentPage);

		Page<Article> resultPage = articleService.selectAllArticleByPage(page1);
		
		JSONObject obj =  createJSONObject(0,"",resultPage);
		String result = obj.toString();
		try {
			res.setCharacterEncoding("UTF-8");
			res.getWriter().write(result);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	@RequestMapping("/to_add_article")
	public String toAddArticle(HttpServletRequest request,Model model){
		return "article/article_add";
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public void addArticle(HttpServletResponse res,HttpServletRequest request,Model model,Article artilce){
		long articleId = 0;
		String createResponseString = "";

		try {
			User user = getCurrUser(request.getSession());
			artilce.setUserId(user.id);
			articleId = articleService.insertArticle(artilce);
			createResponseString = createJSONObject(articleId>0?0:-1, artilce.getId()+"","").toString();
			printString(res, createResponseString);
		} catch (Exception e) {
			e.printStackTrace();
			createResponseString = createJSONObject(-1,"failed","").toString();
			printString(res, createResponseString);
		}
		
		
	}
	
	@RequestMapping("/detail")
	public void articleDetail(Model model,HttpServletResponse res,@RequestParam("article_id")int article_id){
		Article article = articleService.selectArticleById(article_id);

		String html = "";

		JSONObject obj = null;
		if(article==null){
			obj =  createJSONObject(1,"文章加载失败","");
		}else{
			obj =  createJSONObject(0,"",article);
		}

		String result = obj.toString();
		try {
			res.setCharacterEncoding("UTF-8");
			res.getWriter().write(result);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	
	@RequestMapping("/types")
	public void selectArticleTypes(HttpServletRequest request,HttpServletResponse res){
		User user = getCurrUser(request.getSession());
		if(user==null){
			printString(res,createJSONObject(new UserNotLogin("用户登录"),"").toString());
			return;
		}

		JSONArray defs = articleService.selectArticleTypes(user.id);
		printString(res,createJSONObject(0,"",defs).toString());
	}

	/**
	 * 管理员页面-文章列表
	 * @return
	 */
	@RequestMapping("/supervisor/article/list")
	@ResponseBody
	public JSONObject managerArticleList(String keywords, Date startdate, Date enddate){

		List<Map> maps = articleService.managerArticles(keywords,startdate,enddate);
		return createJSONObject(0,"ok",maps);

	}


	@RequestMapping("/edit")
	@ResponseBody
	public JSONObject editArticle(HttpServletResponse res,HttpServletRequest request,Article artilce){

		int result = 0;
		JSONObject obj = null;
		try {
			articleService.updateArticle(artilce);
			result = articleService.updateArticle(artilce);
			obj = createJSONObject(result>0?0:-1, "更新成功","");
		} catch (Exception e) {
			e.printStackTrace();
			obj = createJSONObject(-1,"failed","");
		}

		return obj;
	}

	@RequestMapping("/delete")
	public JSONObject deleteArticle(long id){
		long result = 0;
		JSONObject obj = null;
		try {
			result = articleService.deleteArticle(id);
			obj = createJSONObject(result>0?0:-1, "删除成功","");
		} catch (Exception e) {
			e.printStackTrace();
			obj = createJSONObject(-1,"failed","");
		}

		return obj;

	}

	@RequestMapping("/new")
	@ResponseBody
	public JSONObject addEmptyArticle(HttpServletRequest request,int typeId){

		JSONObject obj = null;

		User user = getCurrUser(request.getSession());

		long newId = articleService.addEmptyArticle(user.id,typeId);

		if(newId<=0){
			obj = createJSONObject(-1,"操作失败",newId);
		}else{
			obj = createJSONObject(0,"成功",newId);
		}

		return obj;
	}

	/**
	 * 文章下架
	 * @return
	 */
	@RequestMapping("/articleOff")
	@ResponseBody
	public JSONObject articleOffLine(HttpServletRequest request,int articleId){
		User user = getCurrUser(request.getSession());
		int result = articleService.putArticleOff(user,articleId);
		if(result<=0){
			return createJSONObject(-1,"操作失败",null);
		}else{
			return createJSONObject(0,"成功",null);
		}

	}

	/**
	 * 文章上架
	 * @return
	 */
	@RequestMapping("/articleOn")
	@ResponseBody
	public JSONObject articleOnLine(HttpServletRequest request,int articleId){
		User user = getCurrUser(request.getSession());
		int result = articleService.putArticleOn(user,articleId);
		if(result<=0){
			return createJSONObject(-1,"操作失败",null);
		}else{
			return createJSONObject(0,"成功",null);
		}
	}

	@RequestMapping("/updateViews")
	@ResponseBody
	public JSONObject updateArticleViews(HttpServletRequest request,HttpServletResponse res,long articleId){
		User user = getCurrUser(request.getSession());

		//防止重复记录
		HttpSession session = request.getSession();

		Object hasView = session.getAttribute("articleView_"+articleId);

		if(hasView != null){
			//已经添加了浏览次数
			return createJSONObject(-1,"has viewed","");
		}

		articleService.updateArticleViews(articleId,1);

		session.setAttribute("articleView_"+articleId,1);

		JSONObject obj = createJSONObject(1,"success","");
		return obj;

	}


	
}
