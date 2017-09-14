package com.chings.core.dao;

import com.chings.core.conpont.Page;
import com.chings.core.model.Article;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;


public interface IArticleDao {
	
	public List<Article> selectAllArticleByPage(Page<Article> page);
	
	public List<Article> selectArticles();
	
	public Article selectArticleById(int id);
	
	public long insertArticle(Article artilce);
	
	public int deleteArticle(int artilce_id);
	
	public int updateArticle(Article artilce);
	
	public List<Map> selectArticleDefs();
	
	public List<Map> selectArticleTypes(long userId);
	
	public int countArticles();

	public List<Map> managerArticles(@Param("keywords")String keywords, @Param("startDate")Date startDate, @Param("endDate")Date endDate);
	
	
}
