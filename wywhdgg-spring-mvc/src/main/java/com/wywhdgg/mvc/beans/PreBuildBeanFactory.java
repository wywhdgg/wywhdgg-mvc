package com.wywhdgg.mvc.beans;

import com.wywhdgg.mvc.exception.BeanDefinitionRegistException;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;

/***
 *@author dzb
 *@date 2019/11/25 23:31
 *@Description:
 *@version 1.0
 */
@Slf4j
public class PreBuildBeanFactory extends DefaultBeanFactory {
    private List<String> beanNames = new ArrayList<>();

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) throws BeanDefinitionRegistException {
        super.registerBeanDefinition(beanName, beanDefinition);
        //加入同步控制，保证线程安全
        synchronized (beanNames) {
            beanNames.add(beanName);
        }
    }

    /***
     * 预加载单例bean
     * 只能加载一次
     * @throws Exception
     */
    public void preInstantiateSingletons() throws Throwable {
        synchronized (beanNames) {
            for (String name : beanNames) {
                BeanDefinition bd = this.getBeanDefinition(name);
                if (bd.isSingleton()) {
                    this.doGetBean(name);
                    if (log.isDebugEnabled()) {
                        log.info("preInstantiate: name={} ,{}" ,name, bd);
                    }
                }
            }
        }
    }
}
