package com.example.demo.service;

import com.example.demo.domain.Students;
import com.example.demo.domain.StudentsExample;
import com.example.demo.entity.StudentScore;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface StudentsService {
   List<Students> selectByExample(Students student);

   List<StudentScore> selectStudentScore();

   List<StudentScore> selectsname();

   List<Students> selectsex(Students students);

   List<Students> selectall(Students students);

   List<Students> selectdesc();

   List<Students> selectnv();

   List<Students> selectclasses();

   List<Students> selectsamesname();

   List<Students> selectdegreeavg();

   int countByExample(Students students);

   List<Students> selectsameyear();

   List<Students> selectnotwang();

   List<Students> selectage();

   int updateSbirthday(Students students);

   int insertStudent(Students students);

   int insertStudents(Students Students);

   int deleteStudent(Students students);

   int deleteByExample(StudentsExample example);

   List<Students> selectages();

}
