package com.kp.ono2one;

/**
 * 身份证
 */
public class IdCard {
    private int cid;
    private String cnum;

    public int getCid() {
        return cid;
    }
    public IdCard() {}
    public IdCard(String cnum) {
        this.cnum = cnum;
    }

    @Override
    public String toString() {
        return "IdCard{" +
                "cid=" + cid +
                ", cnum='" + cnum + '\'' +
                '}';
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCnum() {
        return cnum;
    }

    public void setCnum(String cnum) {
        this.cnum = cnum;
    }
}
