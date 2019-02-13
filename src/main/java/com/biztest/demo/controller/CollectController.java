package com.biztest.demo.controller;

import com.biztest.demo.entity.CollectEntity;
import com.biztest.demo.entity.FileEntity;
import com.biztest.demo.entity.UserEntity;
import com.biztest.demo.service.FileCollectService;
import com.biztest.demo.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CollectController {
    @Autowired
    FileCollectService fileCollectService;
    @Autowired
    FileService fileService;

    FileEntity fileEntity;
    //CollectEntity collectEntity;
    //添加收藏 完成
    @ResponseBody
    @RequestMapping("/addFileCollect")
    public String addFileCollect(HttpSession httpSession, @RequestParam int fileid) {
        String msg;
        UserEntity user=(UserEntity)httpSession.getAttribute("user") ;
        CollectEntity collectEntity=new CollectEntity();
        CollectEntity t1=new CollectEntity();
        t1 =fileCollectService.findCollectByfileidanduserid(fileid,user.getUserId());
        try {
            if(t1!=null){
                msg="请勿重复收藏";
            }
            else{
                System.out.println(fileid);
                fileEntity=fileService.findByfileid(fileid);
                collectEntity.setFileid(fileid);
                collectEntity.setFilename(fileEntity.getFilename());
                collectEntity.setFiletype(fileEntity.getFiletype());
                collectEntity.setUserid(user.getUserId());
                fileCollectService.addFileCollect(collectEntity);
                msg = "收藏成功";
            }

        } catch (Exception e) {
            msg = "操作失败";
        }
        return msg;
    }
    //取消收藏 完成
    @ResponseBody
    @RequestMapping("/delFileCollect")
    public String delFileCollect( HttpServletRequest req,@RequestParam int collectid) {
        String msg;
      try {
            fileCollectService.delFileCollect(collectid);
            msg="取消收藏成功";

        }catch (Exception e){
            msg="操作失败";
        }
            return msg;
    }

    //查找收藏 完成
    @ResponseBody
    @RequestMapping("/findFileCollect")
    public List<CollectEntity> findFileCollect(HttpSession httpSession) {
        UserEntity user=(UserEntity)httpSession.getAttribute("user");
        List<CollectEntity> list=fileCollectService.findAllCollectByid(user);

        return list;
    }

}
