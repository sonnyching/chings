package com.chings.core.model;

public class Article {
	
	private int article_id;
	private String article_author;
	private String article_publish_date;
	private String article_last_edit_date;
	private String article_intro;
	private int article_type;
	private int article_definition;
	private String article_content;
	private String article_title;
	
	private String article_definition_name;
	private String article_author_nickname;
	private String article_type_name;
	
	public Article() {
		super();
	}

	public int getArticle_id() {
		return article_id;
	}

	public void setArticle_id(int article_id) {
		this.article_id = article_id;
	}

	public String getArticle_author() {
		return article_author;
	}

	public void setArticle_author(String article_author) {
		this.article_author = article_author;
	}

	public String getArticle_publish_date() {
		return article_publish_date;
	}

	public void setArticle_publish_date(String article_publish_date) {
		this.article_publish_date = article_publish_date;
	}

	public String getArticle_last_edit_date() {
		return article_last_edit_date;
	}

	public void setArticle_last_edit_date(String article_last_edit_date) {
		this.article_last_edit_date = article_last_edit_date;
	}

	public String getArticle_intro() {
		return article_intro;
	}

	public void setArticle_intro(String article_intro) {
		this.article_intro = article_intro;
	}

	public int getArticle_type() {
		return article_type;
	}

	public void setArticle_type(int article_type) {
		this.article_type = article_type;
	}

	public int getArticle_definition() {
		return article_definition;
	}

	public void setArticle_definition(int article_definition) {
		this.article_definition = article_definition;
	}

	public String getArticle_content() {
		return article_content;
	}

	public void setArticle_content(String article_content) {
		this.article_content = article_content;
	}

	public String getArticle_title() {
		return article_title;
	}

	public void setArticle_title(String article_title) {
		this.article_title = article_title;
	}

	public String getArticle_definition_name() {
		return article_definition_name;
	}

	public void setArticle_definition_name(String article_definition_name) {
		this.article_definition_name = article_definition_name;
	}

	public String getArticle_author_nickname() {
		return article_author_nickname;
	}

	public void setArticle_author_nickname(String article_author_nickname) {
		this.article_author_nickname = article_author_nickname;
	}

	public String getArticle_type_name() {
		return article_type_name;
	}

	public void setArticle_type_name(String article_type_name) {
		this.article_type_name = article_type_name;
	}
	
}
