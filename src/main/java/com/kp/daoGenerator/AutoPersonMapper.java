package com.kp.daoGenerator;

import com.kp.entityGenerator.AutoPerson;

public interface AutoPersonMapper {
    int deleteByPrimaryKey(Integer pid);

    int insert(AutoPerson record);

    int insertSelective(AutoPerson record);

    AutoPerson selectByPrimaryKey(Integer pid);

    int updateByPrimaryKeySelective(AutoPerson record);

    int updateByPrimaryKey(AutoPerson record);
}