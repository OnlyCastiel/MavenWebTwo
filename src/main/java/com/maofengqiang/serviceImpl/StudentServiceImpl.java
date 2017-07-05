package com.maofengqiang.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maofengqiang.dao.StudentDao;
import com.maofengqiang.domain.Student;
import com.maofengqiang.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired StudentDao studentdao;
	
	@Override
	public Student getStudentByStudentNumber(String studentNum) {
		return studentdao.getStudentByStudentNumber(studentNum);
	}
	
	@Override
	public Student getStudentByStudentName(String name) {
		return studentdao.getStudentByStudentName(name);
	}

	@Override
	public Student getStudentByStudentIdCard(String id) {
		return studentdao.getStudentByStudentIdCard(id);
	}

}
