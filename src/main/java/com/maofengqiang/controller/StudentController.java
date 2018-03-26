package com.maofengqiang.controller;

import com.maofengqiang.service.StudentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.maofengqiang.domain.Student;
import com.maofengqiang.serviceImpl.StudentServiceImpl;

@Controller
public class StudentController {

    private static final Logger logger = Logger.getLogger(StudentController.class);

	@Autowired
    StudentServiceImpl studentServiceImpl;
	
	@RequestMapping(value="findStudent",method = RequestMethod.GET)
	public String findStudent(){
		return "findStudent";
	}
	
	@RequestMapping(value="findStudent",method = RequestMethod.POST)
	public ModelAndView findStudent(String name){
		ModelAndView model = new ModelAndView();
        Student student;
		try {
            student = studentServiceImpl.getStudentByStudentName(name);
            model.addObject(student);
        }catch (Exception e){
            logger.error("获取学生信息出错",e);
        }
		model.setViewName("studentInfo");
		return model;
	}
}
