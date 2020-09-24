package com.vo;

import java.util.Date;

public class ContentsVO {
	private int id;
	private String title;
	private String content;
	private Date regdate;
	private int cnt;
	private String author;
	
	public ContentsVO() {
	}
	
	public ContentsVO(String title, String content, String author) {
		this.title = title;
		this.content = content;
		this.author = author;
	}

	public ContentsVO(int id, String title, String content) {
		this.id = id;
		this.title = title;
		this.content = content;
	}

	public ContentsVO(String title, String content, int cnt, String author) {
		this.title = title;
		this.content = content;
		this.cnt = cnt;
		this.author = author;
	}

	public ContentsVO(int id, String title, String content, Date regdate, int cnt, String author) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.regdate = regdate;
		this.cnt = cnt;
		this.author = author;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "ContentsVO [id=" + id + ", title=" + title + ", content=" + content + ", regdate=" + regdate + ", cnt="
				+ cnt + ", author=" + author + "]";
	}
	
}






