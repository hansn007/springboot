package com.example.demo.service;

import com.example.demo.domain.Students;
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

}
