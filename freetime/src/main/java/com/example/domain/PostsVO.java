package com.example.domain;

import java.util.Date;

public class PostsVO {
	private int pid;
	private String writer;
	private String title;
	private String contents;
	private Date regdate;
	private int vcnt;
	private int rcnt; 
	private int fcnt;
	private String image;
	private String postsId;
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getVcnt() {
		return vcnt;
	}
	public void setVcnt(int vcnt) {
		this.vcnt = vcnt;
	}
	public int getRcnt() {
		return rcnt;
	}
	public void setRcnt(int rcnt) {
		this.rcnt = rcnt;
	}
	public int getFcnt() {
		return fcnt;
	}
	public void setFcnt(int fcnt) {
		this.fcnt = fcnt;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getPostsId() {
		return postsId;
	}
	public void setPostsId(String postsId) {
		this.postsId = postsId;
	}
	
	@Override
	public String toString() {
		return "PostsVO [pid=" + pid + ", writer=" + writer + ", title=" + title + ", contents=" + contents
				+ ", regdate=" + regdate + ", vcnt=" + vcnt + ", rcnt=" + rcnt + ", fcnt=" + fcnt + ", image=" + image
				+ ", postsId=" + postsId + "]";
	}
}
