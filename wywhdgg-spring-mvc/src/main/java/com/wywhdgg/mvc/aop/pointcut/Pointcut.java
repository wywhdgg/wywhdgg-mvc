package com.wywhdgg.mvc.aop.pointcut;

import java.lang.reflect.Method;

/***
 *
 * 切入点
 *
 *@author dzb
 *@date 2019/11/27 7:18
 *@Description:
 *@version 1.0.0
 */
public interface Pointcut {

    boolean matchsClass(Class<?> targetClass);

    boolean matchsMethod(Method method, Class<?> targetClass);

}
