package com.wywhdgg.mvc.beans;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

/***
 *@author dzb
 *@date 2019/11/25 22:53
 *@Description: bean定义提供的方法
 *
 * 主要为类服务
 *@version 1.0
 */
public interface BeanDefinition {
    /**单例**/
    String SCOPE_SINGLETION = "singleton";
    /**原型**/
    String SCOPE_PROTOTYPE = "prototype";
   /**获取bean类对象**/
    Class<?> getBeanClass();
    /**类型**/
    String getScope();
    /**是否单例**/
    boolean isSingleton();
    /**是否原型**/
    boolean isPrototype();
    /**bean工厂名称**/
    String getFactoryBeanName();
    /**bean方法名称**/
    String getFactoryMethodName();
    /**初始化方法**/
    String getInitMethodName();
    /**销毁方法名**/
    String getDestroyMethodName();

    /* 下面的四个方法是供beanFactory中使用的 */
    public Constructor<?> getConstructor();

    public void setConstructor(Constructor<?> constructor);

    public Method getFactoryMethod();

    public void setFactoryMethod(Method factoryMethod);

    public Object[] getConstructorArgumentRealValues();

    public void setConstructorArgumentRealValues(Object[] values);


    /**
     * 获得构造参数定义 <br>
     * add in V2
     */
    List<?> getConstructorArgumentValues();

    /**
     * 属性依赖<br>
     * add in V2
     *
     * @return
     */
    List<PropertyValue> getPropertyValues();

    default boolean validate() {
        // 没定义class,工厂bean或工厂方法没指定，则不合法。
        if (this.getBeanClass() == null) {
            if (StringUtils.isBlank(getFactoryBeanName()) || StringUtils.isBlank(getFactoryMethodName())) {
                return false;
            }
        }
       // 定义了类，又定义工厂bean，不合法
        if (this.getBeanClass() != null && StringUtils.isNotBlank(getFactoryBeanName())) {
            return false;
        }
        return true;
    }
}
