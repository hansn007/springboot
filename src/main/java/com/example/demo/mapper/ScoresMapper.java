package com.example.demo.mapper;

import com.example.demo.domain.Scores;
import com.example.demo.domain.ScoresExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoresMapper {
    int countByExample(ScoresExample example);

    int deleteByExample(ScoresExample example);

    int insert(Scores record);

    int insertSelective(Scores record);

    List<Scores> selectByExample(ScoresExample example);

    int updateByExampleSelective(@Param("record") Scores record, @Param("example") ScoresExample example);

    int updateByExample(@Param("record") Scores record, @Param("example") ScoresExample example);

    List<Scores> selectbetween();

    List<Scores> selectjuti();

    List<Scores> selectavg();

    List<Scores> selectteascores();

    List<Scores> selectdegreedesc();

    List<Scores> selectrecord();
}