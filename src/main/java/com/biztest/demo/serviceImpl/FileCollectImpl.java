package com.biztest.demo.serviceImpl;

import com.biztest.demo.DAO.CollectDAO;
import com.biztest.demo.entity.UserEntity;
import com.biztest.demo.service.FileCollectService;
import com.biztest.demo.entity.CollectEntity;
import com.biztest.demo.entity.FileEntity;
//import org.checkerframework.checker.units.qual.A;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
@Transactional
@Service
public class FileCollectImpl implements FileCollectService {
    @Autowired
    CollectDAO collectDAO;

    public FileCollectImpl(){

    }
    @Override
    public CollectEntity findCollectByfileidanduserid(int fileid, int userid){
        return  collectDAO.findCollectByfileidanduserid(fileid,userid);
    }
    @Override
    public List<CollectEntity> findAllCollectByid(UserEntity user){
        return collectDAO.findAllcollect(user.getUserId());
    }
    @Override
    public void addFileCollect(CollectEntity collectEntity){
        collectDAO.save(collectEntity);
    }

    @Override
    public void delFileCollect(int id){
      collectDAO.delFileCollect(id);
    }
}
