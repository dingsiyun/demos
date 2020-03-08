package com.zeroten.javales001.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * 文件名称： com.zeroten.javales001.list.map.MapTest
 * 初始作者： Francis.Ding</br>
 * 创建日期： 2020/2/4 15:18</br>
 * 功能说明： 【】 <br/>
 * =================================================<br/>
 * 修改记录：<br/>
 * 修改作者 日期 修改内容<br/>
 * ================================================<br/>
 * Copyright (c) 2019-2020 .All rights reserved.<br/>
 */
public class MapTest {

    /**
     * 内容-Map
     *
     * 散列表相关知识
     * HashMap
     *      内部实现
     *      常用方法
     * TreeMap
     */

    /**
     * 散列表 HashTable：也是哈希表
     * 根据数组可以使用下标的方式来快速随机访问来实现的
     * 比如：存放一组数据：aaa,cde,bfk,……
     * 如何快速的定位和查找？
     *
     *String [] str;
     *哈希函数：将关键字转化成一个正整数,
     * int hashFn(Object object)
     * aaa-> 256
     * cde-> 258
     * bfk-> 259
     *
     * str [256] ="aaa"
     * str [258] ="cde"
     * str [259] ="bfk"
     * aak -> 256
     *
     * 哈希函数最理想的状态：
     * 1.哈希结果应该是一个正整数
     * 2.str1 == str2, hash(str1) == hash(str2)
     * 3.str1 != str2, hash(str1) != hash(str2)
     *
     * 第三种情况基本不可能，不会存在这么一个函数
     * MD5,SHA,CRC 这些算法都可能会产生重复值
     *
     * 哈希冲突：不同的键值,通过哈希函数返回了相同的结果
     *
     * 如何解决哈希冲突：通过链表方式
     * 数组里面不直接存值:存一个自定义对象
     *
     * Node{
     *      Node next; //下一个节点
     *      Node prev; //前一个节点
     *     Object item;//值
     * }
     *
     *  aaa -> 256
     *  str [256] = {prev:null,item: aaa, next: null};
     *  aak -> 256
     *  str [256] = {{prev:null,item: aaa, next: {prev:指向aak,item: aaa, next: null}},};
     *
     *
     * HashMap ->
     */
    public static void main(String[] args) {
        //HashMap
        // 1.构建
        HashMap<String,Student> map = new HashMap<String, Student>();

        //添加
        Student s1 = map.put("001",new Student("张三",20));
        map.put("002",new Student("李四",25));
        map.put("005",new Student("李四",25));
        map.put("003",new Student("李四",25));
        map.put("008",new Student("李四",25));
        map.put("006",new Student("李四",25));
        Student s2 = map.put("001",new Student("aa",20));
        System.out.println("s1="+s1);
        System.out.println("s2="+s2);

        //3.遍历
        //键值 - 值
        //Map 严格意义上来讲，不是一个集合
        //可以把这三个视图当成集合类来操作
        //3.1 键值视图，Set
        //3.2 值视图，Collection
        //3.3 键值对视图，Entry
        Set<String> keys = map.keySet();
        System.out.println(keys);
        Collection<Student> values = map.values();
        System.out.println(values);
        Set<Map.Entry<String, Student>> entries = map.entrySet();
        System.out.println(entries);

        for (Map.Entry<String,Student> entry:entries) {
            System.out.println(entry.getKey()+"="+entry.getValue());
        }

        for (String key:keys) {
            System.out.println(key);
            Student val = map.get(key);
            System.out.println("get value:"+val);
        }
        //4.删除
        map.remove("001");
        System.out.println(map);

        //set,map 无序的时候，不饿能使用下标的方式

        //特殊元素 null
        map.put(null,new Student("无人",0));
        map.put("null",null);

        HashMap<String, Student> map2 = new HashMap<String, Student>(map);

        HashMap<String, Student> map3 = new HashMap<String, Student>(10);

        //构建：1无参数构造；2，使用一个已存在的Map作为初始化值；3.指定容量
        //put(key,val)
        //  1 key 不存在，直接将 key -> value 存储,b并返回 null
        //  2 key 已经存在， 将key值对应的值替换为新值，并且返回旧值
        // V get(key)
        //  1. key 存在，则返回 key 值对应的值
        //  2. key 不存在，则返回 null
        // 是否存在
        // key 是否存在 - containsKey
        // value 是否存在 - containsValue
        // 遍历：可以获取集合的三种视图
        //  1.键值集 keySet()
        //  2.值集合 values()
        //  3.键值对集 entrySet(). 如果没有仅使用 key 或 value时, 使用此方式遍历

        // HashMao 内部结构: 散列表/哈希表,数组散列表

        // 对应自定义类 默认对比的是引用
        // 如果要实现值比较,需要覆写, equals 方法
        // 覆写 equals 方法的同时需要修改 hashCode 方法
        // 计算哈希值时,key.hashCode()
        // 在桶内比较某个key 值是否存在使用的是 key.equalse(inputKey);
        // "001":{name:"n1",age:2}
        // "010":{name:"n1",age:2}
        // hashCode() 返回的值相等时， equals 比较y应该返回 true
        // equals 比较返回 true 那么 hashCode() 返回的值应该相等
        // hashCode 相等, equals 也要为true
        // hashCode(001) = 1, 1 % 3 =1
        // hashCode(002) = 1, 1 % 3 =1
        // 循环链表找 key,
        // hash == hash && key.equals()
        if(map.containsKey("007")){
            System.out.println("007不存在");
        }

        HashMap<Key,Student> map4 = new HashMap<>();
        map4.put(new Key(1),new Student("张三",22));
        map4.put(new Key(1),new Student("李四",25));
        System.out.println(map4);
    }

    static class Key{
        Integer i ;

        public Key(Integer i) {
            this.i = i;
        }

        @Override
        public boolean equals(Object o) {
           if(o instanceof Key){
               Key key = (Key) o;
               return  i !=null && i.equals(key.i);
           }

            return  false;
        }

        @Override
        public int hashCode() {
            return i == null ? 0 : i.hashCode();
        }

        public Integer getI() {
            return i;
        }

        public void setI(Integer i) {
            this.i = i;
        }

        @Override
        public String toString() {
            return "Key{" +
                    "i=" + i +
                    '}';
        }
    }

    static class Student{
        String name;
        Integer age;

        public Student(String name,Integer age){
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
