package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.domain.Teachers;
import com.example.demo.service.TeachersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/")
public class TeachersController {
    @Autowired
    private TeachersService teachersService;
    @RequestMapping(value="/getdepart")
    public List<Teachers> getTeacherDepart(Teachers teacher){
        List<Teachers> teachers = teachersService.selectDepart(teacher);
        return teachers;
    }
    @RequestMapping(value = "/gettname")
    public String gettname(Teachers teachers){
        return JSON.toJSONString(teachersService.selecttname(teachers));
    }
    @RequestMapping(value = "/getstuandtea")
    public String getstuandtea(){
        return JSON.toJSONString(teachersService.selecetstuandtea());
    }
    @RequestMapping(value = "/getteachers")
    public String getteachers(){
        return JSON.toJSONString(teachersService.selectteachers());
    }

    //没获取到
    @RequestMapping(value = "gettnameandprof")
    public String gettnameandprof(){
        return JSON.toJSONString(teachersService.selecttnameandprof());
    }
    @RequestMapping(value = "/getteacount")
    public int getteacount(Teachers teachers){
        int count = teachersService.countByExample(teachers);
        return count;
    }
    @RequestMapping(value = "getnottea")
    public String getteacount(){
        return JSON.toJSONString(teachersService.selectnottea());
    }
}
