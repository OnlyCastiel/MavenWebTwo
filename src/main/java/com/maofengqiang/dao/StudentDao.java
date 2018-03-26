package com.maofengqiang.dao;

import com.maofengqiang.domain.Student;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentDao {
    Student getStudentByStudentNumber(String studentNum);
	
    Student getStudentByStudentName(String name);
	
    Student getStudentByStudentIdCard(String id);
}
