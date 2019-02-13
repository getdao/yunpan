package com.biztest.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "y_collect")
public class CollectEntity {
    public int getCollectid() {
        return collectid;
    }

    public void setCollectid(int collectid) {
        this.collectid = collectid;
    }

    public int getFileid() {
        return fileid;
    }

    public void setFileid(int fileid) {
        this.fileid = fileid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int id) {
        this.userid = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //收藏id
    private int collectid;


    //被收藏文件id

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFiletype() {
        return filetype;
    }

    public void setFiletype(String filetype) {
        this.filetype = filetype;
    }

    @Column(name = "fileid",nullable = false)
    private int  fileid;
    //收藏人id

    @Column(name = "userid",nullable = false)
    private int userid;

    @Column(name = "filename",nullable = false)
    private String filename;

    @Column(name = "filetype",nullable = false)
    private String filetype;
}
