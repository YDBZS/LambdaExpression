package com.LambdaExpression.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Stream中常见的API操作
 * <p>TODO</p>
 *
 * @author Axel
 * @project Study
 * @since 2020/6/26 18:44
 */
public class Test5 {
    public static void main(String[] args) {

        //1.Stream中常见的API操作
        List<String> accountList = new ArrayList<>();

        accountList.add("songjiang");
        accountList.add("lujunyi");
        accountList.add("wuyong");
        accountList.add("linchong");
        accountList.add("luzhishen");
        accountList.add("likui");
        accountList.add("wusong");

        //业务要求：在每个元素面前添加字符串   梁山好汉
        //map()  中间操作，map()方法接收一个Functional接口，
        //accountList = accountList.stream().map(s -> "梁山好汉：" + s).collect(Collectors.toList());

        //filter() 添加过滤条件，过滤符合条件的用户
        //accountList = accountList.stream().filter(s -> s.length() > 5).collect(Collectors.toList());

        //forEach 增强型循环
        //accountList.forEach(s -> System.out.println("forEach" + s));


        //peek()   中间操作，迭代数据完成数据的依次处理过程
        accountList.stream()
                .peek(s -> System.out.println("peek 1: " + s))
                .peek(s -> System.out.println("peek 2:" + s))
                .forEach(System.out::println);
        /**
         * peek 1: songjiang
         * peek 2:songjiang
         * songjiang
         * peek 1: lujunyi
         * peek 2:lujunyi
         * lujunyi
         * peek 1: wuyong
         * peek 2:wuyong
         * wuyong
         * peek 1: linchong
         * peek 2:linchong
         * linchong
         * peek 1: luzhishen
         * peek 2:luzhishen
         * luzhishen
         * peek 1: likui
         * peek 2:likui
         * likui
         * peek 1: wusong
         * peek 2:wusong
         * wusong
         * */

        accountList.forEach(System.out::println);
    }
}
