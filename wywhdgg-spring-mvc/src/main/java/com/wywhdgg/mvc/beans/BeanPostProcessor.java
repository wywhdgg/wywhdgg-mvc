package com.wywhdgg.mvc.beans;

/**
 * bean初始化 before ,after
 *
 * **/
public interface BeanPostProcessor {

	/***bean初始化之前*/
	default Object postProcessBeforeInitialization(Object bean, String beanName) throws Throwable {
		return bean;
	}

	/**bean初始化之后**/
	default Object postProcessAfterInitialization(Object bean, String beanName) throws Throwable {
		return bean;
	}
}
