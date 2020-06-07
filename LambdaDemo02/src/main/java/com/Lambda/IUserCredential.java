package com.Lambda;

/**
 * 函数式接口传统模式及Lambda优化
 *
 * @author Axel
 * @project Study
 * @since 2020/6/7 13:51
 */

/**
 * 用户身份认证标记接口
 */
@FunctionalInterface
public interface IUserCredential {
    /**
     * 通过用户账号，验证用户身份信息接口
     * @author Axel
     * @since 2020/6/7 13:54
     * @param userName  验验证的用户账号
     * @return java.lang.String  返回身份信息[系统管理员、用户管理员、普通用户]
     */
    String verifyUser(String userName);


    /**
     * 模拟方法(默认方法) 通过默认方法可以使当前接口的所有子类添加公用方法
     * @author Axel
     * @since 2020/6/7 14:30
     * @params [username]
     * @return java.lang.String
     */
    default String getCredentail(String username){
        if ("admin".equals(username)){
            return "admin + 系统管理员用户";
        }else if ("manager".equals(username)){
            return "manager + 用户管理员用户";
        }else {
            return "commen + 普通管理员用户";
        }
    }
}
