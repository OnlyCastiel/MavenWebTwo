package com.maofengqiang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.maofengqiang.domain.Student;
import com.maofengqiang.serviceImpl.StudentServiceImpl;

@Controller
public class StudentController {
	
	@Autowired StudentServiceImpl studentServiceImpl;
	
	@RequestMapping(value="findStudent",method = RequestMethod.GET)
	public String findStudent(){
		return "findStudent";
	}
	
	@RequestMapping(value="findStudent",method = RequestMethod.POST)
	public ModelAndView findStudent(String name){
		ModelAndView model = new ModelAndView();
		Student student = null;
		student = studentServiceImpl.getStudentByStudentName(name);
		
		model.addObject(student);
		model.setViewName("studentInfo");
		return model;
	}
}
