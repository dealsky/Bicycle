package com.bicycle.dao.entity;

import java.util.Date;

public class ModulePark {
    private Long parkid;

    private Long siteid;

    private Long bicid;

    private Date parktime;

    public Long getParkid() {
        return parkid;
    }

    public void setParkid(Long parkid) {
        this.parkid = parkid;
    }

    public Long getSiteid() {
        return siteid;
    }

    public void setSiteid(Long siteid) {
        this.siteid = siteid;
    }

    public Long getBicid() {
        return bicid;
    }

    public void setBicid(Long bicid) {
        this.bicid = bicid;
    }

    public Date getParktime() {
        return parktime;
    }

    public void setParktime(Date parktime) {
        this.parktime = parktime;
    }
}