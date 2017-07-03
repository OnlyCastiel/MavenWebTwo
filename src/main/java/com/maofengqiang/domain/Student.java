package com.maofengqiang.domain;

public class Student {
	private String StudentNumber;
	private String name;
	private String sex;
	private String idCard;
	private String grade;
	private String majorClass;
	
	
	public String getStudentNumber() {
		return StudentNumber;
	}
	public void setStudentNumber(String studentNumber) {
		StudentNumber = studentNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getMajorClass() {
		return majorClass;
	}
	public void setMajorClass(String majorClass) {
		this.majorClass = majorClass;
	}
	@Override
	public String toString() {
		return "Student [StudentNumber=" + StudentNumber + ", name=" + name
				+ ", sex=" + sex + ", idCard=" + idCard + ", grade=" + grade
				+ ", majorClass=" + majorClass + "]";
	}
	
	
}
