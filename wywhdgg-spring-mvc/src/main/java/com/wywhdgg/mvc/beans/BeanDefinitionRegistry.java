package com.wywhdgg.mvc.beans;

import com.wywhdgg.mvc.exception.BeanDefinitionRegistException;

/***
 *@author dzb
 *@date 2019/11/25 22:52
 *@Description: 注册接口 bean工厂
 *@version 1.0
 */
public interface BeanDefinitionRegistry {
    /**
     * 注册类bean
     *
     * @param beanName 注册名称
     **/
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) throws BeanDefinitionRegistException;

    /**
     * 获取bean信息
     *
     * @param beanName 注册名称
     **/
    BeanDefinition getBeanDefinition(String beanName);

    /**
     * ‘ 是否已经包含bean
     *
     * @param beanName 注册名称
     **/
    boolean containsBeanDefinition(String beanName);
}
