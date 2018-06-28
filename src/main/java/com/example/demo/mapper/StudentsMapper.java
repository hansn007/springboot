package com.example.demo.mapper;

import com.example.demo.domain.Students;
import com.example.demo.domain.StudentsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentsMapper {
    int countByExample(StudentsExample example);

    int deleteByExample(StudentsExample example);

    int insert(Students record);

    int insertSelective(Students record);

    List<Students> selectByExample(StudentsExample example);

    int updateByExampleSelective(@Param("record") Students record, @Param("example") StudentsExample example);

    int updateByExample(@Param("record") Students record, @Param("example") StudentsExample example);

    List<Students> selectnv();

    List<Students> selectclasses();

    List<Students> selectsname();

    List<Students> selectdegreeavg();

    List<Students> selectsameyear();

    List<Students> selectnotwang();

    List<Students> selectage();

    int updateSbirthday(Students students);

    int insertStudent(Students Students);

    int deleteStudent(Students students);

    List<Students> selectages();

    }