package com.wywhdgg.mvc.aop.proxy;

import com.wywhdgg.mvc.aop.advisor.Advisor;
import com.wywhdgg.mvc.beans.BeanFactory;
import com.wywhdgg.mvc.utils.AopProxyUtils;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

@Slf4j
public class JdkDynamicAopProxy implements AopProxy, InvocationHandler {

	private String beanName;
	private Object target;
	private List<Advisor> matchAdvisors;

	private BeanFactory beanFactory;

	public JdkDynamicAopProxy(String beanName, Object target, List<Advisor> matchAdvisors, BeanFactory beanFactory) {
		super();
		this.beanName = beanName;
		this.target = target;
		this.matchAdvisors = matchAdvisors;
		this.beanFactory = beanFactory;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		return AopProxyUtils.applyAdvices(target, method, args, matchAdvisors, proxy, beanFactory);
	}

	@Override
	public Object getProxy() {
		return this.getProxy(target.getClass().getClassLoader());
	}

	@Override
	public Object getProxy(ClassLoader classLoader) {
		if (log.isDebugEnabled()) {
			log.debug("为" + target + "创建代理。");
		}
		return Proxy.newProxyInstance(classLoader, target.getClass().getInterfaces(), this);
	}

}
