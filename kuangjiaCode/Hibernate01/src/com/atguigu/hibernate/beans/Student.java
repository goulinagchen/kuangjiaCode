package com.atguigu.hibernate.beans;

import java.util.Date;

public  class Student {
	private Integer studentId;
	private String studentName ;
	private Integer age ;
	
	private String email ;
	
	//private Date birthday ;
	
	
//	public Date getBirthday() {
//		return birthday;
//	}
//	public void setBirthday(Date birthday) {
//		this.birthday = birthday;
//	}
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	public Student(String studentName, Integer age, String email) {
		super();
		this.studentName = studentName;
		this.age = age;
		this.email = email;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", age=" + age + "]";
	} 
	
	
	
}
