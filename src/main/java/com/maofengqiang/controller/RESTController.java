package com.maofengqiang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.maofengqiang.domain.Student;
import com.maofengqiang.serviceImpl.StudentServiceImpl;

@RestController
public class RESTController {
	
	@Autowired StudentServiceImpl studentServiceImpl;
	
	@RequestMapping(value="/student/{studentNun}",method=RequestMethod.GET)
	public Student getbyName(@PathVariable("studentNun")String studentNun){
		//具体代码略
		System.out.println("接收到Get请求");
/*		Student stu = null;
		stu=studentServiceImpl.getStudentByStudentNumber(studentNun);*/
        Student stu = new Student();
        stu.setName("张三");
		return stu;
	}
	
	@RequestMapping(value="/student",method=RequestMethod.PUT)
	public String putStudent(){
		//具体代码略
		System.out.println("接收到Put请求");
		return "服务器收到put请求";
	}
	
	@RequestMapping(value="/student/{studentName}",method=RequestMethod.DELETE)
	public String deleteStudent(@PathVariable("studentName")String studentName){
		//具体代码略
		System.out.println("接收到Delete请求:"+studentName);
		return "服务器收到delete请求";
	}
	
	@RequestMapping(value="/student",method=RequestMethod.POST)
	public String postStudent(){
		//具体代码略
		System.out.println("接收到POST请求:");
		return "服务器收到post请求";
	}
}
