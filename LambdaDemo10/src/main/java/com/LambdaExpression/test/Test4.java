package com.LambdaExpression.test;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Stream转换为Map
 * <p>TODO</p>
 *
 * @author Axel
 * @project Study
 * @since 2020/6/26 18:39
 */
public class Test4 {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("GD", "Taeyang", "T.O.P");

        Map<String, String> collect = stream.collect(Collectors.toMap(x -> x, y -> "value:" + y));

        System.out.println(collect);
    }
}
