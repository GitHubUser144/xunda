package com.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class Balance {
    private Integer balanceid;

    private Integer customerid;

    private BigDecimal facefee;

    private String paidtype;

    private Timestamp paidtime;

    private Timestamp oprtime;

    private Integer userid;

    private String isvalid;

    private String demo;

    private Customer customer;

    private Users users;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Integer getBalanceid() {
        return balanceid;
    }

    public void setBalanceid(Integer balanceid) {
        this.balanceid = balanceid;
    }

    public Integer getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Integer customerid) {
        this.customerid = customerid;
    }

    public BigDecimal getFacefee() {
        return facefee;
    }

    public void setFacefee(BigDecimal facefee) {
        this.facefee = facefee;
    }

    public String getPaidtype() {
        return paidtype;
    }

    public void setPaidtype(String paidtype) {
        this.paidtype = paidtype == null ? null : paidtype.trim();
    }

    public Timestamp getPaidtime() {
        return paidtime;
    }

    public void setPaidtime(Timestamp paidtime) {
        this.paidtime = paidtime;
    }

    public Timestamp getOprtime() {
        return oprtime;
    }

    public void setOprtime(Timestamp oprtime) {
        this.oprtime = oprtime;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getIsvalid() {
        return isvalid;
    }

    public void setIsvalid(String isvalid) {
        this.isvalid = isvalid == null ? null : isvalid.trim();
    }

    public String getDemo() {
        return demo;
    }

    public void setDemo(String demo) {
        this.demo = demo == null ? null : demo.trim();
    }

    @Override
    public String toString() {
        return "Balance{" +
                "balanceid=" + balanceid +
                ", customerid=" + customerid +
                ", facefee=" + facefee +
                ", paidtype='" + paidtype + '\'' +
                ", paidtime=" + paidtime +
                ", oprtime=" + oprtime +
                ", userid=" + userid +
                ", isvalid='" + isvalid + '\'' +
                ", demo='" + demo + '\'' +
                ", customer=" + customer +
                ", users=" + users +
                '}';
    }
}