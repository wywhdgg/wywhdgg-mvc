package com.wywhdgg.mvc.aop.advice;

import java.lang.reflect.Method;

/***
 *@author dzb
 *@date 2019/11/27 7:01
 *@Description:
 *@version 1.0.0
 */
public interface MethodInterceptor extends Advice {
    /**
     * 对方法进行环绕（前置、后置）增强、异常处理增强，方法实现中需调用目标方法。
     *
     * @param method
     *            被增强的方法
     * @param args
     *            方法的参数
     * @param target
     *            方法所属对象
     * @return Object 返回值
     * @throws Throwable
     */
    Object invoke(Method method, Object[] args, Object target) throws Throwable;

}
