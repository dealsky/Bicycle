package com.bicycle.dao.entity;

import java.util.Date;

public class ModuleManager {
    private Long magid;

    private String magname;

    private Integer magsex;

    private String magaccount;

    private String magpass;

    private String magtel;

    private Date magregtime;

    private Date maglastlogintime;

    public Long getMagid() {
        return magid;
    }

    public void setMagid(Long magid) {
        this.magid = magid;
    }

    public String getMagname() {
        return magname;
    }

    public void setMagname(String magname) {
        this.magname = magname == null ? null : magname.trim();
    }

    public Integer getMagsex() {
        return magsex;
    }

    public void setMagsex(Integer magsex) {
        this.magsex = magsex;
    }

    public String getMagaccount() {
        return magaccount;
    }

    public void setMagaccount(String magaccount) {
        this.magaccount = magaccount == null ? null : magaccount.trim();
    }

    public String getMagpass() {
        return magpass;
    }

    public void setMagpass(String magpass) {
        this.magpass = magpass == null ? null : magpass.trim();
    }

    public String getMagtel() {
        return magtel;
    }

    public void setMagtel(String magtel) {
        this.magtel = magtel == null ? null : magtel.trim();
    }

    public Date getMagregtime() {
        return magregtime;
    }

    public void setMagregtime(Date magregtime) {
        this.magregtime = magregtime;
    }

    public Date getMaglastlogintime() {
        return maglastlogintime;
    }

    public void setMaglastlogintime(Date maglastlogintime) {
        this.maglastlogintime = maglastlogintime;
    }
}