package com.example.domain;

import java.util.Date;

public class PCommentsVO {
	private int pcid;
	private int pid;
	private String writer;
	private String body;
	private Date regdate;
	
	public int getPcid() {
		return pcid;
	}
	public void setPcid(int pcid) {
		this.pcid = pcid;
	}
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
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	@Override
	public String toString() {
		return "PCommentsVO [pcid=" + pcid + ", pid=" + pid + ", writer=" + writer + ", body=" + body + ", regdate="
				+ regdate + "]";
	}

}
