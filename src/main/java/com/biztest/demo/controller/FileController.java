package com.biztest.demo.controller;

import com.biztest.demo.entity.UserEntity;
import com.biztest.demo.service.FileService;
import com.biztest.demo.entity.FileEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class FileController {
    @Autowired
    FileService fileService;
    //查询所有文件
    @RequestMapping(value = "/findAllFile",method= RequestMethod.GET)
    public @ResponseBody List findAllFile(HttpSession httpSession) {
         UserEntity a=(UserEntity)httpSession.getAttribute("user") ;
        List<FileEntity> list=fileService.findAllFile(a);

        return list;
    }
    //设置分享
    @ResponseBody
    @RequestMapping(value = "/addshare",method = RequestMethod.GET)
    public String Addshare(@RequestParam int fileid, HttpServletResponse response) {
        String msg;
        FileEntity fileEntity=new FileEntity();
        fileEntity=fileService.findByfileid(fileid);
        if(fileEntity.getFilestatus()==1){
            msg="已分享";
        }
        else {
            try {
                fileService.ShareByid(fileid);
                msg="分享成功";
            }catch (Exception e){
                msg="分享失败";
            }
        }


        return msg;
    }
    //取消分享
    @ResponseBody
    @RequestMapping("/delshare")
    public String delshare(FileEntity fileEntity, HttpServletResponse response) {
        String msg;

        fileService.delshare(fileEntity.getFileid());
        msg="取消分享成功";
        return msg;
    }

    @ResponseBody
    @RequestMapping("/findByfilename")
    public FileEntity findByfilename(@RequestParam String filename){
       String msg="文件不存在";
        FileEntity fileEntity=fileService.findByfilename(filename);
        if (fileEntity!=null){
            msg="查找成功";

        }
        System.out.println(msg);
        return fileEntity;
    }
}
