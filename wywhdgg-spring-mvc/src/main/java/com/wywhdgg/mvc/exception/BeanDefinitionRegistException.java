package com.wywhdgg.mvc.exception;

/***
 *@author dzb
 *@date 2019/11/25 23:09
 *@Description:
 *@version 1.0
 */
public class BeanDefinitionRegistException extends Exception {
    public BeanDefinitionRegistException(String mess) {
        super(mess);
    }

    public BeanDefinitionRegistException(String mess, Throwable e) {
        super(mess, e);
    }
}
