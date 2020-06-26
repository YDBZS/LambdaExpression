package com.LambdaExpression.test;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Stream转换为集合
 * <p>TODO</p>
 *
 * @author Axel
 * @project Study
 * @since 2020/6/26 18:38
 */
public class Test3 {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("GD", "Taeyang", "T.O.P");

        Set<String> collect = stream.collect(Collectors.toSet());

        System.out.println(collect);
    }
}
