package com.biztest.demo.service;

import com.biztest.demo.entity.UserEntity;

public interface UserService  {
   public void addUser(UserEntity userEntity);
    public void delUser(UserEntity userEntity);
    public void updateUser(UserEntity userEntity);
    UserEntity findUser(String a, String b);
}
//extends JpaRepository<UserEntity, String>