package com.biztest.demo.DAO;

import com.biztest.demo.entity.FileEntity;
import com.biztest.demo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.validation.constraints.Max;
import java.util.List;

public interface FileDAO extends JpaRepository<FileEntity, String> {

    List<FileEntity> findAll();

    //查看所有分享
    @Query(value = "SELECT * FROM y_file p where p.filestatus=1 ",nativeQuery = true)
    List<FileEntity> findAllshare();
    //查看某用户的分享
    @Query(value = "SELECT * FROM y_file p where p.filestatus=1 and userid !=?1",nativeQuery = true)
    List<FileEntity> findmyshare(@Param("userid") int id);
    //查找该用户文件
    @Query(value = "SELECT * FROM y_file p where p.userid=?1",nativeQuery = true)
    List<FileEntity> findAllFile(@Param("userid") int uerid);
    //设置分享
    @Modifying
    @Query(value = "update y_file p set p.filestatus =1 where p.fileid = ?1",nativeQuery = true)
    void ShareByid(@Param("fileid") int id);

    //取消分享
    @Modifying
    @Query(value="update  y_file p set p.fileStatus =0 where p.fileid=?1",nativeQuery = true)
    void delshare(@Param("fileid") int id);
    //查找file id
    @Query(value = "SELECT * FROM y_file p where p.fileid=?1",nativeQuery = true)
    FileEntity findByfileid(@Param("fileid") int id);

    @Query(value = "SELECT * FROM y_file p where p.filename=?1",nativeQuery = true)
    FileEntity findByfilename(@Param("filename") String name);
}
