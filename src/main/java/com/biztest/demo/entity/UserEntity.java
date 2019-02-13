package com.biztest.demo.entity;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "y_user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //用户id
    private int userid;
    //用户姓名
    @Column(name = "username",length = 30,nullable = false)
    private String username;
    //用户密码
    @Column(name = "userpassword",length = 30,nullable = false)
    private String userpassword;
    //用户状态，0表示未激活，1表示激活
    @Column(name = "userstatus",nullable = false)
    private int userstatus =0;
    //用户邮箱
    @Column(name = "useremail",length = 30,nullable = false)
    private String useremail;

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

   /* @Autowired
    @OneToMany
    @JoinColumn(name = "userid")
    private List<FileEntity>fileEntities;*/

    public int getUserId() {
        return userid;
    }

    public void setUserId(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public int getUserstatus() {
        return userstatus;
    }

    public void setUserstatus(int userstatus) {
        this.userstatus = userstatus;
    }



   /* public List<FileEntity> getFileEntities() {
        return fileEntities;
    }

    public void setFileEntities(List<FileEntity> fileEntities) {
        this.fileEntities = fileEntities;
    }*/

  /*  public List<CollectEntity> getCollectEntities() {
        return collectEntities;
    }

    public void setCollectEntities(List<CollectEntity> collectEntities) {
        this.collectEntities = collectEntities;
    }

    @Autowired
    @OneToMany
    @JoinColumn(name = "userid")
    private List<CollectEntity>collectEntities;*/
}
