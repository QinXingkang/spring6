package com.atguigu.spring6.resource;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import java.net.MalformedURLException;

//演示UrlResource访问网络资源
public class UrlResourceDemo {
    public static void main(String[] args) {
        //http
//        loadUrlResource("http://www.baidu.com");

        //file
        loadUrlResource("file:atguigu.txt");
    }

    //http：该前缀用于访问基于HTTP协议的网络资源
    public static void loadUrlResource(String path){
        try {
            //1.创建Resource实现类的对象 UrlResource
            Resource url = new UrlResource(path);
            //2.获取资源信息
            System.out.println(url.getFilename());
            System.out.println(url.getURL());
            System.out.println(url.getDescription());
            System.out.println(url.getInputStream().available());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //file：该前缀用于从文件系统中读取资源

}
