package com.wywhdgg.mvc.beans;

public interface BeanFactory {
    /**
     * 获取bean
     *
     * @param beanName
     *            bean的名字
     * @return bean 实例
     * @throws Exception
     */
    Object getBean(String beanName) throws  Throwable;
    /**
     * 注册
     *
     * @param bpp
     *            bean的名字
     * @return  实例
     * @throws Exception
     */
    void registerBeanPostProcessor(BeanPostProcessor bpp);
}
