package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.domain.Students;
import com.example.demo.service.ScoresService;
import com.example.demo.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/")
public class StudentsController {
    @Autowired
    private StudentsService studentsService;

    @RequestMapping(value = "getstu")
    public List<Students> getStu(Students Student) {
        List<Students> students = studentsService.selectByExample(Student);
        return students;
    }

    @RequestMapping(value = "/stusco")
    public String getStuSco() {
        return JSON.toJSONString(studentsService.selectStudentScore());
    }

    @RequestMapping(value = "/getsname")
    public String getsnaame() {
        return JSON.toJSONString(studentsService.selectsname());
    }
    @RequestMapping(value = "/getsex")
    public String getsex(Students students){
        return JSON.toJSONString(studentsService.selectsex(students));
    }
    @RequestMapping(value = "/getall")
    public String getall(Students students){
        return JSON.toJSONString(studentsService.selectall(students));
    }

}
