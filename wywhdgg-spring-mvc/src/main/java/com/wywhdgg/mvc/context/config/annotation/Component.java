package com.wywhdgg.mvc.context.config.annotation;

import com.wywhdgg.mvc.beans.BeanDefinition;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Component {

	String value() default "";

	String name() default "";

	String scope() default BeanDefinition.SCOPE_SINGLETION;

	String factoryMethodName() default "";

	String factoryBeanName() default "";

	String initMethodName() default "";

	String destroyMethodName() default "";
}
