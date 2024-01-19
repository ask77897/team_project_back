package com.example.domain;

public class GradecalcVO {
	private String uid;
	private int gid;
	private String courses;
	private int grade; // A~F 등급
	private int score; //성적
	private int base; //전공
	
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
	public String getCourses() {
		return courses;
	}
	public void setCourses(String courses) {
		this.courses = courses;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getBase() {
		return base;
	}
	public void setBase(int base) {
		this.base = base;
	}
	
	@Override
	public String toString() {
		return "GradecalcVO [uid=" + uid + ", gid=" + gid + ", courses=" + courses + ", grade=" + grade + ", score="
				+ score + ", base=" + base + "]";
	}
}
