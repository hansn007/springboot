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
}
