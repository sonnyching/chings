package com.chings.core.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.chings.core.conpont.Page;
import com.chings.core.dao.IArticleDao;
import com.chings.core.model.Article;
import com.chings.core.service.IArticleService;

@Service
public class ArticleServiceImpl implements IArticleService {
	
	@Autowired
	private IArticleDao articleDao;
	
	@Override
	public Page<Article> selectAllArticleByPage(Page<Article> page) {
		if(page!=null){
			
			List<Article> list = articleDao.selectAllArticleByPage(page);
			int countArticles = articleDao.countArticles();
			page.setList(list);
			page.init(countArticles);
			return page;
		}
		return null;
	}

	
	
	@Override
	public Article selectArticleById(int id) {
		if(id==0){
			return null;
		}
		Article article = articleDao.selectArticleById(id);
		return article;
	}


	@Override
	public long insertArticle(Article article) {
		if(article==null){
			return 0;
		}
		Date now = new Date();
		article.setCreateTime(now);
		article.setUpdateTime(now);
		return articleDao.insertArticle(article);
	}

	@Override
	public boolean deleteArticle(int artilce_id) {
		if(artilce_id==0){
			return false;
		}
		int result = articleDao.deleteArticle(artilce_id);
		return result>0?true:false;
	}

	@Override
	public boolean updateArticle(Article artilce) {
		if(artilce==null){
			return false;
		}
		int result = articleDao.updateArticle(artilce);
		return result>0?true:false;
	}
	
	@Override
	public JSONArray selectArticleDefs(){
		List<Map> defs =  articleDao.selectArticleDefs();
		JSONArray array = new JSONArray();
		if(defs!=null && defs.size()>0){
			for (Map map : defs) {
				int dict_id = (int) map.get("dict_id");
				String dict_name = (String) map.get("dict_name");
				JSONObject object = new JSONObject();
				object.put("dict_id", dict_id);
				object.put("dict_name", dict_name);
				array.add(object);
			}
		}
		return array;
	}
	
	@Override
	public JSONArray selectArticleTypes(long userId){
		List<Map> types = articleDao.selectArticleTypes(userId);
		JSONArray array = new JSONArray();
		if(types!=null && types.size()>0){
			for (Map map : types) {
				long dict_id = (long) map.get("id");
				String dict_name = (String) map.get("name");
				JSONObject object = new JSONObject();
				object.put("id", dict_id);
				object.put("name", dict_name);
				array.add(object);
			}
		}
		return array;
	}
	

}
