package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.service.ScoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping(value="/")
public class ScoresController {
    @Autowired
    private ScoresService scoresService;

    @RequestMapping(value = "/getscores")
    public String getscores(){
        return JSON.toJSONString(scoresService.selectscores());
    }

    @RequestMapping(value = "/getscore")
    public String getscore(){
        return JSON.toJSONString(scoresService.selectscore());
    }

    @RequestMapping(value = "getbetween")
    public String getbetween(){
        return JSON.toJSONString(scoresService.selectbetween());
    }
    @RequestMapping(value = "getjuti")
    public String getjuti(){
        return JSON.toJSONString(scoresService.selectjuti());
    }

    //控制台有输出，postman获取的是null
    @RequestMapping(value="getavg")
    public String getavg(){
        return JSON.toJSONString(scoresService.selectavg());
    }

    //有点小问题
    @RequestMapping(value = "getteascores")
    public String getteascores(){
        return JSON.toJSONString(scoresService.selectteascore());
    }

    //控制台有输出，postman获取的是null
    @RequestMapping(value = "getdegreedesc")
    public String getdegreedesc(){
        return JSON.toJSONString(scoresService.selectdegreedesc());
    }
    @RequestMapping(value = "getrecord")
    public String getrecord(){
        return JSON.toJSONString(scoresService.selectrecord());
    }
}
