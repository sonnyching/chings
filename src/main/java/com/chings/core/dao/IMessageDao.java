package com.chings.core.dao;

import com.chings.core.conpont.Page;
import com.chings.core.model.Article;

import java.util.List;


public interface IMessageDao {
	
public List<Article> selectAllArticleByPage(Page<Article> page);
	

	
	
}
