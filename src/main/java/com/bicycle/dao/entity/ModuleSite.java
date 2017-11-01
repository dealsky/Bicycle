package com.bicycle.dao.entity;

public class ModuleSite {
    private Long siteid;

    private Long magid;

    private Long sitenumber;

    private String sitearea;

    private Integer siteamount;

    public Long getSiteid() {
        return siteid;
    }

    public void setSiteid(Long siteid) {
        this.siteid = siteid;
    }

    public Long getMagid() {
        return magid;
    }

    public void setMagid(Long magid) {
        this.magid = magid;
    }

    public Long getSitenumber() {
        return sitenumber;
    }

    public void setSitenumber(Long sitenumber) {
        this.sitenumber = sitenumber;
    }

    public String getSitearea() {
        return sitearea;
    }

    public void setSitearea(String sitearea) {
        this.sitearea = sitearea == null ? null : sitearea.trim();
    }

    public Integer getSiteamount() {
        return siteamount;
    }

    public void setSiteamount(Integer siteamount) {
        this.siteamount = siteamount;
    }
}