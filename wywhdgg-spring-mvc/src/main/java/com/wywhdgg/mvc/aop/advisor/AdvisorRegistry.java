package com.wywhdgg.mvc.aop.advisor;

import java.util.List;

/**
 * 注册
 * **/
public interface AdvisorRegistry {

	public void registAdvisor(Advisor ad);

	public List<Advisor> getAdvisors();
}
