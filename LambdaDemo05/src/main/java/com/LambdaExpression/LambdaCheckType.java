package com.LambdaExpression;

import java.util.ArrayList;
import java.util.List;

/**
 * Lambda表达式类型检查
 *
 * @author ：Axel
 * @since ：2020/6/18 16:36
 */
public class LambdaCheckType {

    public static void test(MyInterface<String, List> inner){
        List<String> list = inner.strategy("hello", new ArrayList());
        System.out.println(list);

    }

    public static void main(String[] args) {
        test(new MyInterface<String, List>() {
            @Override
            public List strategy(String s, List list) {
                list.add(s);
                return list;
            }
        });

        test((x, y) -> {
            y.add(x);
            return y;
//            x.add(y);
//            return x;

        });

        /**
         * 表达式类型检查
         *
         * (x,y) -> {..} --> test(param) --> param==MyInterface --> lambda表达式 -> MyInterface类型
         * 这个就是对于lambda表达式的类型检查，MyInterface接口是lambda表达式的目标类型(target typing)
         *
         *
         * 参数类型检查
         * (x,y) -> {..} --> MyInterface.strategy(T t,R r) --> MyInterface<String, List> inner
         * --> T==String R==List --> lambda --> (x,y) == strategy(T t,R r) --> x==T==String    y==R==List
         * lambda表达式参数的类型检查
         *
         * */

    }
}

@FunctionalInterface
interface MyInterface<T,R>{
    R strategy(T t, R r);
}
