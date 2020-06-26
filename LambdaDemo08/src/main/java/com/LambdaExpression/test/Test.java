package com.LambdaExpression.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Stream操作测试
 * <p>TODO</p>
 *
 * @author Axel
 * @project Study
 * @since 2020/6/26 16:58
 */
public class Test {
    public static void main(String[] args) {
        //1. 添加测试数据：存储多个账号的列表
        List<String> accounts = new ArrayList<>();
        accounts.add("tom");
        accounts.add("jerry");
        accounts.add("beita");
        accounts.add("shuke");
        accounts.add("damu");

        //1.1 业务要求：长度大于等于5的有效账号
        for (String account : accounts) {
            if (account.length() >= 5){
                System.out.println("有效账号" + account);
            }
        }

        //1.2 迭代方式进行操作
        Iterator<String> it = accounts.iterator();
        while (it.hasNext()){
            String next = it.next();
            if (next.length() >= 5){
                System.out.println("it有效账号" + next);
            }
        }


        //1.3Stream结合lambda表达式，完成业务处理
        List validAccount = accounts.stream().filter(s -> s.length()>=5).collect(Collectors.toList());
        System.out.println(validAccount);


    }
}
