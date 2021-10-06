package com.kp.ono2one;

/**
 * 人
 */
public class Person {
    private int pid;
    private String pname;
    /*一对一的关系*/
    private IdCard idCard;

    public Person(){}
    public Person(String pname) {
        this.pname = pname;
    }

    public IdCard getIdCard() {
        return idCard;
    }

    @Override
    public String toString() {
        return "Person{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", idCard=" + idCard +
                '}';
    }

    public void setIdCard(IdCard idCard) {
        this.idCard = idCard;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }
}
