package com.wywhdgg.mvc.aop.advice;

import java.lang.reflect.Method;

/***
 *
 * 前置增强
 *@author dzb
 *@date 2019/11/27 7:01
 *@Description: before
 *@version 1.0.0
 */
public interface MethodBeforeAdvice extends Advice  {

    /**
     * 实现该方法进行前置增强
     *
     * @param method
     *            被增强的方法
     * @param args
     *            方法的参数
     * @param target
     *            被增强的目标对象
     * @throws Throwable
     */
    void before(Method method, Object[] args, Object target) throws Throwable;

}
