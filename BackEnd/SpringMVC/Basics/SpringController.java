package com.cap.springmvc.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.spi.http.HttpContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.cap.springmvc.beans.User;


@Controller
public class SpringController {
	@Autowired
	private ServletContext context;
	@RequestMapping("/hello")
	public String Hello(ModelMap map) {
		map.addAttribute("msg","Hello springmvc");
		return "index";
	}
	//@RequestMapping(path = "/query",method = RequestMethod.GET)
	@GetMapping("/query")
	public String query(@RequestParam("name") String name,
			@RequestParam("age") int age,ModelMap map) {

		map.addAttribute("name",name);
		map.addAttribute("age",age);
		return "query";
	}
	@GetMapping("/form")
	public String form() {
		return "form";
	}

	@PostMapping("/form")
	public String form(User user,ModelMap map) {
		map.addAttribute("name",user.getName());
		map.addAttribute("email",user.getEmail());
		map.addAttribute("password",user.getPassword());
		map.addAttribute("gender",user.getGender());
		return "form";
	}
	@GetMapping("/createCookie") // without slash also it works
	public String createCookie(HttpServletResponse response) {
		Cookie cookie = new Cookie("name","Saif");
		response.addCookie(cookie);
		return "createCookie";
	}
	@GetMapping("/getCookie")
	public String getCookie(@CookieValue(name="name",required = false) String name,ModelMap map) {
		if(name!=null) {
			map.addAttribute("name",name);
		} else {
			map.addAttribute("name","Cookie not present");
		}
		return "getCookie";
	}
	@GetMapping("/path/{movie}/{hero}")
	public String path(@PathVariable("movie")String movie,@PathVariable("hero")String hero,
			ModelMap map) {
		map.addAttribute("movie",movie);
		map.addAttribute("hero",hero);
		return "pathValue";
	}
	@GetMapping("/forward")
	public String forward() {
		return "forward:hello";
	}

	@GetMapping("/redirect")
	public String redirect() {
		return "redirect:https://www.google.com";
	}
	@GetMapping("/login")
	public String login() {
		return "login";
	}
//	@PostMapping("/login")
//	public String login(String username,String password,HttpSession session,ModelMap map) {
//		if(username.equals("user")&& password.contentEquals("password")) {
//			map.addAttribute("msg","logged in");
//			return "home";
//		} else {
//			session.invalidate();
//			map.addAttribute("msg","Invalid credentials");
//			return "login";
//		}
//	}
	@PostMapping("/login")
	public String login(String username,String password,HttpServletRequest request,ModelMap map) {
		if(username.equals("user")&& password.equals("password")) {
			User user = new User();
			user.setName(username);
			user.setPassword(password);
			user.setGender("M");
			user.setEmail("fsa@gsd.com");
			HttpSession session=request.getSession(true);
			session.setAttribute("user", user);
			map.addAttribute("msg","logged in");
			return "home";
		} else {
			map.addAttribute("msg","Invalid credentials");
			return "login";
		}
	}
	
	@GetMapping("/home")
	public String home(@SessionAttribute(name="user",required = false) User user) {
		if(user!=null) {
			return "home";			
		} else {
			return "login";
		}
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "login";
	}
	
	@GetMapping("/appAttribute")
	public String setAppAttribute() {
		context.setAttribute("msg", new Object());
		return "setContext";
	}
	
	@GetMapping("/getAppAttribute")
	public String getAppAttribute() {
		System.out.println(context.getAttribute("msg"));
		return "getContext";
	}
}
