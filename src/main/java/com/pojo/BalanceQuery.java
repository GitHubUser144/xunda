package com.pojo;

public class BalanceQuery {

    String customername;
    String paidtime1;
    String paidtype;
    String isvalid;
    String paidtime2;

    public String getPaidtime2() {
        return paidtime2;
    }

    public void setPaidtime2(String paidtime2) {
        this.paidtime2 = paidtime2;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getPaidtime1() {
        return paidtime1;
    }

    public void setPaidtime1(String paidtime1) {
        this.paidtime1 = paidtime1;
    }

    public String getPaidtype() {
        return paidtype;
    }

    public void setPaidtype(String paidtype) {
        this.paidtype = paidtype;
    }

    public String getIsvalid() {
        return isvalid;
    }

    public void setIsvalid(String isvalid) {
        this.isvalid = isvalid;
    }

    @Override
    public String toString() {
        return "BalanceQuery{" +
                "customername='" + customername + '\'' +
                ", paidtime1='" + paidtime1 + '\'' +
                ", paidtype='" + paidtype + '\'' +
                ", isvalid='" + isvalid + '\'' +
                ", paidtime2='" + paidtime2 + '\'' +
                '}';
    }
}
