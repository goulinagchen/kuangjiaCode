package com.atguigu.struts2.action;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.CompoundRoot;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * Action 对象是多例的.  效率低,安全性高.
 * 
 * Action是如何接收请求参数的?
 * 		1.在Action类中提供与请求参数名对应的set方法.
 * 		2.Struts2框架根据Map<String,String[]> map =request.getParameterMap()获取所有的请求参数.
 *        在拦截器中,对map集合进行迭代，通过key的名称(请求参数名称),利用反射的方式调用action对象的set方法.
 *        eg: key="username"
 *            Class cls =   Class.forName("com.atguigu.struts2.action.UserAction").newInstance();
 *            UserAction action = cls.newInstance();
 *            "username"==>"setUsername"==>cls.getDeclaredMethod("setUsername")==>Method对象(setUsername)
 *            setUsername.invoke(action,value);
			 
 * Action类中至少存在一个或者多个处理请求的方法.
 * Action对象处理请求的方法的名称如何确定:（哪个请求对应哪个方法）
 * 	1.通过struts.xml中 action标签的method属性来指定。
 *  2.如果不通过method来指定，则默认调用execute方法.
 *  3.Action类可以继承ActionSupport或者实现Action接口.
 *  
 * Action对象中请求处理方法的定义规则:
 * 	1.必须是public声明的.
 *  2.方法的返回值必须是String的  
 * 	3.方法必须是无参数的.	
 *  4.异常声明是可以省略的.
 *
 */
public class UserAction  /*implements Action*/ extends ActionSupport
		implements ServletRequestAware,ServletContextAware, RequestAware,SessionAware,ApplicationAware{
	
	private String username ;  // 将请求参数中参数名为"username"所对应的参数值通过set方法赋值给当前的属性.
	private String password ;
	
	private String loginMsg ;
	
	private HttpServletRequest  request ;
	private ServletContext servletContext ;
	
	private Map<String,Object> requestMap ;
	private Map<String,Object> sessionMap ;
	private Map<String,Object> servletContextMap ;
	
	public  String  login() {
		//主动获取原生的request  session  application
//		HttpServletRequest  request = ServletActionContext.getRequest();
//		HttpSession session = request.getSession();
//		ServletContext servletContext = ServletActionContext.getServletContext();
		
		
		//被动获取原生的Request  session  application
		
		request.setAttribute("request", "Servlet ... Request");
		//session.setAttribute("sessions", "Servlet ... HttpSession");
		servletContext.setAttribute("servletContext", "Servlet ... ServletContext");
		
		
		//主动方式获取Map结构的 request  session  servletContext
//		ActionContext actionContext = ActionContext.getContext();
//		Map<String,Object> requestMap = (Map<String,Object>)actionContext.get("request");
//		Map<String,Object> sessionMap = actionContext.getSession();
//		Map<String,Object> servletContextMap = actionContext.getApplication();
		
		//被动的方式获取Map结构的request  session  servletContext
		
		
		requestMap.put("requestMap", "Struts2 ... request ");
		sessionMap.put("sessionMap", "Struts2 ... session");
		servletContextMap.put("servletContextMap", "Struts2 ... ServletContext");
		
		
		//root区
		ValueStack vs = ActionContext.getContext().getValueStack();
		CompoundRoot root = vs.getRoot();
		root.push("ABC");
		
		
		
		//根据请求参数(用户名+ 密码),验证是否能进行登录
		if("admin".equals(username) && "1234".equals(password)) {
			//登录成功
			//return "success";
			return SUCCESS;  // Aaction接口中定义的常量.
		}
		
		loginMsg = "用户名或者密码错误!";
		//登录失败
		//return "login";
		return LOGIN;
	}
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		System.out.println("setUsername:" + username);
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		System.out.println("setPassword:" + password);
		this.password = password;
	}


	public String getLoginMsg() {
		return loginMsg;
	}


	@Override
	public void setServletContext(ServletContext arg0) {
		this.servletContext= arg0;
	}


	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
	}


	@Override
	public void setApplication(Map<String, Object> arg0) {
		this.servletContextMap = arg0;
		
	}


	@Override
	public void setSession(Map<String, Object> arg0) {
		this.sessionMap = arg0;
		
	}


	@Override
	public void setRequest(Map<String, Object> arg0) {
		this.requestMap = arg0;
	}
	
	

	/**  
	 * 从Action接口中实现的抽象方法
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return null;  //自定义处理规则
	}*/
	
	
}
