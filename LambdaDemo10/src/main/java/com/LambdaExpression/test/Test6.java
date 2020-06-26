package com.LambdaExpression.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Stream中对于数字运算的支持
 * <p>TODO</p>
 *
 * @author Axel
 * @project Study
 * @since 2020/6/26 19:03
 */
public class Test6 {
    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>();
        intList.add(20);
        intList.add(19);
        intList.add(7);
        intList.add(8);
        intList.add(86);
        intList.add(11);
        intList.add(3);
        intList.add(20);

        //skip() 中间操作，有状态操作，跳过部分数据
        //intList.stream().skip(3).forEach(System.out::println);

        //limit()  中间操作，有状态操作，限制输出数据量
        //intList.stream().skip(3).limit(2).forEach(System.out::println);

        //distinct()   中间操作，有状态操作，剔除重复的数据
        //intList.stream().distinct().forEach(System.out::println);


        //sorted()   中间操作，有状态操作，排序
        //intList.stream().sorted().forEach(System.out::println);

        //max()  中间操作，有状态操作，获取最大值的
//        Optional<Integer> max = intList.stream().max((o1, o2) -> o1 - o2);
//        System.out.println(max.get());

        //min()   中间操作，有状态操作，获取最小值
//        Optional<Integer> min = intList.stream().min((o1, o2) -> o1 - o2);
//        System.out.println(min.get());


        //reduce()   中间操作，有状态操作，合并处理数据
        Optional<Integer> reduce = intList.stream().reduce((sum, integer2) -> sum + integer2);
        System.out.println(reduce.get());


    }
}
