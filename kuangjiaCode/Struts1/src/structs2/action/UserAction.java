package structs2.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * action 对象是多例的，效率低，安全性高
 * 
 * action接受请求参数
 * 		1.在action中提供与请求参数名对应的set方法
 * 		2.框架Struts2根据Map<String,String>map = request.getParameterMap()获取所有的请求参数，在拦截器中，对map集合进行迭代，通过key的名称（请求参数名称），利用反射的方式调用action对象的set方法
 * 				eg:key="username"
 * 				UserAction action = Class.forName("struts2.UserAction").newInstance();
 * 				"username"==>"setUsername"==>class.getDeclaredMethod("setUsername")==>Method对象（）
 * 				setUsername.invoke(action,value);
 * 
 * 	action类中至少存在一个或多个处理请求的方法
 * 
 * 	action对像处理请求的名称确定:
 * 			1.通过struts.xml中action标签的method属性指定
 * 			2.如不指定，默认查找execute()
 * 			3.实现Action接口或继承ActionSupport类
 * 
 *  action对象中请求处理规则:
 * 			1.必须是public声明的
 * 			2.方法的返回值必须是String类型的
 * 			3.方法必须是无参数的
 * 			4.异常声明是可以省略的
 * 
 * @author liang
 *
 */
public class UserAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private String username;

	private String password;

	public String login() {
		
		if ("admin".equals(username) && "1234".equals(password)) {
			return SUCCESS;
		}
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

}
