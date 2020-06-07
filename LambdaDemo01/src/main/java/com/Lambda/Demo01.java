package com.Lambda;

/**
 * 这是有关于LambdaExpression的第一个测试Demo
 *
 * @author Axel
 * @project Study
 * @since 2020/6/7 13:36
 */
public class Demo01 {
    public static void main(String[] args) {
        //1.传统模式下新线程的创建
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("threading....."+Thread.currentThread().getId());
            }
        }).start();

        //2.jdk8新特性，Lambda表达式优化线程模式
        new Thread(() -> {
            System.out.println("lambda threading..." + Thread.currentThread().getId());
        }).start();
    }

}
