package com.LambdaExpression;

/**
 * 匿名内部类变量访问
 *
 * @author ：Axel
 * @since ：2020/6/18 16:12
 */
public class App2 {
    String s1 = "全局变量";

    //1.匿名内部类型中对于变量的访问
    public void testInnerClass(){
        String s2 = "局部变量";
        new Thread(new Runnable() {
            String s3 = "内部变量";
            @Override
            public void run() {
                //访问全局变量
                //System.out.println(this.s1);  //this关键字表示的是当前匿名内部类型的对象
                System.out.println(s1);

                System.out.println(s2);   //局部变量的访问  不能对局部变量进行数据的修改[final]

                //s2 = "Hello";

                System.out.println(s3);
                System.out.println(this.s3);
            }
        }).start();
    }


    //2.lambda表达式变量捕获
    public void testLambda(){
        String s2 = "局部变量Lambda";
        new Thread(() -> {
            String s3 = "内部变量Lambda";

            //访问全局变量
            System.out.println(this.s1);     //this关键字，表示的就是所属方法所在类型的对象

            System.out.println(s2);
            //s2 = "hello";       //不能进行数据的修改，默认推导标量的修饰符为：final

            System.out.println(s3);
            s3 = "lambda  内部变量直接修改";
            System.out.println(s3);
        }).start();
    }



    public static void main(String[] args) {
        App2 app2 = new App2();
        //app2.testInnerClass();
        app2.testLambda();
    }

}
