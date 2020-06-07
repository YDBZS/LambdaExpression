package com.LambdaExpression.com.Lambda;

/**
 * 消息传输格式化转换接口
 *
 * @author Axel
 * @project Study
 * @since 2020/6/7 13:59
 */
@FunctionalInterface
public interface IMessageFormat {
    /**
     * 消息转换方法
     * @author Axel
     * @since 2020/6/7 14:00
     * @params [message, format] 要转换的消息   转换的格式[xml/json...]
     * @return java.lang.String   返回转换后的数据
     */
    String format(String message,String format);

}
