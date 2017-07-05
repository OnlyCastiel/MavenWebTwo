package com.maofengqiang.service;

import com.maofengqiang.domain.Student;


public interface StudentService {
	public Student getStudentByStudentNumber(String studentNum);
	
	public Student getStudentByStudentName(String name);
	
	public Student getStudentByStudentIdCard(String id);
}
