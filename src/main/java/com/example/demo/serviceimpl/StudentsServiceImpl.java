package com.example.demo.serviceimpl;

import com.example.demo.domain.*;
import com.example.demo.entity.StudentScore;
import com.example.demo.mapper.CoursesMapper;
import com.example.demo.mapper.ScoresMapper;
import com.example.demo.mapper.StudentsMapper;
import com.example.demo.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service
@Transactional
public class StudentsServiceImpl implements StudentsService{
    @Autowired
    private StudentsMapper studentsMapper;
    @Autowired
    private ScoresMapper scoresMapper;
    @Autowired
    private CoursesMapper coursesMapper;


    @Override
    public List<Students> selectByExample(Students student) {
        StudentsExample example = new StudentsExample();
        return studentsMapper.selectByExample(example);
    }

    @Override
    public List<StudentScore> selectStudentScore() {
        StudentsExample example = new StudentsExample();
        example.createCriteria().andSnameIsNotNull();
        List<Students> students = studentsMapper.selectByExample(example);
        List<StudentScore> studentScores = new ArrayList<StudentScore>();
        for (Students stu : students) {
            ScoresExample example1 = new ScoresExample();
            example1.createCriteria().andSnoEqualTo(stu.getSno());
            List<Scores> scores = scoresMapper.selectByExample(example1);
            for (Scores s : scores) {
                StudentScore studentScore = new StudentScore();
                studentScore.setSname(stu.getSname());
                studentScore.setCno(s.getCno());
                studentScore.setDegree(s.getDegree());
                studentScores.add(studentScore);
            }
        }
        return studentScores;
    }

    @Override
    public List<StudentScore> selectsname() {
        StudentsExample example = new StudentsExample();
        example.createCriteria().andSnameIsNotNull();
        List<Students> students = studentsMapper.selectByExample(example);
        List<StudentScore> studentScores = new ArrayList<StudentScore>();
        for (Students stu: students){
            ScoresExample example1 =new ScoresExample();
            example1.createCriteria().andSnoEqualTo(stu.getSno());
            List<Scores> scores = scoresMapper.selectByExample(example1);
            for(Scores s : scores){
                CoursesExample example2 = new CoursesExample();
                example2.createCriteria().andCnoEqualTo(s.getCno());
                List<Courses> courses = coursesMapper.selectByExample(example2);
                for(Courses c : courses){
                    StudentScore studentScore = new StudentScore();
                    studentScore.setSname(stu.getSname());
                    studentScore.setCname(c.getCname());
                    studentScore.setDegree(s.getDegree());
                    studentScores.add(studentScore);
                }
            }
        }
        return studentScores;
    }

    @Override
    public List<Students> selectsex(Students students) {
        StudentsExample example = new StudentsExample();
        example.createCriteria().andSnameIsNotNull();
        List<Students> students1 = studentsMapper.selectByExample(example);
        List<Students> students2 = new ArrayList<Students>();
        for (Students stu : students1){
            Students students3 = new Students();
            students3.setClasses(stu.getClasses());
            students3.setSsex(stu.getSsex());
            students2.add(students3);
        }

        return students2;
    }

    @Override
    public List<Students> selectall(Students students) {
        StudentsExample example = new StudentsExample();
        example.createCriteria().andSnameIsNotNull();
        List<Students> students1 = studentsMapper.selectByExample(example);
        List<Students> students2 = new ArrayList<Students>();
        for (Students stu : students1){
            Students students3 = new Students();
            students3.setSname(stu.getSname());
            students3.setSsex(stu.getSsex());
            students3.setClasses(stu.getClasses());
            students2.add(students3);
        }
        return students2;
    }
}
