package com.wywhdgg.mvc.aop.pointcut;

import java.lang.reflect.Method;

import org.aspectj.weaver.tools.PointcutExpression;
import org.aspectj.weaver.tools.PointcutParser;
import org.aspectj.weaver.tools.ShadowMatch;

/***
 *
 * 切入表达式解析器
 *@author 2019/11/27 7:18
 *@Description:
 *@version 1.0.0
 */
public class AspectJExpressionPointcut implements Pointcut {

    /**
     * 获取切点解析器
     **/
    private static PointcutParser pp = PointcutParser
            .getPointcutParserSupportingAllPrimitivesAndUsingContextClassloaderForResolution();

    /**
     * 表达式
     **/
    private String expression;

    /**
     * 匹配类工具
     **/
    private PointcutExpression pe;

    public AspectJExpressionPointcut(String expression) {
        super();
        this.expression = expression;
        //解析表达式
        pe = pp.parsePointcutExpression(expression);
    }


    @Override
    public boolean matchsClass(Class<?> targetClass) {
        return pe.couldMatchJoinPointsInType(targetClass);
    }

    @Override
    public boolean matchsMethod(Method method, Class<?> targetClass) {
        //通过方法来匹配
        ShadowMatch sm = pe.matchesMethodExecution(method);
        return sm.alwaysMatches();
    }

    public String getExpression() {
        return expression;
    }
}
