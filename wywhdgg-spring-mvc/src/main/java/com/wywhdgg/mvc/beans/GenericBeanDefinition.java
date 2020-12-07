package com.wywhdgg.mvc.beans;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;

/***
 *@author dzb
 *@date 2019/11/25 23:03
 *@Description:
 *@version 1.0
 */
@Data
@ToString
@EqualsAndHashCode
public class GenericBeanDefinition implements BeanDefinition {
    private Class<?> beanClass;
    private String scope = BeanDefinition.SCOPE_SINGLETION;
    /**工厂bean名称**/
    private String factoryBeanName;
    /**工厂bean方法**/
    private String factoryMethodName;
    /**工厂bean初始化方法**/
    private String initMethodName;
    /**工厂bean销毁方法**/
    private String destroyMethodName;
    /**构造方法**/
    private Constructor<?> constructor;
    /**工厂方法**/
    private Method factoryMethod;

    /**构造参数依赖定义**/
    private List<?> constructorArgumentValues;

    private List<PropertyValue> propertyValues;

    private ThreadLocal<Object[]> realConstructorArgumentValues = new ThreadLocal<>();

    @Override
    public boolean isSingleton() {
        return BeanDefinition.SCOPE_SINGLETION.equals(this.scope);
    }

    @Override
    public boolean isPrototype() {
        return BeanDefinition.SCOPE_PROTOTYPE.equals(this.scope);
    }

    public void setScope(String scope) {
        if(StringUtils.isNotBlank(scope)){
            this.scope = scope;
        }
    }

    @Override
    public Object[] getConstructorArgumentRealValues() {
        return realConstructorArgumentValues.get();
    }

    @Override
    public void setConstructorArgumentRealValues(Object[] values) {
        realConstructorArgumentValues.set(values);
    }

}
