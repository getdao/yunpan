package com.biztest.demo.service;

import com.biztest.demo.entity.FileEntity;
import com.biztest.demo.entity.UserEntity;

import java.util.List;

public interface FileService {
    //暂不使用findAll()
    List<FileEntity> findAllshare();
    public void ShareByid(int id);
    public List<FileEntity> findmyshare(int id);
    public void delshare(int id);
    public List<FileEntity> findAllFile(UserEntity userEntity);
    FileEntity findByfileid(int id);
    FileEntity findByfilename(String name);
}
