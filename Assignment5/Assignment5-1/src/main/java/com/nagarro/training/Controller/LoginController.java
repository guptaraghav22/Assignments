package com.nagarro.training.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.training.model.*;

@Controller
@RequestMapping(path = "/library/")
public class LoginController {
	private static final String GET_USER = "http://localhost:8080/login";
	private static final String GET_ALL_BOOKS = "http://localhost:8080/books";
	RestTemplate restTemplate = new RestTemplate();

	@GetMapping("/logins")
	public String entry() {
		return "login";
	}

	@PostMapping("/logins")
	public ModelAndView login(@RequestParam("user") String email, @RequestParam("pass") String password,
			HttpSession session)
	{

		Employee em = new Employee();
		em.setEmail(email);
		em.setPassword(password);
		ModelAndView mv = new ModelAndView();

		Employee emp = restTemplate.postForObject(GET_USER, em, Employee.class);

		if (emp.getPassword().equals(password)) {
			session.setAttribute("session", email);
			session.setAttribute("user", emp.getFirstName());
			mv.setViewName("Index");
			AllBooks b = restTemplate.getForObject(GET_ALL_BOOKS, AllBooks.class);
			mv.addObject("result", b);
			System.out.println("returned");
		}

		return mv;
	}

}
