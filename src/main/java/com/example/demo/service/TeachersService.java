package com.example.demo.service;

import com.example.demo.domain.Teachers;
import com.example.demo.entity.StuAndTea;
import com.example.demo.entity.TeaAndCour;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface TeachersService {
    List<Teachers> selectDepart(Teachers teacher);

    List<Teachers> selecttname(Teachers teachers);

    List<StuAndTea> selecetstuandtea();

    List<TeaAndCour> selectteachers();

    List<Teachers> selecttnameandprof();

    int countByExample(Teachers teachers);
}
