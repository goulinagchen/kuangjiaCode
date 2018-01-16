package springmvc;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import beans.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;
import com.sun.beans.editors.IntegerEditor;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * 控制器，处理器
 * 
 * @author liang
 *
 */
// @SessionAttributes(value={"password","username"})//通过指定key的方式
// 将模型数据存放到session域对象中
@SessionAttributes(types = { String.class, Integer.class }) // 通过指定数据类型的方式
															// 将模型数据存放到session域对象中
@Controller
public class springmvcHandler {

	/**
	 * RequestHeader
	 * 
	 * @param acceptLanguage
	 * @return
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
	public String testCookieValue(@CookieValue(value = "JSESSIONID", required = false) String sessionid) {
		System.out.println("sessionid: " + sessionid);
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
		System.out.println(request + " , " + response);
		request.setAttribute("msg", "转发");
		// try {
		// request.getRequestDispatcher("/WEB-INF/views/success.jsp").forward(request,
		// response);
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		try {
			PrintWriter writer = response.getWriter();
			writer.println("Hello SpringMVC!");
		} catch (IOException e) {
			e.printStackTrace();
		}
		// try {
		// response.sendRedirect("");
		// } catch (IOException e) {
		// e.printStackTrace();
		// }

		// return "success";
	}

	/**
	 * ModelAndView
	 */
	@RequestMapping("/testModelAndView")
	public ModelAndView testModelAndView() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("username", "张三丰"); // 添加模型数据 放到request域对象
		mav.setViewName("success");
		return mav;
	}

	/**
	 * Map 无论返回的是ModelAndView还是String，都被处理成ModelAndView的Map
	 */
	@RequestMapping("/testMap")
	public String testMap(Map<String, Object> map) {
		System.out.println(map.getClass().getName()); // 获取map的类型名称
		map.put("password", 123654); // 底层也是存放到reques域对象
		map.put("age", 30);
		return "success";
	}

	/**
	 * ModelAttribute
	 */
	@RequestMapping("/testModelAttribute")
	public String testModelAttribute(User user) {
	//相当于： public String testModelAttribute(@ModelAttribute(value="user") User user)
		System.out.println("去修改的对象: " + user);
		return "success";
	}

	@ModelAttribute
	public void getUser(@RequestParam(value = "id", required = false) Integer id, Map<String, Object> map) {
		if (id != null) {
			User user = new User(1, "Tom", "123456", "tom@sina.com", 30);
			System.out.println("从数据库查询被改对象： " + user);
			map.put("user", user);
		}
	}
}
