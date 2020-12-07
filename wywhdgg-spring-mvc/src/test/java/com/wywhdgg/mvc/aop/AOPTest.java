package com.wywhdgg.mvc.aop;

import com.alibaba.fastjson.JSON;
import com.wywhdgg.mvc.aop.advisor.AspectJPointcutAdvisor;
import com.wywhdgg.mvc.beans.BeanReference;
import com.wywhdgg.mvc.beans.GenericBeanDefinition;
import com.wywhdgg.mvc.beans.PreBuildBeanFactory;
import com.wywhdgg.samples.ABean;
import com.wywhdgg.samples.CBean;
import com.wywhdgg.samples.aop.MyAfterReturningAdvice;
import com.wywhdgg.samples.aop.MyBeforeAdvice;
import com.wywhdgg.samples.aop.MyMethodInterceptor;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/***
 *@author dzb
 *@date 2019/11/27 7:26
 *@Description:
 *@version 1.0.0
 */
public class AOPTest {
        static PreBuildBeanFactory bf = new PreBuildBeanFactory();

        @Test
        public void testCirculationDI() throws Throwable {

            GenericBeanDefinition bd = new GenericBeanDefinition();
            bd.setBeanClass(ABean.class);
            List<Object> args = new ArrayList<>();
            args.add("abean01");
            args.add(new BeanReference("cbean"));
            bd.setConstructorArgumentValues(args);
            bf.registerBeanDefinition("abean", bd);


            bd = new GenericBeanDefinition();
            bd.setBeanClass(CBean.class);
            args = new ArrayList<>();
            args.add("cbean01");
            bd.setConstructorArgumentValues(args);
            bf.registerBeanDefinition("cbean", bd);

            // 前置增强advice bean注册
            bd = new GenericBeanDefinition();
            bd.setBeanClass(MyBeforeAdvice.class);
            bf.registerBeanDefinition("myBeforeAdvice", bd);

            // 环绕增强advice bean注册
            bd = new GenericBeanDefinition();
            bd.setBeanClass(MyMethodInterceptor.class);
            bf.registerBeanDefinition("myMethodInterceptor", bd);

            // 后置增强advice bean注册
            bd = new GenericBeanDefinition();
            bd.setBeanClass(MyAfterReturningAdvice.class);
            bf.registerBeanDefinition("myAfterReturningAdvice", bd);

         // 往BeanFactory中注册AOP的BeanPostProcessor
            AdvisorAutoProxyCreator aapc = new AdvisorAutoProxyCreator();
            bf.registerBeanPostProcessor(aapc);
            // 向AdvisorAutoProxyCreator注册Advisor
           aapc.registAdvisor(
                new AspectJPointcutAdvisor("myBeforeAdvice", "execution(* com.wywhdgg.samples.ABean.*(..))"));
            // 向AdvisorAutoProxyCreator注册Advisor
                aapc.registAdvisor(
                new AspectJPointcutAdvisor("myMethodInterceptor", "execution(* com.wywhdgg.samples.ABean.do*(..))"));
            // 向AdvisorAutoProxyCreator注册Advisor
            aapc.registAdvisor(new AspectJPointcutAdvisor("myAfterReturningAdvice",
                "execution(* com.wywhdgg.samples.ABean.do*(..))"));

            bf.preInstantiateSingletons();
            System.out.println(JSON.toJSONString(bf.getBean("abean")));
            ABean abean = (ABean) bf.getBean("abean");

            abean.doSomthing();
            System.out.println("--------------------------------");
            abean.sayHello();
        }
}
