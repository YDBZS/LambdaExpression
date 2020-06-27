package com.LambdaExpression.performance;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Stream并行处理线程安全问题
 * <p>TODO</p>
 *
 * @author 多宝
 * @since 2020/6/27 21:26
 */
public class Test {
    public static void main(String[] args) {
        //整数列表
        List<Integer> list1 = new ArrayList<>();
        //增加数据
        for (int i = 0; i < 1000; i++) {
            list1.add(i);
        }

        //串行Stream
        List<Integer> list2 = new ArrayList<>();
        list1.stream().forEach(x -> list2.add(x));
        System.out.println(list1.size());
        System.out.println(list2.size());

        //并行Stream
        List<Integer> list3 = new ArrayList<>();
        list1.parallelStream().forEach(integer -> list3.add(integer));
        System.out.println(list3.size());
        //出现数据丢失，原先1000条数据，用并行Stream操作转移List元素，转移之后的list元素为986，出现线程不安全情况

        //使用Stream API提供的线程安全终端操作，来解决并行处理业务对象存在的线程不安全问题
        List<Integer> list4 = list1.parallelStream().collect(Collectors.toList());
        System.out.println(list4.size());
        //这里打印List长度为1000，没有出现线程不安全导致数据丢失的问题。

    }
}
