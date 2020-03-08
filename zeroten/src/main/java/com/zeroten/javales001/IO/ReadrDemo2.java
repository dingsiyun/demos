package com.zeroten.javales001.IO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 文件名称： com.zeroten.javales001.IO.ReadrDemo2
 * 初始作者： Francis.Ding</br>
 * 创建日期： 2020/2/13 20:52</br>
 * 功能说明： 【】 <br/>
 * =================================================<br/>
 * 修改记录：<br/>
 * 修改作者 日期 修改内容<br/>
 * ================================================<br/>
 * Copyright (c) 2019-2020 .All rights reserved.<br/>
 */
public class ReadrDemo2 {
    public static void main(String[] args) throws IOException {
        //缓存:默认8192 8k
        File f = new File("C:/斌斌的故事/斌斌的前三十年/第二年/《斌斌和志林不得不说的故事》.txt");
        BufferedReader r = new BufferedReader(new InputStreamReader(new FileInputStream(f)));

        //字符流开始,缓存才有意义
        StringBuffer str = new StringBuffer();
        String s = "";
        while ((s=r.readLine())!=null){
            str.append(s);
        }
    }
}
