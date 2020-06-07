package com.LambdaExpression.com.Lambda;

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
}
