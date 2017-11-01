package com.bicycle.dao.entity;

import java.util.Date;

public class ModuleUser {
    private Long userid;

    private String username;

    private Integer usersex;

    private String useracc;

    private String userpass;

    private String usertel;

    private String useridcard;

    private String useremail;

    private Date userregtime;

    private Date userlastlogintime;

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Integer getUsersex() {
        return usersex;
    }

    public void setUsersex(Integer usersex) {
        this.usersex = usersex;
    }

    public String getUseracc() {
        return useracc;
    }

    public void setUseracc(String useracc) {
        this.useracc = useracc == null ? null : useracc.trim();
    }

    public String getUserpass() {
        return userpass;
    }

    public void setUserpass(String userpass) {
        this.userpass = userpass == null ? null : userpass.trim();
    }

    public String getUsertel() {
        return usertel;
    }

    public void setUsertel(String usertel) {
        this.usertel = usertel == null ? null : usertel.trim();
    }

    public String getUseridcard() {
        return useridcard;
    }

    public void setUseridcard(String useridcard) {
        this.useridcard = useridcard == null ? null : useridcard.trim();
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail == null ? null : useremail.trim();
    }

    public Date getUserregtime() {
        return userregtime;
    }

    public void setUserregtime(Date userregtime) {
        this.userregtime = userregtime;
    }

    public Date getUserlastlogintime() {
        return userlastlogintime;
    }

    public void setUserlastlogintime(Date userlastlogintime) {
        this.userlastlogintime = userlastlogintime;
    }
}