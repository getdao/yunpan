package com.biztest.demo.serviceImpl;

import com.biztest.demo.DAO.UserDAO;
import com.biztest.demo.service.UserService;
import com.biztest.demo.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class UserServiceImpl implements UserService {

    /*Configuration config = new Configuration();
    SessionFactory factory = config.configure().buildSessionFactory();
    session = factory.openSession();
        this.session.save(userEntity);*/
    //Session session;
    @Autowired
    UserDAO userDAO;
    public UserServiceImpl(){

    }


    @Override

    public void addUser(UserEntity userEntity){
        userDAO.save(userEntity);
    }

   @Override
    public void delUser(UserEntity userEntity){

    }

    @Override
    public void updateUser(UserEntity userEntity){

    }

    @Override
    public UserEntity findUser(String a,  String b){
        return userDAO.findUser(a,b);
    }


}
