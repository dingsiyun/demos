package com.zeroten.javales001.IO.entity;

import java.io.Serializable;

/**
 * 文件名称： com.zeroten.javales001.IO.entity.Person
 * 初始作者： Francis.Ding</br>
 * 创建日期： 2020/2/13 21:42</br>
 * 功能说明： 【】 <br/>
 * =================================================<br/>
 * 修改记录：<br/>
 * 修改作者 日期 修改内容<br/>
 * ================================================<br/>
 * Copyright (c) 2019-2020 .All rights reserved.<br/>
 */
public class Person implements Serializable {

    /**
     * 保证数据一致性
     */
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String name;

    private Integer age;

    public Person() {
    }

    public Person(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public static Person valueOf(Object o){
        return (Person)o;
    }
}
