package com.wywhdgg.mvc.aop;

import com.wywhdgg.mvc.aop.advisor.Advisor;
import com.wywhdgg.mvc.aop.advisor.AdvisorRegistry;
import com.wywhdgg.mvc.aop.advisor.PointcutAdvisor;
import com.wywhdgg.mvc.aop.pointcut.Pointcut;
import com.wywhdgg.mvc.aop.proxy.AopProxyFactory;
import com.wywhdgg.mvc.beans.BeanFactory;
import com.wywhdgg.mvc.beans.BeanFactoryAware;
import com.wywhdgg.mvc.beans.BeanPostProcessor;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.util.ClassUtils;
import org.springframework.util.ReflectionUtils;

/***
 * AOP增强处理的观察者
 * （观察者模式/监听模式）
 * @author dzb
 * @date 2019/11/27 7:58
 * @Description:
 * @version 1.0.0
 * */
public class AdvisorAutoProxyCreator implements AdvisorRegistry, BeanPostProcessor, BeanFactoryAware {
    /**
     * 增强的类
     **/
    private List<Advisor> advisors;
    /**
     * 注册bean工厂
     **/
    private BeanFactory beanFactory;

    public AdvisorAutoProxyCreator() {
        this.advisors = new ArrayList<>();
    }

    @Override
    public void registAdvisor(Advisor ad) {
        this.advisors.add(ad);
    }

    @Override
    public List<Advisor> getAdvisors() {
        return advisors;
    }

    @Override
    public void setBeanFactory(BeanFactory bf) {
        this.beanFactory = bf;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws Throwable {
        // 在此判断bean是否需要进行切面增强
        List<Advisor> matchAdvisors = getMatchedAdvisors(bean, beanName);
        // 如需要就进行增强,再返回增强的对象。
        if (CollectionUtils.isNotEmpty(matchAdvisors)) {
            bean = this.createProxy(bean, beanName, matchAdvisors);
        }
        return bean;
    }

    private List<Advisor> getMatchedAdvisors(Object bean, String beanName) {
        if (CollectionUtils.isEmpty(advisors)) {
            return null;
        }

        // 得到类、所有的方法
        Class<?> beanClass = bean.getClass();
        //增强的方式
        List<Method> allMethods = this.getAllMethodForClass(beanClass);

        // 存放匹配的Advisor的list
        List<Advisor> matchAdvisors = new ArrayList<>();
        // 遍历Advisor来找匹配的
        for (Advisor ad : this.advisors) {
            if (ad instanceof PointcutAdvisor) {
                if (isPointcutMatchBean((PointcutAdvisor) ad, beanClass, allMethods)) {
                    matchAdvisors.add(ad);
                }
            }
        }
        return matchAdvisors;
    }

    private List<Method> getAllMethodForClass(Class<?> beanClass) {
        List<Method> allMethods = new LinkedList<>();
        Set<Class<?>> classes = new LinkedHashSet<>(ClassUtils.getAllInterfacesForClassAsSet(beanClass));
        classes.add(beanClass);
        for (Class<?> clazz : classes) {
            Method[] methods = ReflectionUtils.getAllDeclaredMethods(clazz);
            for (Method m : methods) {
                allMethods.add(m);
            }
        }
        return allMethods;
    }

    private boolean isPointcutMatchBean(PointcutAdvisor pa, Class<?> beanClass, List<Method> methods) {
        Pointcut p = pa.getPointcut();

        // 首先判断类是否匹配
        if (!p.matchsClass(beanClass)) {
            return false;
        }

        // 再判断是否有方法匹配
        for (Method method : methods) {
            if (p.matchsMethod(method, beanClass)) {
                return true;
            }
        }
        return false;
    }

    private Object createProxy(Object bean, String beanName, List<Advisor> matchAdvisors) throws Throwable {
        // 通过AopProxyFactory工厂去完成选择、和创建代理对象的工作。
        return AopProxyFactory.getDefaultAopProxyFactory().createAopProxy(bean, beanName, matchAdvisors, beanFactory).getProxy();
    }
}
