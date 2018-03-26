package com.maofengqiang.api;


import com.maofengqiang.domain.Student;
import com.maofengqiang.service.StudentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class StudentApi {

    private static final Logger logger = Logger.getLogger(StudentApi.class);

    @Autowired
    StudentService studentService;

    @RequestMapping("/getStudentInfoByName")
    @ResponseBody
    public Map<String,Object> getStudentInfoByName(String stuName){
        Map<String,Object> retMap = new HashMap<>();
        try {
            Student student = studentService.getStudentByStudentName(stuName);
            retMap.put("data",student);
        }catch (Exception e){
            logger.error("获取学生信息出错",e);
        }
        return retMap;
    }



}
