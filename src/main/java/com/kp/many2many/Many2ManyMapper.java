package com.kp.many2many;

import org.apache.ibatis.annotations.Param;

public interface Many2ManyMapper {
    //保存权限 权限组 已经权限的关系
    void savePrivelege(Privelege pri);
    void saveGroups (Groups group);
    void savePriRelGroups(@Param("gid") int gid, @Param("pid") int pid);
}
