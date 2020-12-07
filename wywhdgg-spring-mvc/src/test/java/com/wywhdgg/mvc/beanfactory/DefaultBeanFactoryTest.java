package com.wywhdgg.mvc.beanfactory;

import com.wywhdgg.mvc.beans.BeanDefinition;
import com.wywhdgg.mvc.beans.DefaultBeanFactory;
import com.wywhdgg.mvc.beans.GenericBeanDefinition;
import com.wywhdgg.samples.ABean;
import com.wywhdgg.samples.ABeanFactory;
import org.junit.AfterClass;
import org.junit.Test;

/***
 *@author dzb
 *@date 2019/11/25 23:35
 *@Description:
 *@version 1.0
 */
public class DefaultBeanFactoryTest {

   static DefaultBeanFactory bf = new DefaultBeanFactory();

    /**构造方法**/
    @Test
    public void testRegist() throws Exception {
        GenericBeanDefinition bd = new GenericBeanDefinition();
        bd.setBeanClass(ABean.class);
        bd.setScope(BeanDefinition.SCOPE_SINGLETION);
        bd.setInitMethodName("init");
        bd.setDestroyMethodName("destroy");
        bf.registerBeanDefinition("aBean", bd);
    }

    /**静态工厂方法**/
    @Test
    public void testRegistStaticFactoryMethod() throws Exception {
        GenericBeanDefinition bd = new GenericBeanDefinition();
        bd.setBeanClass(ABeanFactory.class);
        bd.setFactoryMethodName("getABean");
        bf.registerBeanDefinition("staticAbean", bd);
    }

    /**工厂方法**/
    @Test
    public void testRegistFactoryMethod() throws Exception {
        GenericBeanDefinition bd = new GenericBeanDefinition();
        bd.setBeanClass(ABeanFactory.class);
        String fbname = "factory";
        bf.registerBeanDefinition(fbname, bd);

        bd = new GenericBeanDefinition();
        bd.setFactoryBeanName(fbname);
        bd.setFactoryMethodName("getABean2");
        bd.setScope(BeanDefinition.SCOPE_PROTOTYPE);
         //有问题
        bf.registerBeanDefinition("factoryAbean", bd);
    }

    @AfterClass
    public static void testGetBean() throws Throwable {
        System.out.println("构造方法方式------------");
       /* for (int i = 0; i < 3; i++) {
            ABean ab = (ABean) bf.getBean("aBean");
            ab.doSomthing();
        }*/

     /*   System.out.println("静态工厂方法方式------------");
        for (int i = 0; i < 3; i++) {
            ABean ab = (ABean) bf.getBean("staticAbean");
            ab.doSomthing();
        }*/

        System.out.println("工厂方法方式------------");
        for (int i = 0; i < 3; i++) {
            ABean ab = (ABean) bf.getBean("factoryAbean");
            ab.doSomthing();
        }

        bf.close();
    }



}
