package com.zeroten.javales001.map;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 文件名称： com.zeroten.javales001.map.TreeMapTest
 * 初始作者： Francis.Ding</br>
 * 创建日期： 2020/2/5 10:42</br>
 * 功能说明： 【】 <br/>
 * =================================================<br/>
 * 修改记录：<br/>
 * 修改作者 日期 修改内容<br/>
 * ================================================<br/>
 * Copyright (c) 2019-2020 .All rights reserved.<br/>
 */
public class TreeMapTest {

    public static void main(String[] args) {
        //HashMap 无序
        //TreeMap 有序,和前面的List有序不一样
        // 1.构造
        // 2.添加/删除/遍历/修改
        TreeMap<XueHao,String> map =new TreeMap<>();
        //key -学生学号
        //value - 学生信息
        //对应 TreeMap，key值对象必须实现 Comparable接口
        map.put(new XueHao(1),"张三,20");
        map.put(new XueHao(3),"李四,21");
        map.put(new XueHao(2),"王五,22");
        map.put(new XueHao(5),"555,22");
        //Map 严格来说不是一个集合,但它有三个视图，我们可以把这三个视图当成集合来用
        // key 集合
        // value 集合
        // Entry 集合
        for (Map.Entry<XueHao,String> item:map.entrySet()) {
            System.out.println(item.getKey()+"="+item.getValue());
        }

        //TreeMap 是有序的，这个有序指的是 key 值的排序
        // 那么 key 是如何排序？通过实现排序接口 Comparator
        //  1.构造TreeMap时,未指定排序器(即Comparator接口实现) 通过实现排序接口 Comparable
        //  2.构造TreeMap时,指定了排序器，那么 Key 值对象可以不实现接口Comparable
        //存放元素的时候,会调用Comparable 接口的 compareTo 方法, 默认升序排序
        // Comparable / Comparator 这两个接口的区别？
        // Comparable int compareTo(T o)
        // Comparable 比较的时自身和传入对象的大小
        // Comparator 接口比较的是传入的两个对象的大小
        // 当 put 添加元素或 remove 元素时，是使用比较器来进行比较两个元素是否相等,而不是使用equals
        // 优先使用构造时传入的Comparator 的 compare 方法如果未指定， 则使用 Key 值对象的 Comparable 接口的 comparaTo 方法

        map.remove(new XueHao(5));
        System.out.println(map);
        String oldValue = map.put(new XueHao(5), "五-Update");
        System.out.println(map);
        System.out.println(oldValue);

        //问：学生列表，既可以按学号正序排列,也可以反序排列
//        TreeMap treeMap2 = new TreeMap(XueHaoOrderFactory.getComparator(true));
//        treeMap2.put(new BaseXueHao(1),"第一个学视");
//        treeMap2.put(new BaseXueHao(3),"第三个学视");
//        treeMap2.put(new BaseXueHao(4),"第四个学视");
//        treeMap2.put(new BaseXueHao(2),"第二个学视");
//        System.out.println(treeMap2);
        //LinkedMap 具有和 HashMap 一样的功能
        //增强:保持元素的插入顺序
        // linkedHashMap 在 HashMap的基础上增加了如下内容
        // head指向按插入顺序，第一个元素的引用
        // tail 指向按插入顺序,最后一个元素的引用
        // 1. before 指向按插入顺序前一个元素的引用
        // 2. after 指向按插入顺序后一个元素的引用
        LinkedHashMap<XueHao,String> linkdeMap = new LinkedHashMap<>();
        linkdeMap.put(new XueHao(1),"第一个学视");
        linkdeMap.put(new XueHao(3),"第三个学视");
        linkdeMap.put(new XueHao(4),"第四个学视");
        linkdeMap.put(new XueHao(2),"第二个学视");

        //WeakHashMap 当里面的某个元素不再被使用时，可以被垃圾回收器回收
        //EnumMap
        //IdentityHashMap ，key值的哈希值计算方式://通常key值对象.hashCode();
        //IdentityHashMap ，中key值的哈希值计算方式://System.identityHashCode();
        BaseXueHao bxh = new BaseXueHao(1);
        System.out.println(bxh);
        System.out.println(bxh.hashCode());
        System.out.println(System.identityHashCode(bxh));
        int hashCode = bxh.hashCode();
        System.out.println(Integer.toHexString(hashCode));

    }

    static  class XueHaoOrderFactory{
        public static Comparator getComparator(final Boolean isAsc){
            return new Comparator() {
                @Override
                public int compare(Object one, Object two) {
                    if(one instanceof BaseXueHao && two instanceof BaseXueHao){
                        BaseXueHao o1 = (BaseXueHao) one;
                        BaseXueHao o2 = (BaseXueHao) two;
                        if(o1.index<o2.index){
                            return isAsc?-1:1;
                        }else if(o1.index==o2.index){
                            return 0;
                        }else {
                            return isAsc?1:-1;
                        }
                    }
                    return -1;
                }
            };
        }
    }

    static class BaseXueHao{
        protected Integer index; //学号

        public BaseXueHao(Integer index) {
            this.index = index;
        }

        public Integer getIndex() {
            return index;
        }

        public void setIndex(Integer index) {
            this.index = index;
        }

        @Override
        public String toString() {
            return "XueHao{" +
                    "index=" + index +
                    '}';
        }
    }

    static class XueHao extends BaseXueHao implements Comparable{

        private Integer index; //学号

        public XueHao(Integer index) {
            super(index);
            this.index = index;
        }



        @Override
        public String toString() {
            return "XueHao{" +
                    "index=" + index +
                    '}';
        }

        @Override
        public int compareTo(Object other) {
            //-1 0 1
            // 小于 other 时返回小于0的数：-1
            // 等于 ohter 时返回0
            // 大于 other 时返回大于0的数：0
            if(other instanceof XueHao){
                XueHao x = (XueHao) other;
                if(this.index<x.index){
                  return -1;
              }else if(this.index==x.index){
                    return 0;
                }else {
                    return 1;
                }
            }else {
                return -1;
            }
        }
    }
}
