package com.kp.many2many;

import java.util.ArrayList;
import java.util.List;

public class Privelege {
    private Integer pid;
    private String pname;//权限名称
    private String mname;//模块的名称
    //描述多对的关系
    private List<Groups> groups = new ArrayList<Groups>();

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public List<Groups> getGroups() {
        return groups;
    }

    public void setGroups(List<Groups> groups) {
        this.groups = groups;
    }
}
