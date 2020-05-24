package com.pzd.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class FileUploadUtils {
    public static String upload(MultipartFile file, String path) {
        String fileName = file.getOriginalFilename();
        String extName = fileName.substring(fileName.lastIndexOf("."));
        String uuid = UUID.randomUUID().toString().replace("-", "");
        fileName = path + uuid + extName;
        try {
            file.transferTo(new File(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return uuid + extName;
    }
}
