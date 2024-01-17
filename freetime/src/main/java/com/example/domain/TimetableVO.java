package com.example.domain;

public class TimetableVO {
	private String uid;
	private int gid;
	private String gscore;
	private String gcredit;
	private String ggrade;
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public String getGscore() {
		return gscore;
	}
	public void setGscore(String gscore) {
		this.gscore = gscore;
	}
	public String getGcredit() {
		return gcredit;
	}
	public void setGcredit(String gcredit) {
		this.gcredit = gcredit;
	}
	public String getGgrade() {
		return ggrade;
	}
	public void setGgrade(String ggrade) {
		this.ggrade = ggrade;
	}
	
	@Override
	public String toString() {
		return "TimetableVO [uid=" + uid + ", gid=" + gid + ", gscore=" + gscore + ", gcredit=" + gcredit + ", ggrade="
				+ ggrade + "]";
	}
	
}


	
