package com.kp.many2many;

import java.util.ArrayList;
import java.util.List;

public class Groups {
    private Integer gid;
    private String gname;//组的名称
    //描述多对多的关系
    List<Privelege> pris = new ArrayList<Privelege>();

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public List<Privelege> getPris() {
        return pris;
    }

    public void setPris(List<Privelege> pris) {
        this.pris = pris;
    }
}
