package com.biztest.demo.serviceImpl;

import com.biztest.demo.DAO.FileUpDownDAO;
import com.biztest.demo.service.FileUpDownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class FileUpDownServiceImpl implements FileUpDownService {
    @Autowired
    FileUpDownDAO fileUpDownDAO;

    @Override
    public void delFile(int fileid) {
        fileUpDownDAO.delfile(fileid);
    }


}
