package com.atguigu.reflect;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Arrays;

public class TestCar {

    //1.获取Class对象的多种方式
    @Test
    public void test01() throws Exception {
        //1.通过类名.class获取
        Class<Car> clazz1 = Car.class;

        //2.对象.getClass()
        Class clazz2 = new Car().getClass();

        //3.Class.forName("全路径")
        Class clazz3 = Class.forName("com.atguigu.reflect.Car");

        //实例化
        Car car =(Car) clazz3.getDeclaredConstructor().newInstance();
        System.out.println(car);
    }

    //2.用反射获取类中的构造方法
    @Test
    public void test02() throws Exception {
        Class clazz = Car.class;
        //获取所有构造器
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor.getName() + " " + constructor.getParameterCount());
        }

        //指定有参构造器创建对象
        //1.public修饰的构造器
        Constructor constructor1 = clazz.getConstructor(String.class, int.class, String.class);
        Car car1 =(Car) constructor1.newInstance("夏利", 10, "蓝色");
        System.out.println(car1);

        //2.private修饰的构造器
        Constructor constructor2 = clazz.getDeclaredConstructor(String.class, int.class, String.class);
        constructor2.setAccessible(true);
        Car car2 =(Car) constructor2.newInstance("宾利", 20, "红色");
        System.out.println(car2);
    }



    //3.通过反射获取类中的属性
    @Test
    public void test03() throws Exception {
        Class clazz = Car.class;
        Car car =(Car) clazz.getDeclaredConstructor().newInstance();
        //获取所有public修饰的属性
        Field[] fields1 = clazz.getFields();

        //获取所有的属性
        Field[] fields2 = clazz.getDeclaredFields();
        for (Field field : fields2) {
            if (field.getName().equals("name")) {
                //设置允许访问
                field.setAccessible(true);
                field.set(car,"五菱宏光");
            }
            System.out.println(field.getName());
            System.out.println(car);
        }
    }

    //4.通过反射获取类中所有的方法
    @Test
    public void test04() throws Exception {
        Car car = new Car("保时捷", 5, "白色");
        Class clazz = car.getClass();
    }
}
