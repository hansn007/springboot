package com.example.demo.mapper;

import com.example.demo.domain.Courses;
import com.example.demo.domain.CoursesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CoursesMapper {
    int countByExample(CoursesExample example);

    int deleteByExample(CoursesExample example);

    int insert(Courses record);

    int insertSelective(Courses record);

    List<Courses> selectByExample(CoursesExample example);

    int updateByExampleSelective(@Param("record") Courses record, @Param("example") CoursesExample example);

    int updateByExample(@Param("record") Courses record, @Param("example") CoursesExample example);

    List<Courses> selectcno();

}