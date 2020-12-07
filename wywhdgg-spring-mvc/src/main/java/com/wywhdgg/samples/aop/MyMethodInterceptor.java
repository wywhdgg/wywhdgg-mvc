package com.wywhdgg.samples.aop;

import com.wywhdgg.mvc.aop.advice.MethodInterceptor;
import java.lang.reflect.Method;

/**
 * 方法增强
 * **/
public class MyMethodInterceptor implements MethodInterceptor {

	@Override
	public Object invoke(Method method, Object[] args, Object target) throws Throwable {
		System.out.println(this + "对 " + target + "进行了环绕--前增强");
		Object ret = method.invoke(target, args);
		System.out.println(this + "对 " + target + "进行了环绕 --后增强。方法的返回值为：" + ret);
		return ret;
	}

}
