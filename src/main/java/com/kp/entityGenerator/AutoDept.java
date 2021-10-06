package com.kp.entityGenerator;

public class AutoDept {
    private Integer did;

    private String dname;

    public AutoDept(Integer did, String dname) {
        this.did = did;
        this.dname = dname;
    }

    public AutoDept() {
        super();
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname == null ? null : dname.trim();
    }
}