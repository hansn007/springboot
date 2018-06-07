package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.service.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class CourseController {
    @Autowired
    private CoursesService coursesService;

    @RequestMapping(value="getcno")
    public String stucno(){
        return JSON.toJSONString(coursesService.selectScores());

    }
}
