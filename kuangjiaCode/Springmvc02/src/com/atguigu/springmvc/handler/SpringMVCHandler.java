package com.atguigu.springmvc.handler;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.atguigu.springmvc.beans.User;
/**
 *  控制器  处理器
 *
 */
/**
 * @SessionAttributes: 将模型数据存放到session域对象
 * 	value:通过指定key的方式来决定将哪些模型数据存放到session中
 *  types:通过指定模型数据类型的方式来决定将哪些模型数据存放到session中.
 */
//@SessionAttributes(value={"password"})
@SessionAttributes(value= {"user"},types= {String.class,Integer.class})
@Controller
public class SpringMVCHandler {
	
	/**
	 * @RequestHeader
	 */
	@RequestMapping("/testRequestHeader")
	public String testRequestHeader(@RequestHeader("Accept-Language")String acceptLanguage) {
		System.out.println("acceptLanguage:" +acceptLanguage);
		return "success";
	}
	
	/**
	 * @CookieValue
	 */
	@RequestMapping("/testCookieValue")
	public String testCookieValue(@CookieValue(value="JSESSIONID",required=false)String sessionID) {
		System.out.println("sessionId:" + sessionID);
		return "success";
	}
	
	/**
	 * POJO
	 * SpringMVC会按请求参数名和POJO属性名进行自动匹配，自动为该
	 * 对象的属性赋值。并支持级联属性.
	 */
	@RequestMapping("/testPOJO")
	public String testPOJO(User user ) {
		System.out.println("user:" + user) ;
		return "success";
	}
	
	/**
	 * 测试原生的ServletAPI
	 */
	@RequestMapping("/testServletAPI")
	public void testServletAPI(HttpServletRequest request ,
								 HttpServletResponse response ) throws Exception {
		//request  response  session  PrintWriter .....
		System.out.println(request + " , " + response);
		
		//request.setAttribute("msg", "转发");
		//request.getRequestDispatcher("/WEB-INF/views/success.jsp").forward(request, response);
		//response.sendRedirect("http://www.baidu.com");
		PrintWriter out = response.getWriter();
		out.println("Hello SpringMVC");
		//return "success";
	}
	
	/**
	 * ModelAndView
	 * 
	 */
	@RequestMapping("/testModelAndView")
	public ModelAndView testModelAndView() {
		ModelAndView mav = new ModelAndView();
		//添加模型数据
		mav.addObject("username", "ZhangSanFeng");   // 会把数据放到request域对象.
		
		mav.setViewName("success");  //设置视图信息
		return  mav ;
	}
	
	/**
	 * Map
	 * 
	 * 不管目标方法返回的是ModelAndView还是String,最终都会处理成ModelAndView.
	 */
	@RequestMapping("/testMap")
	public String testMap(Map<String,Object> map) {
		System.out.println(map.getClass().getName());  //BindingAwareModelMap
		
		map.put("password", "123456");  // 会把数据放到request域对象
		map.put("age", 33);
		return "success";
	}
	
	
	/**
	 * 修改
	 */
	@RequestMapping("/testModelAttribute")
	public String testModelAttribute(@ModelAttribute(value="u")User user) {
		System.out.println("去修改对象:" + user);
		//将数据库的被改对象查出来,
		//jdbc
		return "success";
	}
	/**
	 * 1.ModelAttribute标注的方法会在每个处理方法之前执行.
	 * 
	 * ModelAttribute的运行流程:
	 * 	1.执行ModelAttribute标注的方法： 从数据库中查询被改对象，把对象放到了map中.
	 *  2.SpringMVC会在适当的时机从map中取出对象.并把表单的请求参数赋值给该对象的对应的属性.
	 *    确定key:
	 *    		a.若在目标方法的入参中使用了@ModelAttribute注解标注key，则key就是ModelAttribute注解的value值.
	 *    		b.若在目标方法的入参中没有使用@ModelAttribute注解,则key是入参类型的首字母小写. User-->"user"
	 *  3.把整合好的对象传入到目标方法的入参中.
	 *  4.SpringMVC会以确定好的key值作为key,入参对象作为value,存放到request域对象中.
	 *  
	 * @SessionAttributes注解引发的问题:
	 * 	异常:
	 *  org.springframework.web.HttpSessionRequiredException: 
	 * 	 Session attribute 'user' required - not found in session
	 *  
	 * 目标对象的入参确定步骤:
	 * 		1.从map(implicitModel)中查找确定的key所对应的对象.找到则确定了入参对象
	 *      2.查看该类是否标注了@SessionAttributes,如果标注了该注解,则使用确定的key从
	 *        session中获取对象:
	 *        a.能使用key找到对应的对象，则确定了入参对象.
	 *        b.session中没有该key.
	 *        c.session中有对应的key,但是找不到key对应的value值,则抛出异常.  
	 *      3.使用反射的方式创建一个对象传入到目标方法的入参.
	 * 
	 * 避免该异常的发生:
	 * 		1.尽量不要让session中的key与ModelAttribute注解的value值一致.
	 * 	    2.尽量保证能从map中取到对应的对象.
	 */
	//@ModelAttribute
	public  void getUser(@RequestParam(value="id",required=false)Integer id, Map<String,Object> map) {
		if(id != null) {
			User user = new User(1, "Tom", "123456", "tom@sina.com", 30);
			System.out.println("从数据库查询被改对象:" +user);
			map.put("u", user);
		}
	}
	
}
