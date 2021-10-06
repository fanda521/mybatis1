package com.kp.entityGenerator;

public class AutoPerson {
    private Integer pid;

    private String pname;

    public AutoPerson(Integer pid, String pname) {
        this.pid = pid;
        this.pname = pname;
    }

    public AutoPerson() {
        super();
    }

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
        this.pname = pname == null ? null : pname.trim();
    }
}