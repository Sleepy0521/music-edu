package com.music.file;

import com.music.utils.DateUtil;
import lombok.experimental.var;
import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.Java2DFrameConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

@Component
public class FileUtil {

    @Value("${file.uploadFolder}")
    public String uploadFolder ; //     /home/sleepy/music/uploadFolder/  对外暴漏路径  /music/download/**
    //上传文件处理方法
    public String upFileMethod(MultipartFile upFile,String fileName){
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

    public String upFileMethod(MultipartFile file) {
        String fileName=file.getOriginalFilename();
        return upFileMethod(file,fileName);
    }
}
