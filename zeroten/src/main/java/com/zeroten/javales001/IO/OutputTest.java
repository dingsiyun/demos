package com.zeroten.javales001.IO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

/**
 * 文件名称： com.zeroten.javales001.IO.OutputTest
 * 初始作者： Francis.Ding</br>
 * 创建日期： 2020/2/11 21:38</br>
 * 功能说明： 【】 <br/>
 * =================================================<br/>
 * 修改记录：<br/>
 * 修改作者 日期 修改内容<br/>
 * ================================================<br/>
 * Copyright (c) 2019-2020 .All rights reserved.<br/>
 */
public class OutputTest {

    //程序:以程序作为参照物
    public static void main(String[] args) throws IOException {
        //使用流操作文件
        File f = new File("C://斌斌的故事//斌斌的前三十年//第二年","《斌斌和志林不得不说的故事》.txt");//文件
        //输出流,是覆盖原文件里的内容,不是追加
        String str = "第一章\r\n那一年,哪一个风雨交加的……此处省略一万字";
        OutputStream out = new FileOutputStream(f);
         //第一步 获取字节
        byte[] bytes = str.getBytes();
//        out.write(bytes);
        for (byte b:bytes) {
            out.write(b);
        }
        out.flush();//把缓存区的数据推送到输出流里(看数据量)4
        out.close();
        Scanner sc = new Scanner(System.in);
        sc.next();
    }
}
