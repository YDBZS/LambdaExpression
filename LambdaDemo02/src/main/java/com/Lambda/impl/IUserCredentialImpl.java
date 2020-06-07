package com.Lambda.impl;

import com.Lambda.IUserCredential;

/**
 * @author Axel
 * @project Study
 * @since 2020/6/7 14:23
 */
public class IUserCredentialImpl implements IUserCredential {
    @Override
    public String verifyUser(String userName) {
        if ("admin".equals(userName)){
            return "系统管理员";
        }else if ("manager".equals(userName)){
            return "用户管理员";
        }
        return "普通会员";
    }
}
