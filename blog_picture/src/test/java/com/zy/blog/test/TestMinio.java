package com.zy.blog.test;

import io.minio.MinioClient;
import io.minio.ObjectWriteResponse;
import io.minio.PutObjectArgs;
import io.minio.UploadObjectArgs;
import org.junit.Test;
import reactor.core.publisher.Mono;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: 小章鱼
 * @date: 2022/5/31 23:58
 **/
public class TestMinio {

    @Test
    public void testUpload(){
        MinioClient client = MinioClient.builder()
                .endpoint("http://106.14.136.83:9090/")
                .credentials("admin","admin123456").build();

        try {


            File file = new File("C:/Users/xzy/Desktop/123.png");
            InputStream in = new FileInputStream(file);
            String fileName = file.getName();
            //文件上传到minio上的Name把文件后缀带上，不然下载出现格式问题
            fileName = "/a/b/c/123."+fileName.substring(fileName.lastIndexOf(".") + 1);

            //创建头部信息
            Map<String, String> headers = new HashMap<>(10);
            //添加自定义内容类型
            headers.put("Content-Type", "application/octet-stream");
            //添加存储类
            headers.put("X-Amz-Storage-Class", "REDUCED_REDUNDANCY");
            //添加自定义/用户元数据
            Map<String, String> userMetadata = new HashMap<>(10);
            userMetadata.put("My-Project", "Project One");
            //上传
            final ObjectWriteResponse blog = client.putObject(
                    PutObjectArgs.builder().bucket("blog").object(fileName).stream(
                            in, in.available(), -1)
                            .headers(headers)
                            .userMetadata(userMetadata)
                            .build());
            /*UploadObjectArgs.Builder builder =UploadObjectArgs.builder();
            builder.bucket("blog").object(fileName);*/
            in.close();
            System.out.println();
        }catch (Exception e){
            e.printStackTrace();

        }

    }
}
