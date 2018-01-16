package com.atguigu.springmvc.helloworld;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 请求处理器
 */
@Controller   //将该类标识为请求处理器
public class SpringMVCHanlder {
	//浏览器:  http://localhost:8080/Springmvc01/hello
	
	@RequestMapping("/hello")
	public String hello() {
		System.out.println("Hello World ");
		return "hello";  //通过视图解析器解析得到 /WEB-INF/views/hello.jsp,通过转发的方式去往hello.jsp
	}
	
}
