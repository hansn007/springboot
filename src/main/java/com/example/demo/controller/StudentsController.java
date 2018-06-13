package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.domain.Students;
import com.example.demo.domain.StudentsExample;
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
    @RequestMapping(value = "getstudesc")
    public String getstudesc(){
        return JSON.toJSONString(studentsService.selectdesc());
    }
    @RequestMapping(value = "getnv")
    public String getnv(){
        return JSON.toJSONString(studentsService.selectnv());
    }
    @RequestMapping(value = "getclasses")
    public String getclasses(){
        return JSON.toJSONString(studentsService.selectclasses());
    }

    //没能获取到
    @RequestMapping(value = "/getsamename")
    public String getsnamename(){
        return JSON.toJSONString(studentsService.selectsamesname());
    }
    //控制台有输出，postman获取的是null
    @RequestMapping(value = "/getdegreeavg")
    public String getdegreeavg(){
        return JSON.toJSONString(studentsService.selectdegreeavg());
    }
    @RequestMapping(value = "getstucount")
    public int countByExample(Students students ){
        int count = studentsService.countByExample(students);
        return count;
    }
    @RequestMapping(value = "getsameyear")
    public String getsameyear(){
        return JSON.toJSONString(studentsService.selectsameyear());
    }
    @RequestMapping(value = "notwang")
    public String selectnotwang(){
        return JSON.toJSONString(studentsService.selectnotwang());
    }
    @RequestMapping(value = "getage")
    public String getage(){
        return JSON.toJSONString(studentsService.selectage());
    }
    @RequestMapping(value = "updatesbirthday")
    public int updateSbirthday(Students students){
        return studentsService.updateSbirthday(students);
    }

    //有点小问题
    @RequestMapping(value = "insertstudent")
    public int insertStudents(Students students){
        return studentsService.insertStudent(students);
    }
    @RequestMapping(value = "insertstudents")
    public int insertstudents(Students students){
        return studentsService.insertStudents(students);
    }
    @RequestMapping(value = "delectstudent")
    public int delectstudent(Students students){
        return studentsService.deleteStudent(students);
    }
    @RequestMapping(value = "delectbyexample")
    public int delectByExample(StudentsExample example){
        return studentsService.deleteByExample(example);
    }
}