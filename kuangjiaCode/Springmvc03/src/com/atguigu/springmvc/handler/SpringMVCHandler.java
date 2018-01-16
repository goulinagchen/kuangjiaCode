package com.atguigu.springmvc.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SpringMVCHandler {
	
	@RequestMapping("/testViewAndViewResolver")
	public String testViewAndViewResolver() {
		return "success";
	}
	
//	@RequestMapping("/testJSTLView")
//	public String testJSTLView() {
//		
//		return "success";
//	}
	
	@RequestMapping("/testHelloView")
	public String testHelloView() {
		
		return "hello";
	}
	
	@RequestMapping("/testRedirect")
	public String testRedirect() {
		//return "forward:/WEB-INF/views/success.jsp";
		return "redirect:/rd.jsp"; // response.sendRedirect("/rd.jsp")
	}
}	
