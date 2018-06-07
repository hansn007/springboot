package com.example.demo.serviceimpl;

import com.example.demo.domain.*;
import com.example.demo.entity.StuAndTea;
import com.example.demo.entity.TeaAndCour;
import com.example.demo.mapper.CoursesMapper;
import com.example.demo.mapper.StudentsMapper;
import com.example.demo.mapper.TeachersMapper;
import com.example.demo.service.TeachersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service
@Transactional
public class TeachersServiceImpl implements TeachersService{

    @Autowired
    private TeachersMapper teachersMapper;
    @Autowired
    private StudentsMapper studentsMapper;
    @Autowired
    private CoursesMapper coursesMapper;
    @Override
    public List<Teachers> selectDepart(Teachers teacher) {
        TeachersExample example = new TeachersExample();
        example.setDistinct(false);
        return teachersMapper.selectByExample(example);
    }

    @Override
    public List<Teachers> selecttname(Teachers teachers) {
        TeachersExample example = new TeachersExample();
        example.createCriteria().andTnameIsNotNull();
        List<Teachers> teachers1 = teachersMapper.selectByExample(example);
        List<Teachers> teachers2 = new ArrayList<Teachers>();
        for(Teachers tea : teachers1){
            Teachers teachers3 = new Teachers();
            teachers3.setTname(tea.getTname());
            teachers3.setDepart(tea.getDepart());
            teachers2.add(teachers3);
        }
        return teachers2;
    }

    @Override
    public List<StuAndTea> selecetstuandtea() {
        StudentsExample example = new StudentsExample();
        example.createCriteria().andSnameIsNotNull();
        List<Students> students = studentsMapper.selectByExample(example);
        TeachersExample example1 = new TeachersExample();
        example1.createCriteria().andTnameIsNotNull();
        List<Teachers> teachers = teachersMapper.selectByExample(example1);
        List<StuAndTea> stuAndTeas = new ArrayList<StuAndTea>();
        StuAndTea stuAndTea = new StuAndTea();
        for (Students stu : students){
            stuAndTea.setSname(stu.getSname());
            stuAndTea.setSsex(stu.getSsex());
            stuAndTea.setSbirthday(stu.getSbirthday());
        }
        for (Teachers tea : teachers){
            stuAndTea.setTname(tea.getTname());
            stuAndTea.setSsex(tea.getTsex());
            stuAndTea.setSbirthday(tea.getTbirthday());
            stuAndTeas.add(stuAndTea);
        }
        return stuAndTeas;
    }

    @Override
    public List<TeaAndCour> selectteachers() {
        TeachersExample example = new TeachersExample();
        example.createCriteria().andTnameIsNotNull();
        List<Teachers> teachers = teachersMapper.selectByExample(example);
        List<TeaAndCour> teaAndCours = new ArrayList<TeaAndCour>();
        for (Teachers tea : teachers){
            CoursesExample example1 = new CoursesExample();
            example1.createCriteria().andCnoIsNotNull();
            List<Courses> courses = coursesMapper.selectByExample(example1);
            for(Courses c : courses){
                TeaAndCour teaAndCour = new TeaAndCour();
                teaAndCour.setTno(tea.getTno());
                teaAndCour.setTname(tea.getTname());
                teaAndCour.setCno(c.getCno());
                teaAndCour.setCname(c.getCname());
                teaAndCours.add(teaAndCour);
            }
        }
        return teaAndCours;
    }
}
