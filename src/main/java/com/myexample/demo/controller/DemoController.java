package com.myexample.demo.controller;

import com.myexample.demo.bean.Student;
import com.myexample.demo.bean.StudentXML;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @RequestMapping(value = "/getStudentJson", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Student getStudentJson() {
        // 返回User对象，自动转换为JSON
        return new Student();
    }

    @RequestMapping(value = "/getStudentXML", method = RequestMethod.GET, produces = "application/xml;charset=utf-8")
    @ResponseBody
    public StudentXML getStudentXML() {
        // 返回User对象，自动转换为JSON
        StudentXML studentXML = new StudentXML();
        studentXML.setAge(18);
        return studentXML;
    }
}
