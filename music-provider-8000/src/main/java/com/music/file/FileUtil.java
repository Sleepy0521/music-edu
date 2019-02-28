package com.music.file;

import com.music.utils.DateUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Component
public class FileUtil {

    @Value("${file.uploadFolder}")
    public String uploadFolder ; //     /home/sleepy/music/uploadFolder/  对外暴漏路径  /music/download/**
    //上传文件处理方法
    public String upFileMethod(MultipartFile upFile){
        String fileName = upFile.getOriginalFilename();
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        File file= new File(uploadFolder);
        if(!file.exists()){
            file.mkdirs();
        }
        try {
            InputStream is = upFile.getInputStream();
            FileOutputStream fos = new FileOutputStream(uploadFolder+ DateUtil.getCurrentDate()+"-"+fileName );
            bis=new BufferedInputStream(is);
            bos=new BufferedOutputStream(fos);
            int len;
            byte[] bytes = new byte[1024];
            while((len = bis.read(bytes)) != -1) {
                bos.write(bytes, 0, len);
                bos.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bos!=null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bis!=null){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return DateUtil.getCurrentDate()+"-"+fileName;
    }
}
