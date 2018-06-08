package com.example.demo.serviceimpl;

import com.example.demo.domain.Courses;
import com.example.demo.domain.CoursesExample;
import com.example.demo.domain.Scores;
import com.example.demo.domain.ScoresExample;
import com.example.demo.entity.CourAndSco;
import com.example.demo.mapper.CoursesMapper;
import com.example.demo.mapper.ScoresMapper;
import com.example.demo.service.ScoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScoresServiceImpl implements ScoresService {
    @Autowired
    private CoursesMapper coursesMapper;
    @Autowired
    private ScoresMapper scoresMapper;

    @Override
    public List<CourAndSco> selectscores() {
        CoursesExample example = new CoursesExample();
        example.createCriteria().andCnoIsNotNull();
        List<Courses> courses = coursesMapper.selectByExample(example);
        List<CourAndSco> courAndScos = new ArrayList<CourAndSco>();
        for(Courses c : courses){
            ScoresExample example1 = new ScoresExample();
            example1.createCriteria().andCnoIsNotNull();
            List<Scores> scores = scoresMapper.selectByExample(example1);
            for( Scores s : scores){
                CourAndSco courAndSco = new CourAndSco();
                courAndSco.setCname(c.getCname());
                courAndSco.setCno(c.getCno());
                courAndSco.setDegree(s.getDegree());
                courAndScos.add(courAndSco);
            }
        }
        return courAndScos;
    }

    @Override
    public List<Scores> selectscore() {
        ScoresExample example = new ScoresExample();
        example.createCriteria().andCnoIsNotNull();
        example.setOrderByClause("cno asc");
        example.setOrderByClause("degree desc");
        List<Scores> scores = scoresMapper.selectByExample(example);
        return scores;
    }

    @Override
    public List<Scores> selectbetween() {
        List<Scores> scores = scoresMapper.selectbetween();
        return scores;
    }

    @Override
    public List<Scores> selectjuti() {
        List<Scores> scores = scoresMapper.selectjuti();
        return scores;
    }

    @Override
    public List<Scores> selectavg() {
        List<Scores> scores = scoresMapper.selectavg();
        return scores;
    }

    @Override
    public List<Scores> selectteascore() {
        List<Scores> scores = scoresMapper.selectteascores();
        return scores;
    }
}
