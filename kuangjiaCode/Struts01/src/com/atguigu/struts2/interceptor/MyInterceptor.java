package com.atguigu.struts2.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class MyInterceptor /*extends AbstractInterceptor*/ implements Interceptor{
	
	/**
	 * 拦截器的具体拦截过程
	 */
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		//根据实际的业务编写拦截相关的代码
		
		System.out.println("请求阶段拦截了一下.....");
		String result  = invocation.invoke();  // 执行后续的拦截器或者是Action
		System.out.println("响应阶段拦截了一下..... " +result );
		return result;
	}

	@Override
	public void destroy() {
		System.out.println("MyInterceptor destroy....");
	}

	@Override
	public void init() {
		System.out.println("MyInterceptor init .....");
	}


}
