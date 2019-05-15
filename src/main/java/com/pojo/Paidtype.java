package com.pojo;

public class Paidtype {
    private Integer paidid;

    private String paidname;

    public Integer getPaidid() {
        return paidid;
    }

    public void setPaidid(Integer paidid) {
        this.paidid = paidid;
    }

    public String getPaidname() {
        return paidname;
    }

    public void setPaidname(String paidname) {
        this.paidname = paidname == null ? null : paidname.trim();
    }

    @Override
    public String toString() {
        return "Paidtype{" +
                "paidid=" + paidid +
                ", paidname='" + paidname + '\'' +
                '}';
    }
}