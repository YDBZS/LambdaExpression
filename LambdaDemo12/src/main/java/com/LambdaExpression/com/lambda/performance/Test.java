package com.LambdaExpression.com.lambda.performance;

import java.util.*;

/**
 * Lambda表达式性能问题
 * <p>
 *     针对基本数据类型的操作
 * </p>
 *
 * @author 多宝
 * @since 2020/6/27 20:11
 */
public class Test {
    public static void main(String[] args) {

        Random random = new Random();

        //1.基本数据类型   整数
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            integerList.add(random.nextInt(Integer.MAX_VALUE));
        }

        //1)、stream
        testStream(integerList);
        //2)、paralleStream
        testParalleStream(integerList);
        //3)、普通for
        testForloop(integerList);
        //4)、增强型for
        testStrongForloop(integerList);
        //5)、迭代器
        testInterator(integerList);
        //2.复杂数据类型 对象

    }

    /**
     * 串行的stream操作
     *
     * @author 多宝
     * @since 2020/6/27 20:37
     * @param list 集合参数
     **/
    public static void testStream(List<Integer> list){

        long start = System.currentTimeMillis();

        Optional<Integer> max = list.stream().max(Integer::compare);
        System.out.println(max.get());

        long end = System.currentTimeMillis();

        System.out.println("testStream: " + (end - start) + "ms");
    }

    /**
     * 并行stream操作
     *
     * @author 多宝
     * @since 2020/6/27 20:27
     * @param list 集合参数
     **/
    public static void testParalleStream(List<Integer> list){

        long start = System.currentTimeMillis();

        Optional<Integer> max = list.parallelStream().max(Integer::compareTo);
        System.out.println(max.get());

        long end = System.currentTimeMillis();

        System.out.println("testParalleStream: " + (end - start) + "ms");
    }

    public static void testForloop(List<Integer> list){
        long start = System.currentTimeMillis();

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); i++) {
            int current = list.get(i);
            if (current > max){
                max = current;
            }
        }
        System.out.println(max);

        long end = System.currentTimeMillis();

        System.out.println("testForloop: " + (end - start) + "ms");
    }

    public static void testStrongForloop(List<Integer> list){
        long start = System.currentTimeMillis();

        int max = Integer.MIN_VALUE;
        for (Integer integer : list) {
            if (integer > max){
                max = integer;
            }
        }
        System.out.println(max);

        long end = System.currentTimeMillis();

        System.out.println("testStrongForloop: " + (end - start) + "ms");
    }

    public static void testInterator(List<Integer> list){
        long start = System.currentTimeMillis();

        Iterator<Integer> it = list.iterator();
        int max = it.next();
        while (it.hasNext()){
            Integer next = it.next();
            if (next > max){
                max = next;
            }
        }
        System.out.println(max);

        long end = System.currentTimeMillis();

        System.out.println("testInterator: " + (end - start) + "ms");
    }
}
