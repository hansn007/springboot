package com.example.demo.mapper;

import com.example.demo.domain.Teachers;
import com.example.demo.domain.TeachersExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TeachersMapper {
    int countByExample(TeachersExample example);

    int deleteByExample(TeachersExample example);

    int insert(Teachers record);

    int insertSelective(Teachers record);

    List<Teachers> selectByExample(TeachersExample example);

    int updateByExampleSelective(@Param("record") Teachers record, @Param("example") TeachersExample example);

    int updateByExample(@Param("record") Teachers record, @Param("example") TeachersExample example);

    List<Teachers> selecttnameandprof();

    List<Teachers> selectnottea();

}