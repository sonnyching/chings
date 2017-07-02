package com.chings.core.service;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.chings.core.conpont.Page;
import com.chings.core.model.Article;

public interface IArticleService {
	
	public Page<Article> selectAllArticleByPage(Page<Article> page);
	
	public Article selectArticleById(int id);
	
	public boolean insertArticle(Article artilce);
	
	public boolean deleteArticle(int artilce_id);
	
	public boolean updateArticle(Article artilce);
	
	public JSONArray selectArticleDefs();
	
	public JSONArray selectArticleTypes();
	
}
