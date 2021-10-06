package com.kp.many2one;

import java.util.List;

public interface Many2OneMapper {
    List<Dept> selectDepts();

    void saveDept(Dept dept);
    void saveEmp(Emp emp);
}
