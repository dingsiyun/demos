package com.zeroten.javales001.map;

import java.util.TreeMap;
import java.util.TreeSet;

/**
 * 文件名称： com.zeroten.javales001.map.SetTest
 * 初始作者： Francis.Ding</br>
 * 创建日期： 2020/2/9 21:32</br>
 * 功能说明： 【】 <br/>
 * =================================================<br/>
 * 修改记录：<br/>
 * 修改作者 日期 修改内容<br/>
 * ================================================<br/>
 * Copyright (c) 2019-2020 .All rights reserved.<br/>
 */
public class SetTest {
    public static void main(String[] args) {
        //集合类
        //Collection
            // List 集合
            // Set  集
            // Queue 队列
        // Map 键值对,散列
        // Set 内部使用的是对应的 Map 来实现的
        // Map 的 key值 即是存放 Set 的值
        // Key值对应的value 存放的是一个固定的值 static new Object();
        // HashSet -> HashMap;
        // TreeSet -> TreeMap;
        // Map中key值 不能重复 可以为null
        // 所以set的值 不能重复 可以为null
        // 1 构造TreeSet时 如果指定了 Comparator, 则可以存放 null
        // 2 构造TreeSet时 如果未指定了 Comparator, 则需要调用存入对象的comparato方法,如果对象为空则抛出NullPointerException
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("Str1");  //内部调用的是Map的put("Str1",PRESENT);
        treeSet.add("Str2");
        treeSet.add("Str3");

        //Set主要作用？ 判断某个指定的元素在集合中是否存在 hashSet.contains(null);

        //EnumSet 内部使用的是一个枚举类的数组
    }
}
