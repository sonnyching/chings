package com.chings.core.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Article {

	public long id;
	public long userId;
	public long type;
	public String title;
	public String content;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	public Date createTime;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	public Date updateTime;

	//以下用户对外展示
	public String authorName;
	public String typeName;

	public int status;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getType() {
		return type;
	}

	public void setType(long type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	//	private int article_id;
//	private String article_author;
//	private String article_publish_date;
//	private String article_last_edit_date;
//	private String article_intro;
//	private int article_type;
//	private int article_definition;
//	private String article_content;
//	private String article_title;
//
//	private String article_definition_name;
//	private String article_author_nickname;
//	private String article_type_name;
	
}
