package com.zeroten.javales001.IO;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

/**
 * 文件名称： com.zeroten.javales001.IO.WriterDemo2
 * 初始作者： Francis.Ding</br>
 * 创建日期： 2020/2/13 21:11</br>
 * 功能说明： 【】 <br/>
 * =================================================<br/>
 * 修改记录：<br/>
 * 修改作者 日期 修改内容<br/>
 * ================================================<br/>
 * Copyright (c) 2019-2020 .All rights reserved.<br/>
 */
public class WriterDemo2 {

    public static void main(String[] args) throws IOException {
        BufferedWriter w = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("C:/斌斌的故事/斌斌的前三十年/第二年/《斌斌和志林不得不说的故事》.txt"))));

        w.write("斌斌，很帅！！！！！大家都爱看！！！！");
        w.flush();//清空缓冲区
        w.close();
    }
}
