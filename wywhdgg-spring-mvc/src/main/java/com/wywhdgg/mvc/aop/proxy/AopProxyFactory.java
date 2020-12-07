package com.wywhdgg.mvc.aop.proxy;

import com.wywhdgg.mvc.aop.advisor.Advisor;
import com.wywhdgg.mvc.beans.BeanFactory;
import java.util.List;

public interface AopProxyFactory {

	AopProxy createAopProxy(Object bean, String beanName, List<Advisor> matchAdvisors, BeanFactory beanFactory)
			throws Throwable;

	/**
	 * 获得默认的AopProxyFactory实例
	 * 
	 * @return AopProxyFactory
	 */
	static AopProxyFactory getDefaultAopProxyFactory() {
		return new DefaultAopProxyFactory();
	}
}
