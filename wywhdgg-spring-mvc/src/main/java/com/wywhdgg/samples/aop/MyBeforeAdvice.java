package com.wywhdgg.samples.aop;

import com.wywhdgg.mvc.aop.advice.MethodBeforeAdvice;
import java.lang.reflect.Method;

/***
 * 前置增强
 * */
public class MyBeforeAdvice implements MethodBeforeAdvice {

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println(this + " 对 " + target + " 进行了前置增强！");
	}

}
