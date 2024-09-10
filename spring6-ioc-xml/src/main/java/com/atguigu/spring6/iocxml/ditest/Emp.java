package com.atguigu.spring6.iocxml.ditest;

import java.util.Arrays;

//员工类
public class Emp {

    //员工属于某个部门
    //对象类型属性
    private Dept dept;

    //员工名称
    private String eName;
    //员工年龄
    private Integer eAge;

    private String[] hobbies;

    public String[] getHobbies() {
        return hobbies;
    }

    public void setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public void seteAge(Integer eAge) {
        this.eAge = eAge;
    }


    public void work(){
        System.out.println(eName + " 员工正在工作 " + eAge);
        dept.info();
        System.out.println(Arrays.toString(hobbies));
    }

    public Dept getDept() {
        return dept;
    }

    public String geteName() {
        return eName;
    }

    public Integer geteAge() {
        return eAge;
    }
}
