package com.LambdaExpression;

import com.Lambda.IMessageFormat;
import com.Lambda.IUserCredential;
import com.Lambda.impl.IMessageFormatImpl;
import com.Lambda.impl.IUserCredentialImpl;

/**
 * Hello world!
 *
 *    需求改动：
 *        所有的用户验证，可以同时获取用户的验证信息[是否验证成功\成功~返回用户\null]
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        IUserCredential ic = new IUserCredentialImpl();

        System.out.println(ic.verifyUser("admin"));

        System.out.println(ic.getCredentail("admin"));


        String msg = "Hello World";

        //首先验证Message合法性，如果验证通过，我们进行发送处理，如果验证不通过，我们不做发送处理
        if (IMessageFormat.verifyMessage(msg)) {
            IMessageFormat imf = new IMessageFormatImpl();

            imf.format(msg, "json");
        }


        //匿名内部类，实现接口的抽象方法
        IUserCredential ic2 = new IUserCredentialImpl(){
            @Override
            public String verifyUser(String userName) {
                return "admin".equals(userName)?"管理员":"会员";
            }
        };

        System.out.println(ic2.verifyUser("manager"));
        System.out.println(ic2.verifyUser("admin"));


        //Lambda表达式，针对函数式接口的简单实现
        IUserCredential ic3 = (String username) -> {
            return "admin".equals(username)?"lambda表达式(管理员)":"lambda表达式(会员)";
        };

        System.out.println(ic3.verifyUser("admin"));
        System.out.println(ic3.verifyUser("manager"));

    }
}
