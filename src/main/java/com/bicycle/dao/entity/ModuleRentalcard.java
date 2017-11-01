package com.bicycle.dao.entity;

import java.util.Date;

public class ModuleRentalcard {
    private Long recid;

    private Long userid;

    private Long recnumber;

    private Float recbalance;

    private Integer recstatus;

    private Date recoptime;

    public Long getRecid() {
        return recid;
    }

    public void setRecid(Long recid) {
        this.recid = recid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Long getRecnumber() {
        return recnumber;
    }

    public void setRecnumber(Long recnumber) {
        this.recnumber = recnumber;
    }

    public Float getRecbalance() {
        return recbalance;
    }

    public void setRecbalance(Float recbalance) {
        this.recbalance = recbalance;
    }

    public Integer getRecstatus() {
        return recstatus;
    }

    public void setRecstatus(Integer recstatus) {
        this.recstatus = recstatus;
    }

    public Date getRecoptime() {
        return recoptime;
    }

    public void setRecoptime(Date recoptime) {
        this.recoptime = recoptime;
    }
}