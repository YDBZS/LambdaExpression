package com.LambdaExpression.test;

/**
 * Stream常见操作API介绍
 * <p>
 *     1.聚合操作
 *
 *     2.stream的处理流程
 *          数据源
 *          数据转换
 *          执行操作获取结果
 *     3. 获取stream对象
 *          1.从集合或者数组中获取[**]
 *              1.从集合中获取
 *                  Collection.stream(),如accounts.stream()  直接获取当前用户列表的Stream对象
 *              2.获取到并行处理的Stream对象
 *                  Collection.parallelStream()     来获取一个支持并发处理的Stream对象
 *              3.如果我们的数据源是数组
 *                  Arrays.stream(T t)
 *           2.BufferReader
 *               BufferReader.lines() -> stream()     通过lines也可以获取对应的Stream对象
 *           3.通过静态工厂方法，获取到Stream对象
 *              在java.util.stream.IntStream.range()..
 *              java.nio.file.Files.walk()..
 *           4.自行构建方式获取stream对象
 *              java.util.Spliterator
 *           5.更多的方式..
 *              Random.ints()
 *              Pattern.splitAsStream()..
 *      4.中间操作API{intermediate}
 *          操作结果是一个Stream，中间操作可以有一个或者多个连续的中间操作，需要注意的是，中间操作只记录
 *              操作方式，不做具体执行，知道结束操作发生时，才做数据最终执行。
 *              中间操作：就是业务逻辑处理。
 *          中间操作过程：无状态：数据处理时，不受前置中间操作的影响，
 *                          map/filter/peek/parallel/sequential/unordered
 *                       有状态：数据处理时，受到前置中间操作的影响。
 *                          distinct/sorted/limit/skip
 *      5.终结操作|结束操作{Terminal}
 *          需要注意：一个stream对象，只能有一个Terminal(中间)操作，这个操作一旦发生，就会真实处理数据，生成对应的处理结果，并且这个过程是不可逆的
 *          终结操作：短路操作：当前的Stream对象，在处理过程中，一旦满足某个条件，就可以得到结果。
 *                          anyMatch/allMatch/nonMatch/findFirst/findAny..
 *                          Short-circuiting，对于一个无限打的Stream -> 有限大的Stream
 *                   非短路操作：当前的stream对象必须处理完集合中所有数据，才能得到处理结果
 *                         forEach/forEachOrdered/toArray/reduce/collect/min/max/count/interator
 * </p>
 *
 * @author Axel
 * @project Study
 * @since 2020/6/26 17:15
 */
public class Test {
}
