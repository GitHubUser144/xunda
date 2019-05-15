package com.pojo;

public class Accmodule {
    private Integer id;

    private Integer userid;

    private Integer moduleid;

    private Module module;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getModuleid() {
        return moduleid;
    }

    public void setModuleid(Integer moduleid) {
        this.moduleid = moduleid;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    @Override
    public String toString() {
        return "Accmodule{" +
                "id=" + id +
                ", userid=" + userid +
                ", moduleid=" + moduleid +
                ", module=" + module +
                '}';
    }
}