package com.atguigu.spring6.iocxml.di;

public class Book {

    private String BookName;
    private String Author;
    private String others;

    //生成set方法

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others;
    }
    //生成构造器注入


    public Book() {
        System.out.println("无参数构造执行了");

    }

    //有参构造器
    public Book(String bookName, String author) {
        System.out.println("有参数构造执行了");
        BookName = bookName;
        Author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "BookName='" + BookName + '\'' +
                ", Author='" + Author + '\'' +
                ", others='" + others + '\'' +
                '}';
    }

    public static void main(String[] args) {
        //set方法注入
        Book book = new Book();
        book.setBookName("java");
        book.setAuthor("atguigu");

        //通过构造器注入
        Book book1 = new Book("c++", "aiguigu");
    }
}
