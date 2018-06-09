package com.example.demo.serviceimpl;

import com.example.demo.domain.Courses;
import com.example.demo.domain.CoursesExample;
import com.example.demo.domain.Scores;
import com.example.demo.domain.ScoresExample;
import com.example.demo.entity.StudentScore;
import com.example.demo.mapper.CoursesMapper;
import com.example.demo.mapper.ScoresMapper;
import com.example.demo.service.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CoursesServiceImpl implements CoursesService{
    @Autowired
    private ScoresMapper scoresMapper;
    @Autowired
    private CoursesMapper coursesMapper;

    @Override
    public List<StudentScore> selectScores() {
        CoursesExample example = new CoursesExample();
        example.createCriteria().andCnoIsNotNull();
        List<Courses> courses = coursesMapper.selectByExample(example);
        List<StudentScore> studentScores = new ArrayList<StudentScore>();
        for(Courses c : courses){
            ScoresExample example1 = new ScoresExample();
            example1.createCriteria().andCnoEqualTo(c.getCno());
            List<Scores> scores = scoresMapper.selectByExample(example1);
            for(Scores s : scores){
                StudentScore studentScore = new StudentScore();
                studentScore.setCno(c.getCno());
                studentScore.setCname(c.getCname());
                studentScore.setDegree(s.getDegree());
                studentScores.add(studentScore);
            }
        }
        return studentScores;
    }

    @Override
    public List<Courses> selectcno() {
        List<Courses> courses = coursesMapper.selectcno();
        return courses;
    }

    @Override
    public int countByExample() {
        CoursesExample example = new CoursesExample();
        int count = coursesMapper.countByExample(example);
        return count;
    }
}
