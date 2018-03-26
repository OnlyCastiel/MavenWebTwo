package com.maofengqiang.service;

import com.maofengqiang.domain.Student;


public interface StudentService {
    Student getStudentByStudentNumber(String studentNum);
	
	Student getStudentByStudentName(String name);
	
    Student getStudentByStudentIdCard(String id);
}
