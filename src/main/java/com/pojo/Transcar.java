package com.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.sql.Date;

public class Transcar {
    private Integer transid;

    private Integer carid;

    private BigDecimal gcount;

    private Integer sendcity;

    private Integer rececity;

    private String driver;

    private String drivertel;

    private String master;

    private String mastertel;

    private Integer sendtypeid;

    private Date sendtime;

    private BigDecimal sendfee;

    private BigDecimal carfee;

    private String carstatus;

    private String demo;

    private Car car;

    private Sendtype sendtype;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Sendtype getSendtype() {
        return sendtype;
    }

    public void setSendtype(Sendtype sendtype) {
        this.sendtype = sendtype;
    }


    public Integer getTransid() {
        return transid;
    }

    public void setTransid(Integer transid) {
        this.transid = transid;
    }

    public Integer getCarid() {
        return carid;
    }

    public void setCarid(Integer carid) {
        this.carid = carid;
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

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver == null ? null : driver.trim();
    }

    public String getDrivertel() {
        return drivertel;
    }

    public void setDrivertel(String drivertel) {
        this.drivertel = drivertel == null ? null : drivertel.trim();
    }

    public String getMaster() {
        return master;
    }

    public void setMaster(String master) {
        this.master = master == null ? null : master.trim();
    }

    public String getMastertel() {
        return mastertel;
    }

    public void setMastertel(String mastertel) {
        this.mastertel = mastertel == null ? null : mastertel.trim();
    }

    public Integer getSendtypeid() {
        return sendtypeid;
    }

    public void setSendtypeid(Integer sendtypeid) {
        this.sendtypeid = sendtypeid;
    }

    public Date getSendtime() {
        return sendtime;
    }

    public void setSendtime(Date sendtime) {
        this.sendtime = sendtime;
    }

    public BigDecimal getSendfee() {
        return sendfee;
    }

    public void setSendfee(BigDecimal sendfee) {
        this.sendfee = sendfee;
    }

    public BigDecimal getCarfee() {
        return carfee;
    }

    public void setCarfee(BigDecimal carfee) {
        this.carfee = carfee;
    }

    public String getCarstatus() {
        return carstatus;
    }

    public void setCarstatus(String carstatus) {
        this.carstatus = carstatus == null ? null : carstatus.trim();
    }

    public String getDemo() {
        return demo;
    }

    public void setDemo(String demo) {
        this.demo = demo == null ? null : demo.trim();
    }

    @Override
    public String toString() {
        return "Transcar{" +
                "transid=" + transid +
                ", carid=" + carid +
                ", gcount=" + gcount +
                ", sendcity=" + sendcity +
                ", rececity=" + rececity +
                ", driver='" + driver + '\'' +
                ", drivertel='" + drivertel + '\'' +
                ", master='" + master + '\'' +
                ", mastertel='" + mastertel + '\'' +
                ", sendtypeid=" + sendtypeid +
                ", sendtime=" + sendtime +
                ", sendfee=" + sendfee +
                ", carfee=" + carfee +
                ", carstatus='" + carstatus + '\'' +
                ", demo='" + demo + '\'' +
                ", car=" + car +
                ", sendtype=" + sendtype +
                '}';
    }
}