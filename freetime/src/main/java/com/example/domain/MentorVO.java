package com.example.domain;

public class MentorVO {
	private String mtid;
	private String uid;
	private String mid;
	
	public String getMtid() {
		return mtid;
	}
	public void setMtid(String mtid) {
		this.mtid = mtid;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	@Override
	public String toString() {
		return "MentorVO [mtid=" + mtid + ", uid=" + uid + ", mid=" + mid + "]";
	}
	
}
