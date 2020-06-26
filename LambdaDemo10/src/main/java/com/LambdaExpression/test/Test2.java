package com.LambdaExpression.test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Stream转换为列表List
 * <p>TODO</p>
 *
 * @author Axel
 * @project Study
 * @since 2020/6/26 18:32
 */
public class Test2 {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("GD", "Taeyang", "T.O.P");

        List<String> collect = stream.collect(Collectors.toList());

        System.out.println(collect);

    }
}
