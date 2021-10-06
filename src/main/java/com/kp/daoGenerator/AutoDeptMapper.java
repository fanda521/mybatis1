package com.kp.daoGenerator;

import com.kp.entityGenerator.AutoDept;

public interface AutoDeptMapper {
    int deleteByPrimaryKey(Integer did);

    int insert(AutoDept record);

    int insertSelective(AutoDept record);

    AutoDept selectByPrimaryKey(Integer did);

    int updateByPrimaryKeySelective(AutoDept record);

    int updateByPrimaryKey(AutoDept record);
}