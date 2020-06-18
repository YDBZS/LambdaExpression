package com.LambdaExpression;

/**
 * 方法重载对于Lambda表达式的影响
 *
 * @author ：Axel
 * @since ：2020/6/18 16:57
 */
public class App2 {

    interface Param1{
        void outInfo(String info);
    }

    interface Param2{
        void outInfo(String info);
    }


    //定义重载的方法
    public void lambdaMethod(Param1 param){
        param.outInfo("hello param1");
    }

    public void lambdaMethod(Param2 param){
        param.outInfo("hello param2");
    }

    public static void main(String[] args) {

        /**
         * 匿名内部类对于方法重载的调用实现
         * */
        App2 app2 = new App2();
        app2.lambdaMethod(new Param1() {
            @Override
            public void outInfo(String info) {
                System.out.println(info);
            }
        });

        app2.lambdaMethod(new Param2() {
            @Override
            public void outInfo(String info) {
                System.out.println("----------------------------------佛系分割线----------------------------------------");
                System.out.println(info);
            }
        });



        /**
         * Lambda表达式对于方法重载的实现调用
         *
         * Lambda表达式存在类型检查 -> 自动推导Lambda表达式的目标类型
         * lambdaMethod() -> 方法 -> 重载方法
         *                -> Param1       函数式接口
         *                -> Param2       函数式接口
         *                调用方法 -> 传递Lambda表达式 -> 自动推导
         *                  -> Param1 | Param2
         *
         * */
        app2.lambdaMethod((String info) -> {
            System.out.println(info);
        });
    }

}
