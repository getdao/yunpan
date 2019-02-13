package com.biztest.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "y_owner")
public class OwnerEntity {
    public int getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(int ownerid) {
        this.ownerid = ownerid;
    }

    public String getOwnername() {
        return ownername;
    }

    public void setOwnername(String ownername) {
        this.ownername = ownername;
    }

    public String getOwnerpassword() {
        return ownerpassword;
    }

    public void setOwnerpassword(String ownerpassword) {
        this.ownerpassword = ownerpassword;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //管理员id
    private int ownerid;
    //管理员姓名
    @Column(name = "ownername",nullable = false,length = 20)
    private String ownername;
    //管理员密码
    @Column(name = "ownerpassword",nullable = false,length = 30)
    private String ownerpassword;
}
