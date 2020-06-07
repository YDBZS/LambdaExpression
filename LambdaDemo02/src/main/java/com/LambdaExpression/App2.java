package com.LambdaExpression;

import java.util.UUID;
import java.util.function.*;

/**
 * PredicateDemo   ComsumerDemo
 *
 * @author Axel
 * @project Study
 * @since 2020/6/7 15:15
 */
public class App2 {
    public static void main(String[] args) {
        /**
         * 接收参数对象T，返回一个boolean类型结果
         * */
        //查看Predicate源码，他其实就是一个函数式接口，里面有一个test方法
        Predicate<String> pre = (String username) -> {
            return "admin".equals(username);
        };

        System.out.println(pre.test("admin"));     //true
        System.out.println(pre.test("manager"));   //false


        /**
         * 接收参数对象T，不返回结果
         * */
        //我们在进行调用的时间，我们需要看他的接口方法
        //查看Consumer源码，他是一个函数式接口
        Consumer<String> con = (String message) -> {
            //模拟消息的发送
            System.out.println("要发送的消息：" + message);
            System.out.println("消息发送完成");
        };
        con.accept("Hello World");
        con.accept("imooc lambda expression.");



        /**
         * 接收参数对象T，返回结果对象R
         * */
        //在这里我们查看function的源代码，他也是一个函数式接口，
        Function<String,Integer> fun = (String gender) -> {
              return "male".equals(gender)?1:0;
        };

        System.out.println(fun.apply("male"));      //1
        System.out.println(fun.apply("female"));    //0

        /**
         * 不接受参数，提供T对象的创建工厂
         * */
        //在这里我们查看Supplier的源代码，首先他是一个函数式接口，里面时提供了一个get方法
        Supplier<String> sup = () -> {
          return UUID.randomUUID().toString();
        };
        System.out.println(sup.get());
        System.out.println(sup.get());
        System.out.println(sup.get());

        /**
         * 在这里我们模拟前端接收前端图片参数
         * */
        UnaryOperator<String> uo = (String img) -> {
          img += "[100*200]";
          return img;
        };

        System.out.println(uo.apply("原图--"));

        /**
         * 在这里我们模拟
         * */
        BinaryOperator<Integer> bo = (Integer i1,Integer i2) -> {
            return i1 > i2 ? i1 : i2;
        };
        System.out.println(bo.apply(12, 13));

    }

    /**
     * 在项目开发的过程中，java提供了一个java.util.function的包。
     * 在这个包里面提供了大量的函数式接口
     * 这些函数式接口分别适用于不同的项目场景
     * Pridicate 接收一个参数T对象，返回一个boolean类型的数据。
     * Consumer 接收参数T对象，没有返回值
     * Function 接收参数T对象，返回一个R对象
     * Supplier 工厂接口，不接受任何参数，直接通过Get获得指定类型的对象
     * UnaryOperator 接收参数T对象，执行业务处理后，返回更新后的T对象
     * BinaryOperator 接口接收两个T对象，执行业务处理后，返回一个T对象
     *
     * */


}
