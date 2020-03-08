package com.zeroten.javales001.IO;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 文件名称： com.zeroten.javales001.IO.DataStreamDemo
 * 初始作者： Francis.Ding</br>
 * 创建日期： 2020/2/13 21:16</br>
 * 功能说明： 【】 <br/>
 * =================================================<br/>
 * 修改记录：<br/>
 * 修改作者 日期 修改内容<br/>
 * ================================================<br/>
 * Copyright (c) 2019-2020 .All rights reserved.<br/>
 */
public class DataStreamDemo {
    public static void main(String[] args) throws IOException {
        //这是个文件，用于保存【数据】
        //把文件当成持久化的对象
//        File f = new File("C:\\斌斌的故事\\斌斌的前三十年\\第一年\\person.md");
//        if(!f.exists()){
//            f.createNewFile();
//        }
//        //不是序列化
//        DataOutputStream out = new DataOutputStream(new FileOutputStream(f));
//        out.writeUTF("ybb");
//        out.writeInt(18);
//        out.writeDouble(50000.00);
//        out.flush();
//        out.close();
        File f = new File("C:\\斌斌的故事\\斌斌的前三十年\\第一年\\person.md");
                DataInputStream in = new DataInputStream(new FileInputStream(f));
        System.out.println(in.readUTF());
        System.out.println(in.readInt());
        System.out.println(in.readDouble());
        in.close();
    }
}
