package com.biztest.demo.DAO;

import com.biztest.demo.entity.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FileUpDownDAO extends JpaRepository<FileEntity,Integer> {

    //新建文件夹

    //删除文件
    @Modifying
    @Query(value = "delete from y_file where fileid=?",nativeQuery = true)
    void delfile(@Param("fileid") int fileid);
}
