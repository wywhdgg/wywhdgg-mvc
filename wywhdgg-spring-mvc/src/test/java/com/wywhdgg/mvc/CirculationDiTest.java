package com.wywhdgg.mvc;

import com.wywhdgg.mvc.beans.BeanReference;
import com.wywhdgg.mvc.beans.GenericBeanDefinition;
import com.wywhdgg.mvc.beans.PreBuildBeanFactory;
import com.wywhdgg.samples.DBean;
import com.wywhdgg.samples.EBean;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/***测试循环依赖*/
public class CirculationDiTest {

	static PreBuildBeanFactory bf = new PreBuildBeanFactory();

	@Test
	public void testCirculationDI() throws Throwable {
		GenericBeanDefinition bd = new GenericBeanDefinition();
		bd.setBeanClass(DBean.class);
		List<Object> args = new ArrayList<>();
		args.add(new BeanReference("ebean"));
		bd.setConstructorArgumentValues(args);
		bf.registerBeanDefinition("dbean", bd);

		bd = new GenericBeanDefinition();
		bd.setBeanClass(EBean.class);
		args = new ArrayList<>();
		args.add(new BeanReference("dbean"));
		bd.setConstructorArgumentValues(args);
		bf.registerBeanDefinition("ebean", bd);

		bf.preInstantiateSingletons();
	}
}
