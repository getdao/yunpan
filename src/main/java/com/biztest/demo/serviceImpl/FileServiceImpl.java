package com.biztest.demo.serviceImpl;

import com.biztest.demo.DAO.FileDAO;
import com.biztest.demo.entity.UserEntity;
import com.biztest.demo.service.FileService;
import com.biztest.demo.entity.FileEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Service
public class FileServiceImpl implements FileService {
    @Autowired
    FileDAO fileDAO;


    @Override
    public FileEntity findByfilename(String name){
        return  fileDAO.findByfilename(name);
    }
    @Override
    public List<FileEntity> findAllshare(){
        return fileDAO.findAllshare();
    }
    @Override
    public void ShareByid(int id){
        fileDAO.ShareByid(id);
    }
    @Override
    public List<FileEntity> findmyshare(int id){
        return   fileDAO.findmyshare(id);
    }
    @Override
    public void delshare(int id){
        fileDAO.delshare(id);
    }

    @Override
    public List<FileEntity> findAllFile(UserEntity userEntity){
      return   fileDAO.findAllFile(userEntity.getUserId());
    }

    @Override
    public FileEntity findByfileid(int id){
        return fileDAO.findByfileid(id);
    }
}
