package com.maofengqiang.dao;

import com.maofengqiang.domain.Student;

public interface StudentDao {
	public Student getStudentByStudentNumber(String studentNum);
	
	public Student getStudentByStudentIdCard(String id);
}
