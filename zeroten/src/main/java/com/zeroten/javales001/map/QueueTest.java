package com.zeroten.javales001.map;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

/**
 * 文件名称： com.zeroten.javales001.map.QueueTest
 * 初始作者： Francis.Ding</br>
 * 创建日期： 2020/2/10 15:23</br>
 * 功能说明： 【】 <br/>
 * =================================================<br/>
 * 修改记录：<br/>
 * 修改作者 日期 修改内容<br/>
 * ================================================<br/>
 * Copyright (c) 2019-2020 .All rights reserved.<br/>
 */
public class QueueTest {
    //  Queue
    //      队列指的是一种在队尾插入元素,在队头删除元素
    //      两端队列,可以在队尾/队头同时进行插入或删除
    //  队列的特点: 之恶能对队头或队尾元素进行操作,而不能对队列中的元素进行操作
    //      先进先出: FIFO
    //      先进后厨:
    //  队列的两个接口: Queue、Deque
    //  队列的实现类：
    //          1.LinkedList 具有队列、两端队列的功能，内部使用的链表来实现
    //          2.ArrayDeque 具有队列、两端队列的功能，内部使用循环数组来实现
    //          3.PriorityQueue 优先级队列，它内部实现结构可以快速把所有元素中最小的元素单独放出来
    //            最典型的应用场景：任务调度
    //  两个应用场景:任务调度、LRU
    //  两个工具:Arrays、Collections

    public static void main(String[] args) {
        //队列
        // testQueueOp();

        // 两端队列 Deque
        // testDequeOp();

        // 优先级队列:任务调度
        // 特点：内部使用了一种堆的数据结构，是自我调整的二叉树
        //       当向队列中添加/删除元素的时候,它能快速的找到队列中最小的元素
        //       并且移动到树的跟部，而不用对所有元素进行p排序
        // 对优先级队列进行遍历的时候，无序
        PriorityQueue<String> pq  = new PriorityQueue();
        pq.add("1");
        pq.add("3");
        pq.add("5");
        pq.add("7");
        pq.add("2");
        pq.add("4");
        pq.add("8");
        pq.add("6");
        //数组或者实现了 Iterable 接口的类可以用于 for each语法
        for (String str :pq) {
            System.out.println(">"+str);
        }
        System.out.println("get");
        //remove 删除并返回队列中最小的元素
        // 如果队列为空则抛 NoSuchElementException 异常
        // remove
        System.out.println(pq.remove());
        // TreeMap
        // 构建TreeMap时, 指定 Comparator
        // 未指定 Comparator 时, key值对象必须实现 Comparable接口
        // Comparable 和 Comparator 区别？？？
        // Comparable 比较自身和另一对象,comparato
        // Comparator 比较的是传入的两个对象，compare
        //TreeMap

        // 优先级队列如何找到最小元素：构建是指定 Comparator
        // 或者存放元素是西安 Comparable 接口
        PriorityQueue<Task> taskList = new PriorityQueue<Task>(new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                if(o1.priority<o2.priority){
                    return -1;
                } else if(o1.priority==o2.priority){
                    return 0;
                } else {
                    return 1;
                }

            }
        });
        for (int i =0;i<10;i++){
            int priority = new Random().nextInt(10);
        }

    }

    static class Task{
        private int priority;
        private String name;

        public Task(int priority, String name) {
            this.priority = priority;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Task{" +
                    "priority=" + priority +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    private static  void testQueueOp(){
        // 队列
        // Queue 接口的方法
        Queue<String> queue = new LinkedList<>();
        // 增删查改
        //增
        // add(E)/offer(E)
        // 在队列未满的情况下,添加元素导队列的尾部。
        // 如果队列已满: add抛异常 IllegalStateException
        //              offer 返回 false
        queue.add("str1");
        queue.add("str3");
        queue.offer("str2");
        queue.offer("str4");
        // 删
        // remove/poll
        // 如果队列不为空，删除并返回队头的元素
        // 如果队列为空: remove 抛异常 NoSuchElementException
        //              poll 返回 null
        // 如果使用 remove 来获取队尾元素时,remove前要判断是否未空
        //      size() ==0 或 isEmpty();
        // 如果使用 poll 来获取队尾元素时,获取到结果后,先判断结果是否未null
        queue.remove();
        System.out.println("remove:"+queue);
        queue.remove();
        System.out.println("remove:"+queue);
        queue.remove();
        System.out.println("remove:"+queue);
        queue.remove();
        System.out.println("remove:"+queue);

        // 查,仅查看队头元素时什么,不删除
        // element/peek
        // 如果队列不为空,返回队列的头部元素,但不删除
        // 队列为空时: element 抛异常 NoSuchElementException
        //              peek 返回 null
        System.out.println(queue);
        System.out.println("队头元素peek："+queue.peek());
        System.out.println("队头元素element："+queue.element());
        // 改，一半没有修改操作

    }
    private static  void testDequeOp(){
        //两端队列 Deque:增删查改
        Deque<String> deque = new LinkedList<>();
        //增：(add/offer)
        //  addFirst/addLast/offerFirst/offerLast
        // 队列不为空时, 在队头或队尾添加元素
        // 如果队列为空: addFirst/addLast抛异常 IllegalStateException
        //              offerFirst/offerLast返回 false
        deque.addLast("Str1");
        deque.offerLast("Str3");
        deque.addFirst("Str2");
        deque.offerFirst("Str4");

        //删：(remove/poll)
        //  removeFirst/removeLast/pollFirst/pollLast
        // 如果队列不为空，删除并返回队头或队尾的元素
        // 如果队列为空: removeFirst/removeLast 抛异常 NoSuchElementException
        //              pollFirst/pollLast 返回 null
        deque.removeLast();
        deque.pollLast();
        deque.removeFirst();
        deque.pollFirst();
        //查：(element/peek)
        //  getFirst/getLast/peekFirst/peekLast
        // 如果队列不为空,返回队头或队尾元素,但不删除
        // 队列为空时: getFirst/getLast 抛异常 NoSuchElementException
        //              peekFirst/peekLast 返回 null
        System.out.println(deque.getFirst());
        System.out.println(deque.getLast());
        System.out.println(deque.peekFirst());
        System.out.println(deque.peekLast());
    }

}
