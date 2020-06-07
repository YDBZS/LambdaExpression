package com.Lambda.impl;

import com.Lambda.IMessageFormat;

/**
 * @author Axel
 * @project Study
 * @since 2020/6/7 14:43
 */
public class IMessageFormatImpl implements IMessageFormat {
    @Override
    public String format(String message, String format) {
        System.out.println("消息转换。。。");
        return message;
    }
}
