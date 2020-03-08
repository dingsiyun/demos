package com.zeroten.javales001.IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 文件名称： com.zeroten.javales001.IO.IOTest2
 * 初始作者： Francis.Ding</br>
 * 创建日期： 2020/2/11 21:11</br>
 * 功能说明： 【】 <br/>
 * =================================================<br/>
 * 修改记录：<br/>
 * 修改作者 日期 修改内容<br/>
 * ================================================<br/>
 * Copyright (c) 2019-2020 .All rights reserved.<br/>
 */
public class IOTest2 {
    public static void main(String[] args) throws IOException {
        //使用流操作文件
        File f = new File("C://斌斌的故事//斌斌的前三十年//第二年","《斌斌和志林不得不说的故事》.txt");//文件
        long len1 = f.length();
        //注意
        //这只是个demo ~
        //目的：明白字节流的使用方法
        InputStream input = new FileInputStream(f);
        int len2 = input.available();//获取可读数据的大小(单位字节)

        byte[] bs = new byte[len2]; //用与保存，读取的文件数据；
//        input.read(bs);//一次读一个字节 //输入流将直接写入内存地址(太粗暴)
//        String str = new String(bs);
//        System.out.println(str);
        //1.如何暂时保存读到的数据
        byte temp = -1;//用于临时保存督导的数据
        //2.如何把数据写入数组
        int index = 0;
        //使用循环,一次读
        while((temp = (byte)input.read())!=-1){
            bs[index] = temp;
            index++;
        }
        String str = new String(bs);
        System.out.println(str);
        input.close();

    }
}
