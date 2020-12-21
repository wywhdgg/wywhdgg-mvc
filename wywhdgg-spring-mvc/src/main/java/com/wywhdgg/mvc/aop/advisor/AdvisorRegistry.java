package com.wywhdgg.mvc.aop.advisor;

import java.util.List;

/**
 * 注册
 * @author dzb
 * @date 2019/11/27 7:01
 * @Description:
 *@version 1.0.0
 * **/
public interface AdvisorRegistry {

	public void registAdvisor(Advisor ad);

	public List<Advisor> getAdvisors();
}
