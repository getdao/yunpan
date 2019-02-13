package com.biztest.demo.DAO;


import com.biztest.demo.entity.FileEntity;
import com.biztest.demo.entity.UserEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;



public interface UserDAO  extends JpaRepository<UserEntity, String> {
   // void adduser(UserEntity U);
    //@Modifying
    @Query(value = "SELECT * FROM y_user p where p.username=?1 and p.userpassword=?2", nativeQuery = true)
    UserEntity findUser(String a, String  b);
}
