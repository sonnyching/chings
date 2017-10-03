package com.chings.core.service;

import com.alibaba.fastjson.JSONArray;
import com.chings.core.conpont.Page;
import com.chings.core.model.Article;
import com.chings.core.model.User;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface IArticleService {
	
	public Page<Article> selectAllArticleByPage(Page<Article> page);
	
	public Article selectArticleById(int id);
	
	public long insertArticle(Article artilce);
	
	public int deleteArticle(long id);
	
	public int updateArticle(Article artilce);
	
	public JSONArray selectArticleDefs();
	
	public JSONArray selectArticleTypes(long userId);

	public List<Map> managerArticles(String keywords, Date startDate, Date endDate);

	public long addEmptyArticle(long userId,long type);

	public int putArticleOff(User user, long articleId);

	public int putArticleOn(User user, long articleId);

}
