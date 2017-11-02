package com.bicycle.dao.entity;

import java.util.Date;

public class ModuleBicycle {
    private Long bicid;

    private Long bicnumber;

    private String bictype;

    private Float bicrentprice;

    private Date bicbuytime;

    private Integer bicborrowed;

    private Integer bicborrowedcount;

    public Long getBicid() {
        return bicid;
    }

    public void setBicid(Long bicid) {
        this.bicid = bicid;
    }

    public Long getBicnumber() {
        return bicnumber;
    }

    public void setBicnumber(Long bicnumber) {
        this.bicnumber = bicnumber;
    }

    public String getBictype() {
        return bictype;
    }

    public void setBictype(String bictype) {
        this.bictype = bictype == null ? null : bictype.trim();
    }

    public Float getBicrentprice() {
        return bicrentprice;
    }

    public void setBicrentprice(Float bicrentprice) {
        this.bicrentprice = bicrentprice;
    }

    public Date getBicbuytime() {
        return bicbuytime;
    }

    public void setBicbuytime(Date bicbuytime) {
        this.bicbuytime = bicbuytime;
    }

    public Integer getBicborrowed() {
        return bicborrowed;
    }

    public void setBicborrowed(Integer bicborrowed) {
        this.bicborrowed = bicborrowed;
    }

    public Integer getBicborrowedcount() {
        return bicborrowedcount;
    }

    public void setBicborrowedcount(Integer bicborrowedcount) {
        this.bicborrowedcount = bicborrowedcount;
    }
}