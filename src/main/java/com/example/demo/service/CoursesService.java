package com.example.demo.service;


import com.example.demo.domain.Courses;
import com.example.demo.entity.StudentScore;

import java.util.List;

public interface CoursesService {
    List<StudentScore> selectScores();

    List<Courses> selectcno();
}
