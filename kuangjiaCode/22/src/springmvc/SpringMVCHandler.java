package springmvc;

import beans.User;
import java.util.Map;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * 控制器 处理器
 * 
 * @author liang
 *
 */
@SessionAttributes(value = { "user" }, types = { String.class, Integer.class })
@Controller
public class SpringMVCHandler {

	/**
	 * RequestHeader
	 */
	@RequestMapping("/testRequestHeader")
	public String testRequestHeader(@RequestHeader("Accept-Language") String acceptLanguage) {
		System.out.println("acceptLanguage: " + acceptLanguage);
		return "success";
	}

	/**
	 * CookieValue
	 */
	@RequestMapping("/testCookieValue")
	public String testCookieValue(@CookieValue(value = "JSESSIONID", required = false) String sessionID) {
		System.out.println("sessionID: " + sessionID);
		return "success";
	}

	/**
	 * POJO
	 */
	@RequestMapping("/testPOJO")
	public String testPOJO(User user) {
		System.out.println("user: " + user);
		return "success";
	}

	/**
	 * ServletAPI
	 */
	@RequestMapping("/testServletAPI")
	public void testServletAPI(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("request: " + request);
		System.out.println("response: " + response);
		request.setAttribute("msg", "转发");
		try {
			request.getRequestDispatcher("/WEB-INF/view/success.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// response.sendRedirect("http://www.baidu.com");
		// PrintWriter writer = response.getWriter();
		// writer.println("Hello SpringMVC");
	}

	/**
	 * ModelAndView
	 */
	@RequestMapping("/testModelAndView")
	public ModelAndView testModelAndView() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("username", "张三丰");
		modelAndView.setViewName("success");
		return modelAndView;
	}

	/**
	 * Map
	 */
	@RequestMapping("/testMap")
	public String testMap(Map<String, Object> map) {
		System.out.println(map.getClass().getName());
		map.put("password", "123654");
		map.put("age", 19);
		return "success";
	}

	/**
	 * 修改
	 */
/*	@RequestMapping("/testModelAttribute")
	public String testModelAttribute(@ModelAttribute(value = "user") User user) {
		System.out.println("去修改对象： " + user);
		return "success";
	}

	@ModelAttribute
	public void getUser(@RequestParam(value = "id", required = false) Integer id, Map<String, Object> map) {
		if (id != null) {
			User user = new User(1, "Tom", "123644", "tom@sina.com", 18);
			System.out.println("从数据库查询被修改对象： " + user);
			map.put("user", user);
		}
	}*/
}
