package com.biztest.demo.entity;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "y_catalog")
public class CatalogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //目录id
    private int catalog_id;
    //父目录
    @Column(name = "catalog_father",length = 50)
    private String catalog_father;
    //文件级别
    @Column(name = "catalo_level",nullable = false)
    private int cataloglevel=0;



    @Column(name = "fileid")
    private int fileid;
}
