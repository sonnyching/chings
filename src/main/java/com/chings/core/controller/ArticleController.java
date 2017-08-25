package com.chings.core.controller;

import com.alibaba.fastjson.JSONArray;
import com.chings.core.conpont.AbstractController;
import com.chings.core.conpont.Page;
import com.chings.core.model.Article;
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
import java.io.IOException;

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
		
		JSONObject obj =  createJSONObject(1,resultPage);
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
	
	@RequestMapping("/add_article")
	@ResponseBody
	public void addArticle(HttpServletResponse res,Model model,Article artilce){
		boolean isSuccess = false;
		String createResponseString = "";
		try {
			isSuccess = articleService.insertArticle(artilce);
			createResponseString = createResponseString(isSuccess?1:0, isSuccess?"success":"failed");
			res.setCharacterEncoding("UTF-8");
			printString(res, createResponseString);
		} catch (Exception e) {
			e.printStackTrace();
			createResponseString = createResponseString(0,"failed");
			printString(res, createResponseString);
		}
		
		
	}
	
	@RequestMapping("/detail")
	@ResponseBody
	public void checkArticleDetail(Model model,HttpServletResponse res,@RequestParam("article_id")int article_id){
		Article article = articleService.selectArticleById(article_id);

		String html = "";
//		PegDownProcessor md = new PegDownProcessor();
//		html = md.markdownToHtml(article.getArticle_content());
//		try {
//
//			//html = new Markdown4jProcessor().process(article.getArticle_content());
//		} catch (IOException e) {
//			html = "";
//		}
//		article.setArticle_content(html);

		JSONObject obj =  createJSONObject(1,article);
		String result = obj.toString();
		try {
			res.setCharacterEncoding("UTF-8");
			res.getWriter().write(result);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	@RequestMapping("/article_defs")
	public void selectArticleDefs(HttpServletResponse res){
		JSONArray defs = articleService.selectArticleDefs();
		printString(res, defs.toJSONString());
		
	}
	
	@RequestMapping("/article_types")
	public void selectArticleTypes(HttpServletResponse res){
		JSONArray defs = articleService.selectArticleTypes();
		printString(res, defs.toJSONString());
	}
	
	
	
}
