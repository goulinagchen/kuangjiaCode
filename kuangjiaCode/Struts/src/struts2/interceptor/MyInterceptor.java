package struts2.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class MyInterceptor /* extends AbstractInterceptor */ implements Interceptor {

	@Override
	public void destroy() {
		System.out.println("MyInterceptor destroy...");
	}

	@Override
	public void init() {
		System.out.println("MyInterceptor init...");
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("MyInterceptor intercept...");
		// 根据业务编写拦截相关的代码
		System.out.println("请求阶段拦截了一下。。。");
		String result = invocation.invoke(); // 执行后续的拦截器或者是action
		System.out.println("响应阶段拦截了一下。。。" + result);
		return result;
	}

}
