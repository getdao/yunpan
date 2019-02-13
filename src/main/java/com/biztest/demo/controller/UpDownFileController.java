package com.biztest.demo.controller;

import com.biztest.demo.DAO.FileUpDownDAO;
import com.biztest.demo.entity.FileEntity;
import com.biztest.demo.entity.UserEntity;
import com.biztest.demo.service.FileService;
import com.biztest.demo.service.FileUpDownService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.Date;
import java.util.List;

@Controller
public class UpDownFileController {
    private final Logger LOGGER = LoggerFactory.getLogger(UpDownFileController.class);
    @Autowired
    private  FileUpDownService fileUpDownService;
    @Autowired
    private FileUpDownDAO fileUpDownDAO;
    @Autowired
    FileService fileService;

    @RequestMapping (value = "/FileUp",method = RequestMethod.POST)
    @ResponseBody
    public String multiUpload(HttpSession HttpSession,HttpServletRequest request) {
        String hahaha = null;
        String hehehe = null;
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("upFile");
        UserEntity user = (UserEntity) HttpSession.getAttribute("user");

        String filePath = "D://upload/";
//        File catalog = new File(filePath);
//        if(!(catalog.exists())){
//            catalog.mkdir();
//        }

        FileEntity f2=new FileEntity();

        for (int i = 0; i < files.size(); i++) {
            MultipartFile file = files.get(i);
            String filename = file.getOriginalFilename();
            String[] arr = filename.split("\\.");
            f2 =fileService.findByfilename(filename);
            if (f2!=null) {
                hehehe = "上传文件失败,文件已存在";
            }else{
                String exension = arr[arr.length-1];
                String fileType = "文件类型";
                if(exension.equals("png")||exension.equals("gif")||exension.equals("jpg")){
                    fileType = "图片";
                }else if (exension.equals("rmvb")||exension.equals("avi")||exension.equals("mp4")||exension.equals("3gp")){
                    fileType = "视频";
                }else  if(exension.equals("txt")||exension.equals("pdf")||exension.equals("docx")||exension.equals("doc")
                            ||exension.equals("ppt")||exension.equals("xls")){
                    fileType = "文档";
                }else{
                    fileType = "其他文件";
                }
                //插入数据库信息
                FileEntity fileEntity=new FileEntity();
                System.out.println(filename);
                Date date = new Date();
                fileEntity.setFiledate(date);
                fileEntity.setFilename(filename);
                fileEntity.setFilestatus(0);
                fileEntity.setFiletype(fileType);
                fileEntity.setUserid(user.getUserId());
                fileUpDownDAO.save(fileEntity);
            }
            String fileName = user.getUserId()+"."+file.getOriginalFilename();

            File dest = new File(filePath + fileName);
            try {
                file.transferTo(dest);
                LOGGER.info("第"+(i + 1) + "个文件上传成功");
                hahaha = "上传成功!";
            } catch (IOException e) {
                LOGGER.error(e.toString(), e);
                hahaha = "上传第" + (i++) + "个文件失败";
            }
        }
        if(hehehe!=null){
            return hehehe;
        }else {
            return hahaha;
        }

    }

    @RequestMapping(value = "/FileDownLoad" ,produces = "application/text;charset=utf-8")
    public void FileDownload(HttpSession HttpSession,HttpServletRequest request, HttpServletResponse response, @RequestParam("fileName")String fileName) {

        UserEntity user = (UserEntity) HttpSession.getAttribute("user");

        if (fileName != null) {
            //设置文件路径
            String realFileName = user.getUserId() + "." +fileName;
            System.out.print(realFileName);
            String fullPath = "D://upload//"+realFileName;
            File file = new File(fullPath);
            if (file.exists()) {
                String[] arr = realFileName.split("\\.");
                StringBuffer loadFileName = new StringBuffer();
                for(int i=1;i<arr.length-1;i++){
                    loadFileName.append(arr[i]+".");
                }
                loadFileName.append(arr[arr.length-1]);
                response.setContentType("application/force-download");// 设置强制下载不打开
                try{
                    response.addHeader("Content-Disposition", "attachment;fileName=" + new String( fileName.getBytes("utf-8"), "ISO8859-1" ));// 设置文件名,解决中文乱码
                }catch (IOException e){
                    e.printStackTrace();
                }
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                    LOGGER.info("用户"+user.getUsername() + "下载了文件" + fileName);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }else{
                System.out.print("文件不存在");
            }
        }
    }

    @RequestMapping(value = "/FileDelete")
    @ResponseBody
    public String FileDelete(HttpSession HttpSession,@RequestParam("fileName")String fileName,@RequestParam("fileid")int fileid){
        UserEntity user = (UserEntity) HttpSession.getAttribute("user");
        String ddd = null;
        System.out.print(fileid);
        System.out.print(fileName);

        String realFileName = user.getUserId() + "." +fileName;
        String fullPath = "D:\\upload\\"+realFileName;
        File file = new File(fullPath);
        if (file.exists()) {
            if (file.delete()) {
                ddd = "删除成功";
                fileUpDownService.delFile(fileid);
                LOGGER.info("用户"+user.getUsername() + "删除了文件" + fileName);
            } else {
                ddd = "删除失败";
            }
        }else{
            ddd = "文件不存在";
        }
        return ddd;
    }

    @RequestMapping(value = "NewFolder")
    @ResponseBody
    public String NewFolder(HttpSession HttpSession,@RequestParam("fileName")String fileName){
        UserEntity user = (UserEntity) HttpSession.getAttribute("user");
        String msg = null;
        String realFileName = user.getUserId() + "." +fileName;
        String fullPath = "D://upload//"+realFileName;
        File file = new File(fullPath);
        if(file.exists()){
            msg = "文件夹已存在,无法创建!";
        }else{
            file.mkdir();
            FileEntity f3 = new FileEntity();
            f3.setFiledate(new Date());
            f3.setUserid(user.getUserId());
            f3.setFiletype("文件夹");
            f3.setFilestatus(0);
            f3.setFilename(fileName);
            fileUpDownDAO.save(f3);
            msg = "创建成功！";
        }

        return msg;
    }
}
