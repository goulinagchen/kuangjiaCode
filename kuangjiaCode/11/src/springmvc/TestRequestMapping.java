package springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/springmvc")
public class TestRequestMapping {

	@RequestMapping("/testRequestMapping")
	public String testRequestMapping() {
		System.out.println("springmvc.TestRequestMapping.testRequestMapping()");
		return "success";
	}

	@RequestMapping(value = "/testRequestMethod", method = RequestMethod.POST)
	public String testRequestMethod() {
		System.out.println("springmvc.TestRequestMapping.testRequestMethod()");
		return "success";
	}

	@RequestMapping(value = "/testParams", params = { "username", "age!=10" }, headers = {
			"Accept-Language=zh-CN,zh;q=0.8" })
	public String testParams() {
		System.out.println("springmvc.TestRequestMapping.testParams()");
		return "success";
	}

	@RequestMapping("/testAnt/*/abc")
	public String testAnt() {
		System.out.println("springmvc.TestRequestMapping.testAnt()");
		return "success";
	}

	@RequestMapping(value = "testPathVarible/{id}/{age}")
	public String testPathVarible(@PathVariable("id") Integer id, @PathVariable("age") Integer age) {
		System.out.println(id + " , " + age);
		return "success";
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public String testRestGET(@PathVariable("id") Integer id) {
		System.out.println("Test REST GET: " + id);
		return "success";
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public String testRestPOST() {
		System.out.println("Test REST POST");
		return "success";
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	public String testRestDELETE(@PathVariable("id") Integer id) {
		System.out.println("Test REST DELETE: " + id);
		return "success";
	}

	@RequestMapping(value = "/user", method = RequestMethod.PUT)
	public String testRestPUT() {
		System.out.println("Test REST PUT");
		return "success";
	}

	@RequestMapping("testRequestParam")
	public String testRequestParam(@RequestParam("username") String username,
			@RequestParam(value = "age", required = false, defaultValue = "101") int age) {
		System.out.println(username + " , " + age);
		return "success";
	}
	
}
