package com.wywhdgg.mvc.context;

public interface BeanDefinitionReader {

	void loadBeanDefintions(Resource resource) throws Throwable;

	void loadBeanDefintions(Resource... resource) throws Throwable;
}
