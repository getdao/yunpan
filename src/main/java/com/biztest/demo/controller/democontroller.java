package com.biztest.demo.controller;

import com.biztest.demo.service.UserService;
import com.biztest.demo.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class democontroller {
    @Autowired
    private UserService userService;
    UserEntity userEntity;
    @ResponseBody
    @RequestMapping("/dologin")
    public String login(HttpServletRequest httpServletRequest, HttpSession httpSession){
        String loginuser = httpServletRequest.getParameter("username");
        String pwd = httpServletRequest.getParameter("userpassword");
        userEntity= userService.findUser(loginuser,pwd);
        httpSession.setAttribute("user", userEntity);
        //System.out.println();
       // System.out.println(userEntity.getUserId());
        String msg="";
        if(userEntity!=null){
            msg ="success";
            return  msg;
        }
        else {
            msg="fail";
            return msg;
        }
    }


    @RequestMapping("/")
    public String index(Model model, HttpServletResponse response) {
       // model.addAttribute("name", "simonsfan");
        return "/index";
    }
   /* @RequestMapping("/login")
    public String dologin(Model model, HttpServletResponse response) {
        // model.addAttribute("name", "simonsfan");
        return "login";
    }*/
    @RequestMapping("/addUser")
    public String addUser(UserEntity userEntity, HttpServletResponse response) {
        System.out.println(userEntity);
        userEntity.setUserstatus(0);
        userService.addUser(userEntity);
        return "/index";
    }


}
