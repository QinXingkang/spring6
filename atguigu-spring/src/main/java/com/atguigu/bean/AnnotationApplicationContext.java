package com.atguigu.bean;

import com.atguigu.annotation.Bean;
import com.atguigu.annotation.Di;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AnnotationApplicationContext implements ApplicationContext {

    //创建map集合，用于存放bean对象
    private  Map<Class,Object> beanFactory = new HashMap<>();

    private static String rootPath;

    //返回对象
    @Override
    public Object getBean(Class clazz) {
        return beanFactory.get(clazz);
    }

    //设置包扫描规则
    //当前包及其子包，哪个类上有@Bean注解，把这个类通过反射实例化
    //创建有参构造器，传递包路径
    public AnnotationApplicationContext(String basePackage) {
        //com.atguigu

        try {
            //1.把"."替换成\"
            String packagePath = basePackage.replaceAll("\\.", "\\\\");

            //获取包的绝对路径
            Enumeration<URL> urls = Thread.currentThread().getContextClassLoader().getResources(packagePath);

            while (urls.hasMoreElements()) {
                URL url = urls.nextElement();
                String filePath = URLDecoder.decode(url.getFile(), "UTF-8");

                //获取包前面的路径部分，进行字符串截取
                rootPath = filePath.substring(0, filePath.length() - packagePath.length());

                //包扫描
                loadBean(new File(filePath));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //包扫描过程，实例化
    private void loadBean(File file) {
        //1.判断当前是否是文件夹
        if (file.isDirectory()) {
            //2.是文件夹，获取文件夹里面所有内容
            File[] childrenFiles = file.listFiles();

            //3.判断文件夹里面为空，直接返回
            if(childrenFiles == null || childrenFiles.length == 0) {
                return;
            }

            //4.文件夹不为空，遍历文件夹里面的所有内容
            for (File childFile : childrenFiles) {
                //4.1 遍历得到每个File对象，继续判断，如果还是一个文件夹，递归
                if(childFile.isDirectory()) {
                    loadBean(childFile);
                }else {
                    //4.2 遍历得到的File不是文件夹（即为文件）
                    //4.3 得到包路径+类名称部分-字符串截取
                    String pathWithClass = childFile.getAbsolutePath().substring(rootPath.length() - 1);

                    //4.4 判断当前文件类型是否是 .class 类型
                    if(pathWithClass.contains(".class")) {
                        //4.5 如果是.class类型，把路径中的"\" 替换成 "." 把 .class 部分去掉
                        //最终为 com.atguigu.service.UserServiceImpl
                        String allName = pathWithClass.replaceAll("\\\\", ".").replace(".class", "");

                        //4.6 判断类上面是否有 @Bean 注解，如果有再进行实例化过程

                        try {
                            //4.6.1 获取类的Class对象
                            Class<?> clazz = Class.forName(allName);

                            //4.6.2 判断不是接口，再实例化
                            if(!clazz.isInterface()){
                                //4.6.3 判断类上是否有注解@Bean
                                Bean annotation = clazz.getAnnotation(Bean.class);
                                if(annotation != null) {
                                    //4.6.4 实例化
                                    Object instance = clazz.getConstructor().newInstance();
                                    //4.7 把对象实例化之后，放到map集合beanFactory中
                                    //4.7.1 判断当前类如果有接口，让接口class作为map的key
                                    if(clazz.getInterfaces().length > 0) {
                                        beanFactory.put(clazz.getInterfaces()[0],instance);
                                    }else {
                                        beanFactory.put(clazz,instance);
                                    }
                                }
                            }

                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }


                        //属性注入
                        loadDi();
                    }
                }
            }
        }
    }

    //属性注入
    private void loadDi() {
        //实例化的对象都在beanFactory的map集合里面
        //1 遍历beanFactory的map集合
        Set<Map.Entry<Class, Object>> entries = beanFactory.entrySet();
        for (Map.Entry<Class, Object> entry :entries) {
            //2 获取map集合里面的每个对象（value）
            Object obj = entry.getValue();

            //获取对象的Class
            Class<?> clazz = obj.getClass();

            //再获取每个对象的属性
            Field[] declaredFields = clazz.getDeclaredFields();

            //3 遍历得到的每个对象的属性数组，得到每个属性
            for (Field field :declaredFields) {
                //4 判断属性上是否有@Di的注解
                Di annotation = field.getAnnotation(Di.class);
                if(annotation != null) {//annotation不为空，表示属性上有注解
                    field.setAccessible(true);

                    //5 如果有@Di的注解，把对象进行设置（注入）
                    try {
                        field.set(obj,beanFactory.get(field.getType()));
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

        }








    }
}
