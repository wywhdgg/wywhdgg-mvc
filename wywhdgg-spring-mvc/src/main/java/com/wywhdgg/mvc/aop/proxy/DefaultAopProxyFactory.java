package com.wywhdgg.mvc.aop.proxy;

import com.wywhdgg.mvc.aop.advisor.Advisor;
import com.wywhdgg.mvc.beans.BeanFactory;
import java.lang.reflect.Proxy;
import java.util.List;
/***
 *
 *
 * 默认jdk代理
 *
 *@author dzb
 *@date 2019/11/27 7:58
 *@Description:
 *@version 1.0.0
 */
public class DefaultAopProxyFactory implements AopProxyFactory {
    @Override
    public AopProxy createAopProxy(Object bean, String beanName, List<Advisor> matchAdvisors, BeanFactory beanFactory) throws Throwable {
        // 是该用jdk动态代理还是cglib？
        if (shouldUseJDKDynamicProxy(bean, beanName)) {
            return new JdkDynamicAopProxy(beanName, bean, matchAdvisors, beanFactory);
        } else {
            return new CglibDynamicAopProxy(beanName, bean, matchAdvisors, beanFactory);
        }
    }

    private boolean shouldUseJDKDynamicProxy(Object bean, String beanName) {
        if (bean.getClass().isInterface()||Proxy.isProxyClass(bean.getClass())) {
            return true;
        }

        return false;
    }
}
