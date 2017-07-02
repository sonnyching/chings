package com.chings.core.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.markdown4j.Markdown4jProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
import com.chings.core.conpont.AbstractController;
import com.chings.core.conpont.Page;
import com.chings.core.model.Article;
import com.chings.core.service.IArticleService;

@Controller
@RequestMapping("/article")
public class ArticleController extends AbstractController<Article>{
	
	@Autowired
	private IArticleService articleService;
	
	@RequestMapping("/page")
	public String pageArticle(HttpServletRequest request,HttpServletResponse res,Model model,Page<Article> page){
		
		Page<Article> resultPage = articleService.selectAllArticleByPage(page);
		
		res.setCharacterEncoding("UTF-8");
		model.addAttribute("page",resultPage);
		
		return "article/pageArticle";
	}
	
	@RequestMapping("/to_add_article")
	public String toAddArticle(HttpServletRequest request,Model model){
		return "article/article_add";
	}
	
	@RequestMapping("/add_article")
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
	public String checkArticleDetail(Model model,@RequestParam("article_id")int article_id){
		Article article = articleService.selectArticleById(article_id);
		if(article==null){
			return "error404";
		}
		String html = "";
		try {
			html = new Markdown4jProcessor().process(article.getArticle_content());
		} catch (IOException e) {
			html = "数据解析失败！";
		}
		article.setArticle_content(html);
		model.addAttribute("article", article);
		return "article/article_detail";
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
