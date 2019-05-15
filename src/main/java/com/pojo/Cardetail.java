package com.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.sql.Date;

public class Cardetail {
    private String detailid;

    private Integer transid;

    private BigDecimal gcount;

    private Integer sendcity;

    private Integer rececity;

    private String startaddr;

    private String endaddr;

    private Integer sendcustid;

    private Integer rececustid;

    private String receperson;

    private String phone;

    private String goodsname;

    private String unitname;

    private BigDecimal insurancefee;

    private BigDecimal otherfee;

    private String sendgoods;

    private Integer paidid;

    private String orderid;

    private String paidstuats;

    private BigDecimal sendfee;

    private BigDecimal facefee;

    private Date sendtime;

    private Date oprtime;

    private Integer userid;

    private String demo;

    private Transcar transcar;

    private Customer customer;

    private Paidtype paidtype;

    private Users users;

    private Car car;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Transcar getTranscar() {
        return transcar;
    }

    public void setTranscar(Transcar transcar) {
        this.transcar = transcar;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Paidtype getPaidtype() {
        return paidtype;
    }

    public void setPaidtype(Paidtype paidtype) {
        this.paidtype = paidtype;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public String getDetailid() {
        return detailid;
    }

    public void setDetailid(String detailid) {
        this.detailid = detailid == null ? null : detailid.trim();
    }

    public Integer getTransid() {
        return transid;
    }

    public void setTransid(Integer transid) {
        this.transid = transid;
    }

    public BigDecimal getGcount() {
        return gcount;
    }

    public void setGcount(BigDecimal gcount) {
        this.gcount = gcount;
    }

    public Integer getSendcity() {
        return sendcity;
    }

    public void setSendcity(Integer sendcity) {
        this.sendcity = sendcity;
    }

    public Integer getRececity() {
        return rececity;
    }

    public void setRececity(Integer rececity) {
        this.rececity = rececity;
    }

    public String getStartaddr() {
        return startaddr;
    }

    public void setStartaddr(String startaddr) {
        this.startaddr = startaddr == null ? null : startaddr.trim();
    }

    public String getEndaddr() {
        return endaddr;
    }

    public void setEndaddr(String endaddr) {
        this.endaddr = endaddr == null ? null : endaddr.trim();
    }

    public Integer getSendcustid() {
        return sendcustid;
    }

    public void setSendcustid(Integer sendcustid) {
        this.sendcustid = sendcustid;
    }

    public Integer getRececustid() {
        return rececustid;
    }

    public void setRececustid(Integer rececustid) {
        this.rececustid = rececustid;
    }

    public String getReceperson() {
        return receperson;
    }

    public void setReceperson(String receperson) {
        this.receperson = receperson == null ? null : receperson.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname == null ? null : goodsname.trim();
    }

    public String getUnitname() {
        return unitname;
    }

    public void setUnitname(String unitname) {
        this.unitname = unitname == null ? null : unitname.trim();
    }

    public BigDecimal getInsurancefee() {
        return insurancefee;
    }

    public void setInsurancefee(BigDecimal insurancefee) {
        this.insurancefee = insurancefee;
    }

    public BigDecimal getOtherfee() {
        return otherfee;
    }

    public void setOtherfee(BigDecimal otherfee) {
        this.otherfee = otherfee;
    }

    public String getSendgoods() {
        return sendgoods;
    }

    public void setSendgoods(String sendgoods) {
        this.sendgoods = sendgoods == null ? null : sendgoods.trim();
    }

    public Integer getPaidid() {
        return paidid;
    }

    public void setPaidid(Integer paidid) {
        this.paidid = paidid;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid == null ? null : orderid.trim();
    }

    public String getPaidstuats() {
        return paidstuats;
    }

    public void setPaidstuats(String paidstuats) {
        this.paidstuats = paidstuats == null ? null : paidstuats.trim();
    }

    public BigDecimal getSendfee() {
        return sendfee;
    }

    public void setSendfee(BigDecimal sendfee) {
        this.sendfee = sendfee;
    }

    public BigDecimal getFacefee() {
        return facefee;
    }

    public void setFacefee(BigDecimal facefee) {
        this.facefee = facefee;
    }

    public Date getSendtime() {
        return sendtime;
    }

    public void setSendtime(Date sendtime) {
        this.sendtime = sendtime;
    }

    public Date getOprtime() {
        return oprtime;
    }

    public void setOprtime(Date oprtime) {
        this.oprtime = oprtime;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getDemo() {
        return demo;
    }

    public void setDemo(String demo) {
        this.demo = demo == null ? null : demo.trim();
    }

    @Override
    public String toString() {
        return "Cardetail{" +
                "detailid='" + detailid + '\'' +
                ", transid=" + transid +
                ", gcount=" + gcount +
                ", sendcity=" + sendcity +
                ", rececity=" + rececity +
                ", startaddr='" + startaddr + '\'' +
                ", endaddr='" + endaddr + '\'' +
                ", sendcustid=" + sendcustid +
                ", rececustid=" + rececustid +
                ", receperson='" + receperson + '\'' +
                ", phone='" + phone + '\'' +
                ", goodsname='" + goodsname + '\'' +
                ", unitname='" + unitname + '\'' +
                ", insurancefee=" + insurancefee +
                ", otherfee=" + otherfee +
                ", sendgoods='" + sendgoods + '\'' +
                ", paidid=" + paidid +
                ", orderid='" + orderid + '\'' +
                ", paidstuats='" + paidstuats + '\'' +
                ", sendfee=" + sendfee +
                ", facefee=" + facefee +
                ", sendtime=" + sendtime +
                ", oprtime=" + oprtime +
                ", userid=" + userid +
                ", demo='" + demo + '\'' +
                ", transcar=" + transcar +
                ", customer=" + customer +
                ", paidtype=" + paidtype +
                ", users=" + users +
                ", car=" + car +
                '}';
    }
}