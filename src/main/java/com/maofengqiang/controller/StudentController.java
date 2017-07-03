package com.maofengqiang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.maofengqiang.domain.Student;
import com.maofengqiang.serviceImpl.StudentServiceImpl;

@Controller
public class StudentController {
	
	@Autowired StudentServiceImpl studentServiceImpl;
	
	@RequestMapping(value="findStudent")
	public String findStudent(){
		System.out.println("进入请求findStudent");
		Student student = null;
		student = studentServiceImpl.getStudentByStudentIdCard("632224199301052325");
		System.out.println(student);
		return "findStudent";
	}
}
