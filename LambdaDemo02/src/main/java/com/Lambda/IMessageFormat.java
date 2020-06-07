package com.Lambda;

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

    /**
     * 通过静态方法进行处理当前消息是否合格
     * @author Axel
     * @since 2020/6/7 14:41
     * @param message  要进行验证的消息
     * @return boolean 返回验证结果
     */
    static boolean verifyMessage(String message){
        if (message != null){
            return true;
        }
        return false;
    }

    //如果我们在这里定义一个自己的一个抽象方法，函数式接口语法语义验证就不会通过
    //boolean test();

    //但是我们这里写一个从Object类继承过来的抽象方法，函数式接口的语法语义就会验证通过
    String toString();

}
