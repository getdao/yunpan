package com.biztest.demo.entity;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "y_file")
public class FileEntity {
    public int getFileid() {
        return fileid;
    }

    public void setFileid(int fileid) {
        this.fileid = fileid;
    }

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

    public int getFilestatus() {
        return filestatus;
    }

    public void setFilestatus(int filestatus) {
        this.filestatus = filestatus;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    /*public CatalogEntity getCatalogEntity() {
        return catalogEntity;
    }

    public void setCatalogEntity(CatalogEntity catalogEntity) {
        this.catalogEntity = catalogEntity;
    }*/

    public Date getFiledate() {
        return filedate;
    }

    public void setFiledate(Date filedate) {
        this.filedate = filedate;
    }



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //文件id
    private int fileid;
    //文件名
    @Column(name = "filename",length = 50,nullable = false)
    private String filename;
    //文件类型
    @Column(name = "filetype",length = 10,nullable = false)
    private String filetype;
    //文件状态：0表示正常，1表示已分享
    @Column(name = "filestatus",nullable = false)
    private int filestatus =0;
    //文件所属人id

    @JoinColumn(name="userid" , nullable = false)
    //文件所属目录id
    private int userid;

    public int getCatalog_id() {
        return catalog_id;
    }

    public void setCatalog_id(int catalog_id) {
        this.catalog_id = catalog_id;
    }

    @Column(name = "catalog_id")
    private int catalog_id;
    /*@ManyToOne
    @JoinColumn(name = "catalogid",nullable = false)
    private CatalogEntity catalogEntity;
    //文件上传日期*/
    @Column(name = "filedate")
    private Date filedate;


}
