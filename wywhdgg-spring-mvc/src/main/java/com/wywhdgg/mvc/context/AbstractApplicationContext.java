package com.wywhdgg.mvc.context;

import com.wywhdgg.mvc.beans.BeanFactory;
import com.wywhdgg.mvc.beans.BeanPostProcessor;
import com.wywhdgg.mvc.beans.PreBuildBeanFactory;

public abstract class AbstractApplicationContext implements ApplicationContext {

	protected BeanFactory beanFactory;

	public AbstractApplicationContext() {
		super();
		this.beanFactory = new PreBuildBeanFactory();
	}

	@Override
	public Object getBean(String name) throws Throwable {
		return beanFactory.getBean(name);
	}

	@Override
	public void registerBeanPostProcessor(BeanPostProcessor bpp) {
		this.beanFactory.registerBeanPostProcessor(bpp);
	}

}
