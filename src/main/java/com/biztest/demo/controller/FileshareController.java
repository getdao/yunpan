package com.biztest.demo.controller;

import com.biztest.demo.service.FileCollectService;
import com.biztest.demo.entity.CollectEntity;
import com.biztest.demo.entity.FileEntity;
import com.biztest.demo.entity.UserEntity;
import com.biztest.demo.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class FileshareController {
    @Autowired
    FileCollectService fileCollectService;
    @Autowired
    FileService fileService;

    CollectEntity collectEntity;
   
    @RequestMapping("/myindex")
    public String myindex(Model model,HttpServletRequest res){
        return "myindex";
    }



    //所有已分享  !!!返回共享全部页面
    @RequestMapping(value = "/findmyshare",method = RequestMethod.GET)
    public  @ResponseBody List FindAllshare(HttpSession httpSession) {
        UserEntity user=(UserEntity)httpSession.getAttribute("user");
       List<FileEntity> list=fileService.findmyshare(user.getUserId());
        //map.put("List", list);
        //UserEntity user = (UserEntity) req.getSession().getAttribute("user_name");
        //System.out.println(1111111);
        System.out.println(list);
        return list;
    }
    //查找我的分享 ！！！ 返回文件列表页面
    @RequestMapping(value = "/findAllshare",method = RequestMethod.GET)
    public  @ResponseBody List Findmyshare(HttpSession httpSession) {

        List<FileEntity> list=fileService.findAllshare();
        return list;
    }

}