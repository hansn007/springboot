package com.example.demo.serviceimpl;

import ch.qos.logback.core.joran.spi.ConsoleTarget;
import ch.qos.logback.core.net.SyslogOutputStream;
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
            students3.setClasses(stu.getClasses());
            students3.setSname(stu.getSname());
            students3.setSsex(stu.getSsex());
            students2.add(students3);
        }
        return students2;
    }

    @Override
    public List<Students> selectdesc() {
        StudentsExample example = new StudentsExample();
        example.createCriteria().andSnameIsNotNull();
        example.setOrderByClause("classes desc");
        List<Students> students = studentsMapper.selectByExample(example);
        return students;
    }

    @Override
    public List<Students> selectnv() {
        List<Students> students = studentsMapper.selectnv();
        return students;
    }

    @Override
    public List<Students> selectclasses() {
        List<Students> students = studentsMapper.selectclasses();
        return students;
    }

    @Override
    public List<Students> selectsamesname() {
        List<Students> students = studentsMapper.selectsname();
        return null;
    }

    @Override
    public List<Students> selectdegreeavg() {
        List<Students> students = studentsMapper.selectdegreeavg();
        return students;
    }

    @Override
    public int countByExample(Students students) {
        StudentsExample example = new StudentsExample();
        int count = studentsMapper.countByExample(example);
        return count;
    }

    @Override
    public List<Students> selectsameyear() {
        List<Students> students = studentsMapper.selectsameyear();
        return students;
    }

    @Override
    public List<Students> selectnotwang() {
        System.out.println(studentsMapper.selectnotwang());
        List<Students> students = studentsMapper.selectnotwang();
        return students;
    }

    @Override
    public List<Students> selectage() {
        List<Students> students = studentsMapper.selectage();
        return students;
    }
}
