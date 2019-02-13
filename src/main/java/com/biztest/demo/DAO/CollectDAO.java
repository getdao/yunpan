package com.biztest.demo.DAO;

import com.biztest.demo.entity.CollectEntity;
import com.biztest.demo.entity.FileEntity;
import com.biztest.demo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Repository
public interface CollectDAO extends JpaRepository<CollectEntity, String> {
    /*@Modifying
    @Query(value = "insert into y_collect p set p.status =1 where p.file_id = ?1",nativeQuery = true)*/
            //收藏分享文件

            //删除收藏
            @Modifying
            @Query(value = "delete p from y_collect p where p.collectid = ?1",nativeQuery = true)
            void delFileCollect(@Param("collectid") int id);
            //获取用户收藏

            @Query(value = "select * from y_collect p where p.userid = ?1",nativeQuery = true)
            List<CollectEntity> findAllcollect(@Param("userid") int id);

             @Query(value = "select * from y_collect p where p.fileid = ?1 and p.userid=?2",nativeQuery = true)
            CollectEntity findCollectByfileidanduserid(@Param("fileid") int id, @Param("userid") int userid);
}
