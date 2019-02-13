package com.biztest.demo.service;

import com.biztest.demo.entity.CollectEntity;
import com.biztest.demo.entity.FileEntity;
import com.biztest.demo.entity.UserEntity;

import java.util.List;

public interface FileCollectService {
    void addFileCollect(CollectEntity collectEntity);
    List<CollectEntity> findAllCollectByid(UserEntity userEntity);
    void delFileCollect(int id);
    CollectEntity findCollectByfileidanduserid(int fileid,int id);
}
