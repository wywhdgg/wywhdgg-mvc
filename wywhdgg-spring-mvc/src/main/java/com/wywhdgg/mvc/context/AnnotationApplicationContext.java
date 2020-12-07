package com.wywhdgg.mvc.context;

import com.wywhdgg.mvc.beans.BeanDefinitionRegistry;
import java.io.IOException;



public class AnnotationApplicationContext extends AbstractApplicationContext {

	private ClassPathBeanDefinitionScanner scanner;

	public AnnotationApplicationContext(String... basePackages) throws Throwable {
		scanner = new ClassPathBeanDefinitionScanner((BeanDefinitionRegistry) this.beanFactory);
		scanner.scan(basePackages);
	}

	@Override
	public Resource getResource(String location) throws IOException {
		return null;
	}

}
