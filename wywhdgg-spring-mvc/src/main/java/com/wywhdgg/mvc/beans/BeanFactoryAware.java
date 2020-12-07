package com.wywhdgg.mvc.beans;

/***
 * beanFactory 注册
 * */
public interface BeanFactoryAware extends Aware {

	void setBeanFactory(BeanFactory bf);
}
