package com.wywhdgg.mvc.beans;

/***
 *@author dzb
 *@date 2019/11/26 6:34
 *@Description: 用于依赖注入中描述的依赖
 *@version 1.0
 */
public class BeanReference {

    private  String beanName;

    public BeanReference(String beanName) {
        super();
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}
