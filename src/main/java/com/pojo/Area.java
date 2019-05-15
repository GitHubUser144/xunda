package com.pojo;

public class Area {
    private Integer areaid;

    private String areaname;

    public Integer getAreaid() {
        return areaid;
    }

    public void setAreaid(Integer areaid) {
        this.areaid = areaid;
    }

    public String getAreaname() {
        return areaname;
    }

    public void setAreaname(String areaname) {
        this.areaname = areaname == null ? null : areaname.trim();
    }

    @Override
    public String toString() {
        return "Area{" +
                "areaid=" + areaid +
                ", areaname='" + areaname + '\'' +
                '}';
    }
}