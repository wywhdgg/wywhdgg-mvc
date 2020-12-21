package com.wywhdgg.mvc.aop.advisor;

import com.wywhdgg.mvc.aop.pointcut.AspectJExpressionPointcut;
import com.wywhdgg.mvc.aop.pointcut.Pointcut;

/***
 *
 *  抽象出来
 *
 *@author dzb
 *@date 2019/11/27 7:51
 *@Description:
 *@version 1.0.0
 */
public abstract class AbstractPointcutAdvisor implements PointcutAdvisor{

    private String adviceBeanName;

    private String expression;

    private AspectJExpressionPointcut pointcut;

    public AbstractPointcutAdvisor(String adviceBeanName, String expression) {
        this.adviceBeanName = adviceBeanName;
        this.expression = expression;
    }

    @Override
    public Pointcut getPointcut() {
        return this.pointcut;
    }

    @Override
    public String getAdviceBeanName() {
        return this.adviceBeanName;
    }

    @Override
    public String getExpression() {
        return this.expression;
    }
}
