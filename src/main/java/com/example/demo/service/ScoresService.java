package com.example.demo.service;

import com.example.demo.domain.Scores;
import com.example.demo.entity.CourAndSco;

import java.util.List;

public interface ScoresService {
    List<CourAndSco> selectscores();

    List<Scores> selectscore();

    List<Scores> selectbetween();

    List<Scores> selectjuti();
}
