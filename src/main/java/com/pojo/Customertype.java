package com.pojo;

public class Customertype {
    private Integer customertypeid;

    private String customertypename;

    public Integer getCustomertypeid() {
        return customertypeid;
    }

    public void setCustomertypeid(Integer customertypeid) {
        this.customertypeid = customertypeid;
    }

    public String getCustomertypename() {
        return customertypename;
    }

    public void setCustomertypename(String customertypename) {
        this.customertypename = customertypename == null ? null : customertypename.trim();
    }

    @Override
    public String toString() {
        return "Customertype{" +
                "customertypeid=" + customertypeid +
                ", customertypename='" + customertypename + '\'' +
                '}';
    }


}