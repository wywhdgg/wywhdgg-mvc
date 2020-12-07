package com.wywhdgg.samples.aop;

import com.wywhdgg.mvc.aop.advice.AfterReturningAdvice;
import java.lang.reflect.Method;

/**
 * 如何区分是增强的bean，就过滤掉
 * 后置增强
 * **/
public class MyAfterReturningAdvice implements AfterReturningAdvice {

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		System.out.println(this + " 对 " + target + " 做了后置增强，得到的返回值=" + returnValue);
	}

}
