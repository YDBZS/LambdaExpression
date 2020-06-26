package com.LambdaExpression.test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 集合元素的常见操作
 * <p>TODO</p>
 *
 * @author Axel
 * @project Study
 * @since 2020/6/26 18:04
 */
public class Test {
    public static void main(String[] args) {
        //1.批量数据 -> Stream对象
        //多个数据转换得到Stream对象
        Stream stream = Stream.of("admin","tom","damu");

        //数组
        String [] strArrays = new String[] {"xueqi", "biyao"};
        Stream<String> stream1 = Arrays.stream(strArrays);

        //列表操作
        List<String> list = new ArrayList<>();
        list.add("少林");
        list.add("武当");
        list.add("青城");
        list.add("崆峒");
        list.add("峨眉");
        Stream<String> stream2 = list.stream();

        //集合操作
        Set<String> set = new HashSet<>();
        set.add("少林罗汉拳");
        set.add("武当长拳");
        set.add("青城剑法");
        Stream<String> stream3 = set.stream();

        //Map操作
        Map<String,Integer> map = new HashMap<>();
        map.put("tom",1000);
        map.put("jerry",1200);
        map.put("shuke",1000);
        Stream<Map.Entry<String, Integer>> stream4 = map.entrySet().stream();


        //2.Stream对象对于基本数据类型的功能封装
        //int / long / double
        IntStream.of(new int[] {10,20,30}).forEach(System.out::println);
        IntStream.range(1, 5).forEach(System.out::println);         //不包含开始1，包含结束5
        IntStream.rangeClosed(1,5).forEach(System.out::println);    //包含开始1，包含结束5


        //3.Stream对象 --> 转换得到指定的数据类型
        //数组
        //Object[] objx = stream.toArray(String[]::new);       //将Stream对象转换为String类型的数组                                                    <----
                                                                                                                                          //              |
        //字符串                                                                                                                                          |
        String str = stream.collect(Collectors.joining()).toString();      //join方法就是将Stream对象中的所有数据拼接，最终转换为字符串                     |
        System.out.println(str);      //在这里运行的时间报错，显示stream has already been operated upon or closed，是因为上面我们已经有了对stream的操作   -->
        //所以显示我们的Stream对象已经是关闭了，现在我们只需要将其注释掉
    }
}
