package com.LambdaExpression.com.lambda.performance;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;

/**
 * Lambda表达式性能问题
 * <p>
 *     针对对象的操作
 * </p>
 *
 * @author 多宝
 * @since 2020/6/27 20:39
 */
public class Test2 {
    public static void main(String[] args) {

        Random random = new Random();

        List<Product> productList = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            productList.add(new Product("pro" + i, i, random.nextInt(Integer.MAX_VALUE)));
        }

        testProductStream(productList);

        testProductParalleStream(productList);

        testProductForloop(productList);

        testProductStrongForloop(productList);

        testProductIterator(productList);
    }

    /**
     * 串行的stream操作
     *
     * @author 多宝
     * @since 2020/6/27 20:58
     * @param list  对象集合
     **/
    public static void testProductStream(List<Product> list){
        long start = System.currentTimeMillis();

        Optional<Product> max = list.stream().max((o1, o2) -> o1.getHot() - o2.getHot());
        System.out.println(max.get());

        long end = System.currentTimeMillis();
        System.out.println("testProductStream: " + (end - start) + "ms");
    }

    /**
     * 并行的Stream操作
     *
     * @author 多宝
     * @since 2020/6/27 20:59
     * @param list 集合对象
     **/
    public static void testProductParalleStream(List<Product> list){
        long start = System.currentTimeMillis();

        Optional<Product> max = list.stream().max((o1, o2) -> o1.getHot() - o2.getHot());
        System.out.println(max.get());

        long end = System.currentTimeMillis();
        System.out.println("testProductParalleStream: " + (end - start) + "ms");
    }

    public static void testProductForloop(List<Product> list){
        long start = System.currentTimeMillis();

        Product mavHot = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            Product current = list.get(i);
            if (current.getHot() > mavHot.getHot()){
                mavHot = current;
            }
        }
        System.out.println(mavHot);

        long end = System.currentTimeMillis();
        System.out.println("testProductForloop: " + (end - start) + "ms");
    }

    public static void testProductStrongForloop(List<Product> list){
        long start = System.currentTimeMillis();

        Product maxHot = list.get(0);
        for (Product product : list) {
            if (product.getHot() > maxHot.getHot()){
                product = maxHot;
            }
        }
        System.out.println(maxHot);

        long end = System.currentTimeMillis();
        System.out.println("testProductStrongForloop: " + (end - start) + "ms");
    }

    public static void testProductIterator(List<Product> list){
        long start = System.currentTimeMillis();

        Iterator<Product> it = list.iterator();
        Product maxHot = it.next();
        while (it.hasNext()){
            Product current = it.next();
            if (current.getHot() > maxHot.getHot()){
                current = maxHot;
            }
        }
        System.out.println(maxHot);

        long end = System.currentTimeMillis();
        System.out.println("testProductIterator: " + (end - start) + "ms");
    }


}

@Data
@AllArgsConstructor
class Product{
    /**
     * 名称
     * */
    private String name;

    /**
     * 库存
     * */
    private Integer stock;

    /**
     * 热度
     * */
    private Integer hot;
}

