package com.example.domain;

public class GradecalcVO {
	private String uid;
	private String course;
	private int grade; // A~F 등급
	private int score; //성적
	private int base; //전공
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
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
		return "GradecalcVO [uid=" + uid + ", course=" + course + ", grade=" + grade + ", score=" + score + ", base="
				+ base + "]";
	}
	
}
