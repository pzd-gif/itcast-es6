package com.pzd.controller;

import com.pzd.util.FileUploadUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("upload")
public class UploadController {
    @RequestMapping("img")
    public String uploadImg(MultipartFile file){
        return FileUploadUtils.upload(file,"D:/test/img/");
    }
}
