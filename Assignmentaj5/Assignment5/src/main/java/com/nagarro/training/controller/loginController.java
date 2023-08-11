package com.nagarro.training.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.training.model.Employee;
import com.nagarro.training.Repository.BookRepo;
import com.nagarro.training.Repository.EmployeeRepo;
import com.nagarro.training.model.BooksModel;

@RestController

public class loginController {
@Autowired
EmployeeRepo repo;	//?	

@Autowired	//?
BookRepo bookrepo;

@RequestMapping("login")
public ModelAndView login(@RequestParam("user") String email,@RequestParam("pass") String password, HttpSession session)
//public ModelAndView login(@RequestParam("id") int id, HttpSession session)

{
ModelAndView mv = new ModelAndView();

   Employee emp = repo.findByEmail(email);//??
	if(emp.getPassword().equals(password))
	{
		session.setAttribute("session", email);
		session.setAttribute("user",emp.getFirstName() );
		mv.setViewName("Index");
		List<BooksModel> b= bookrepo.findAll();
		mv.addObject("result",b);
		
	
	}
	else {
		mv.setViewName("login");
	}
		return mv;
}
@RequestMapping("/")
public ModelAndView home() {
	ModelAndView mv = new ModelAndView();
	mv.setViewName("login");
    return mv	;
}



}
