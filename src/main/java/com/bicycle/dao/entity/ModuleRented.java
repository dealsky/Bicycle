package com.bicycle.dao.entity;

import java.util.Date;

public class ModuleRented {
    private Long rentid;

    private Long userid;

    private Long bicid;

    private Date renttime;

    public Long getRentid() {
        return rentid;
    }

    public void setRentid(Long rentid) {
        this.rentid = rentid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Long getBicid() {
        return bicid;
    }

    public void setBicid(Long bicid) {
        this.bicid = bicid;
    }

    public Date getRenttime() {
        return renttime;
    }

    public void setRenttime(Date renttime) {
        this.renttime = renttime;
    }
}