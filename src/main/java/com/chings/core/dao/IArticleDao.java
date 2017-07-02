package com.chings.core.dao;

import java.util.List;
import java.util.Map;

import com.chings.core.conpont.Page;
import com.chings.core.model.Article;


public interface IArticleDao {
	
public List<Article> selectAllArticleByPage(Page<Article> page);
	
	public List<Article> selectArticles();
	
	public Article selectArticleById(int id);
	
	public int insertArticle(Article artilce);
	
	public int deleteArticle(int artilce_id);
	
	public int updateArticle(Article artilce);
	
	public List<Map> selectArticleDefs();
	
	public List<Map> selectArticleTypes();
	
	public int countArticles();
	
	
}
