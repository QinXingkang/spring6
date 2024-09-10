package com.atguigu.spring6.iocxml.dimap;

public class Teacher {

    private String tName;
    private String tId;


    @Override
    public String toString() {
        return "Teacher{" +
                "tName='" + tName + '\'' +
                ", tId='" + tId + '\'' +
                '}';
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public String gettId() {
        return tId;
    }

    public void settId(String tId) {
        this.tId = tId;
    }
}
