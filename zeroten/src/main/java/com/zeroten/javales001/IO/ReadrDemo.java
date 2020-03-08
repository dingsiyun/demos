package com.zeroten.javales001.IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.LinkedList;

/**
 * 文件名称： com.zeroten.javales001.IO.ReadrDemo
 * 初始作者： Francis.Ding</br>
 * 创建日期： 2020/2/13 20:05</br>
 * 功能说明： 【】 <br/>
 * =================================================<br/>
 * 修改记录：<br/>
 * 修改作者 日期 修改内容<br/>
 * ================================================<br/>
 * Copyright (c) 2019-2020 .All rights reserved.<br/>
 */
public class ReadrDemo {

    public static void main(String[] args) throws IOException {
        //字符流
        //InputStreamReader(InputStream in)//参数
        //InputStreamReader(InputStream in, Charset cs) //设置字符集
        //一般常用字符集：GBK/UTF-8/GB2312/ISO-8859-1--->保证统一
        //字符串可以指定编码集的编码和解码
//        String s = new String(bytes,"newcharset");
//        String s2 = "".getBytes("charset");
        Reader r = new InputStreamReader(new FileInputStream(new File("C:/斌斌的故事/斌斌的前三十年/第二年/《斌斌和志林不得不说的故事》.txt")));
        //char == int
        int c = -1;
        StringBuffer s = new StringBuffer("");
        while ((c = r.read())!=-1){
            s.append((char)c);
        }
        System.out.println(s.toString());

    }
}
