package com.wywhdgg.mvc.context;

import com.wywhdgg.mvc.beans.BeanDefinitionRegistry;

public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {

	protected BeanDefinitionRegistry registry;

	public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry) {
		super();
		this.registry = registry;
	}
}
