package com.wywhdgg.mvc.aop.advisor;

import com.wywhdgg.mvc.aop.pointcut.Pointcut;

public interface PointcutAdvisor extends Advisor {

	Pointcut getPointcut();
}
