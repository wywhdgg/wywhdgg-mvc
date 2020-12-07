package com.wywhdgg.mvc.aop.advisor;

import com.wywhdgg.mvc.aop.pointcut.AspectJExpressionPointcut;
import com.wywhdgg.mvc.aop.pointcut.Pointcut;

public class AspectJPointcutAdvisor implements PointcutAdvisor {

	private String adviceBeanName;

	private String expression;

	private AspectJExpressionPointcut pointcut;

	public AspectJPointcutAdvisor(String adviceBeanName, String expression) {
		super();
		this.adviceBeanName = adviceBeanName;
		this.expression = expression;
		this.pointcut = new AspectJExpressionPointcut(this.expression);
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
