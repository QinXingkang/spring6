package com.atguigu.spring6.iocxml.ditest;

import org.springframework.beans.factory.parsing.EmptyReaderEventListener;

import java.util.List;

//部门类
public class Dept {

    //一个部门有很多员工
    private List<Emp> empList;

    public List<Emp> getEmpList() {
        return empList;
    }

    public void setEmpList(List<Emp> empList) {
        this.empList = empList;
    }

    private String dName;

    public void setdName(String dName) {
        this.dName = dName;
    }


    public void info(){
        System.out.println("部门名称 " + dName);
        for (Emp emp : empList) {
            System.out.println(emp.geteName());
        }

    }


    public String getdName() {
        return dName;
    }
}
