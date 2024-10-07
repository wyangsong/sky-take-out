package com.sky.utils;

import org.springframework.boot.system.ApplicationHome;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

/**
 * 本地文件上传工具
 */
public class LocalLoadFileUtil {
    public static String uploadImage(MultipartFile file){
        String originalFilename = file.getOriginalFilename();
        String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
        String fileName = UUID.randomUUID().toString()+extension;
        ApplicationHome applicationHome = new ApplicationHome(LocalLoadFileUtil.class);
        // 获取项目路径,linux系统下为/src/main/resources/image
        String prePath = applicationHome.getSource().getParentFile().getParentFile().getAbsolutePath()+
                "\\src\\main\\resources\\static\\images\\";
        String newPath = prePath+fileName;
        try {
            file.transferTo(new java.io.File(newPath));
            return fileName;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newPath;
    }
}
