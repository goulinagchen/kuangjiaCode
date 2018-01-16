package com.atguigu.springmvc.requestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/springmvc")
public class TestRequestMapping {
	/**
	 * RequestMapping 除了可以加到方法上还可以加到类上.
	 * http://localhost:8888/Springmvc01/springmvc/testRequestMapping
	 * 加到类上: 提供初步的请求映射信息. 相对于WEB应用的根目录. 
	 * 加到方法上: 提供进一步的细分的请求映射信息.相对于类定义处的URL.
	 *           如果类上没有标注@RequestMapping,则方法上的请求映射信息相对于web应用的根目录.
	 */
	@RequestMapping("/testRequestMapping")  //result: /springmvc/testRequestMapping
	public String  testRequestMapping() {  // 类上的RequestMapping+方法上的RequestMapping
		
		return "success";
	}
	/**
	 * @RequestMapping指定请求的方式
	 * 常用的请求方式:  GET  POST  PUT  DELTE
	 */
	@RequestMapping(value="/testRequestMethod",method=RequestMethod.POST)
	public String testRequestMethod() {
		return "success";
	}
	
	
	/**
	 * @RequestMapping 指定 请求参数(params)  和 请求头信息(headers)
	 * params= {"username","age!=10"}: 要求请求中必须包含名为username的参数
	 *                                 必须包含名为age的参数，但是age不能等于10
	 *                                 
	 * headers={"Accept-Language=en-US,zh;q=0.8,en;q=0.6"}
	 */
	@RequestMapping(value="/testParams",params= {"username","age!=10"},
					headers= {"Accept-Language=en-US,zh;q=0.8,en;q=0.6"})
	public String testParams() {
		return  "success";
	}
	
	/**
	 * Ant风格的URL
	 */
	@RequestMapping("/testAnt/*/abc")
	public String testAnt() {
		return "success";
	}
	
	/**
	 * 请求: springmvc/testPathVariable/1001/30"
	 */
	@RequestMapping(value="testPathVariable/{id}/{age}")
	public String testPathVariable(@PathVariable("id")Integer id, 
						@PathVariable("age")Integer age ) {
		System.out.println(id +" , "+age);
		return "success";
	}
		
	/**
	 * REST  GET
	 */
	@RequestMapping(value="/user/{id}",method=RequestMethod.GET)
	public String testRestGET(@PathVariable("id")Integer id ) {
		System.out.println("Test REST GET:" +id );
		return "success";
	}
	
	/**
	 * REST  POST
	 */
	@RequestMapping(value="/user",method=RequestMethod.POST)
	public String testRestPOST() {
		System.out.println("Test REST POST");
		return "success";
	}
	/**
	 * REST DELETE
	 */
	@RequestMapping(value="/user/{id}",method=RequestMethod.DELETE)
	public String testRestDELETE(@PathVariable("id")Integer id ) {
		System.out.println("Test REST DELETE:" + id );
		return "success";
	}
	
	/**
	 * REST PUT
	 */
	@RequestMapping(value="/user",method=RequestMethod.PUT)
	public String testRestPUT() {
		System.out.println("Test REST PUT");
		return "success";
	}
	
	/**
	 * 通过@RequestParam来映射请求参数
	 * 请求: testRequestParam?username=Atguigu&age=10
	 *      testRequestParam/Atguigu/10
	 * 注意:    
	 * 1.如果说请求参数名与处理方法的入参名一样，可以省略@RequestParam注解. 但是不建议省略.
	 * 2.使用@RequestParam指定的入参，必须要从请求参数中找到对应的参数。
	 * 3.可以通过required=true/false来配置是否必须要从请求参数中找到对应的参数
	 * 4.默认情况下，如果从请求参数中找不到对应的参数，Springmvc会给入参赋null值,
	 * 	 如果入参定义的是基本类型的，则不能接收null值.
	 * 	 a.使用包装类型
	 *   b.使用defaultValue来指定默认值.
	 */
	@RequestMapping("/testRequestParam")
	public String testRequestParam(@RequestParam("username")String username,
								   @RequestParam(value="age",required=false,defaultValue="0")int age ) {
		//request
		System.out.println(username + " , " + age );
		return "success";
	}
}
