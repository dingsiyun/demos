package com.zeroten.javales001.IO;

import com.zeroten.javales001.IO.entity.Person;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 文件名称： com.zeroten.javales001.IO.SerDemo
 * 初始作者： Francis.Ding</br>
 * 创建日期： 2020/2/13 21:47</br>
 * 功能说明： 【】 <br/>
 * =================================================<br/>
 * 修改记录：<br/>
 * 修改作者 日期 修改内容<br/>
 * ================================================<br/>
 * Copyright (c) 2019-2020 .All rights reserved.<br/>
 */
public class SerDemo {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person p = new Person(1,"ybb",18);

        //直接把内存数据序列化到文件里了
//        File f = new File("C:\\斌斌的故事\\斌斌的前三十年\\第一年\\person.o2");
//        if (!f.exists())f.createNewFile();
//        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f));
//        out.writeObject(p);
//        out.flush();
//        out.close();

        File f = new File("C:\\斌斌的故事\\斌斌的前三十年\\第一年\\person.o2");
        if (!f.exists())f.createNewFile();
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));
        Object o = in.readObject();
        if(o instanceof Person){
            Person p2 = Person.valueOf(o);
            System.out.println(p2);
        }
        in.close();
    }
}
