package com.zeroten.javales001.IO;

import java.io.File;
import java.io.IOException;

/**
 * 文件名称： com.zeroten.javales001.IO.IOTest
 * 初始作者： Francis.Ding</br>
 * 创建日期： 2020/2/11 20:32</br>
 * 功能说明： 【】 <br/>
 * =================================================<br/>
 * 修改记录：<br/>
 * 修改作者 日期 修改内容<br/>
 * ================================================<br/>
 * Copyright (c) 2019-2020 .All rights reserved.<br/>
 */
public class IOTest {

    public static void main(String[] args) throws Exception {
        //文件在代码中表现的形式
        //在创建File对象的时候,其实就是一个对象，没有读取文件，也不会取验证
//        File f1 = new File("文件的路径（全路径）");    //
//        File f2 = new File("文件路径","文件名");   //

        //路径：
        //在windows当中\\
        //在linux当中：/
//        dir1();
//        dir2();
        dir4();
    }


    //目录的创建
    public static void dir1(){
        File f = new File("C://斌斌的故事//斌斌的前三十年//第二年");//目录
        //没有哪个规定文件一定要有后缀
        System.out.println("文件或者目录是否存在"+f.exists());//判断文件或者目录是否存在
        if(!f.exists()){
//            boolean b = f.mkdir();//创建目录,不会创建不存在的父目录
            boolean b = f.mkdirs();//创建目录,同事创建父目录
            System.out.println(b);
        }
    }


    //创建文件
    public static void dir2() throws IOException {
        File f = new File("C://斌斌的故事//斌斌的前三十年//第二年","《斌斌和志林不得不说的故事》.txt");//目录
        if(!f.exists()){
            boolean b = f.createNewFile();//创建文件
            System.out.println(b);
        }
    }

    //判断是否是文件/目录
    public static void dir3() throws IOException {
        File f1 = new File("C://斌斌的故事//斌斌的前三十年//第二年");//目录
        File f2 = new File("C://斌斌的故事//斌斌的前三十年//第二年","《斌斌和志林不得不说的故事》.txt");//文件

        System.out.println("是否是目录"+f1.isDirectory());
        System.out.println("是否是文件"+f1.isFile());

        System.out.println("是否是目录"+f2.isDirectory());
        System.out.println("是否是文件"+f2.isFile());

    }

    //文件其他方法
    public static void dir4(){
        File f1 = new File("C://斌斌的故事//斌斌的前三十年//第二年");//目录
        //通常是需要找到在容器中的位置，在web当中有专门的方法
        File f2 = new File("C://斌斌的故事//斌斌的前三十年//第二年","《斌斌和志林不得不说的故事》.txt");//文件
        System.out.println(f2.length());//字节长度
        File[] files = f1.listFiles();
        System.out.println(files);

    }
}
