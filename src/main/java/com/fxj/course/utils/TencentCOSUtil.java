package com.fxj.course.utils;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.region.Region;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class TencentCOSUtil {
    // 存储桶
    private static final String bucketName = "examplecourse-1304676805";
//    secretId
    private static final String SecretId = "AKIDJMAi01oGSOJ0RUAwIWXZR4QWLvEInxSi";
//    secretKey
    private static final String SecretKey = "MtUpxsY7RdaIju23oKgmcokqhHo67C3h";
//    访问域名
    private static final String URL = "https://examplecourse-1304676805.cos.ap-chengdu.myqcloud.com";
//    自定义文件夹名称
    private static final String prefix = "/course/";
//    创建cos凭证
    private static COSCredentials credentials = new BasicCOSCredentials(SecretId,SecretKey);
//    配置区域
    private static ClientConfig clientConfig = new ClientConfig(new Region("ap-chengdu"));

    public static String uploadfile(MultipartFile file) {
//        创建cos客户端连接
        COSClient cosClient = new COSClient(credentials,clientConfig);
        String fileName = file.getOriginalFilename();
        try {
            String substring = fileName.substring(fileName.lastIndexOf("."));
            File localFile = File.createTempFile(String.valueOf(System.currentTimeMillis()),substring);
            file.transferTo(localFile);
            Random random = new Random();
            fileName = prefix + random.nextInt(10000)+System.currentTimeMillis()+substring;
//            上传文件
            PutObjectRequest objectRequest = new PutObjectRequest(bucketName,fileName,localFile);
            cosClient.putObject(objectRequest);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            cosClient.shutdown();
        }
        return URL+fileName;
    }
}
