package com.atguigu.struts2.action;

import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport  implements RequestAware,SessionAware,ApplicationAware {

	protected  Map<String,Object> request ;
	protected  Map<String,Object> session ;
	protected  Map<String,Object> application ;
	
	@Override
	public void setApplication(Map<String, Object> arg0) {
		this.application = arg0 ;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0 ;
	}

	@Override
	public void setRequest(Map<String, Object> arg0) {
		this.request = arg0 ;
	}
	
}
