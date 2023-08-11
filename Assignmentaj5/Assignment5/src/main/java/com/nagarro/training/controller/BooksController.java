package com.nagarro.training.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.training.Repository.AuthorRepo;
import com.nagarro.training.Repository.BookRepo;
import com.nagarro.training.model.BookAuthor;
import com.nagarro.training.model.BooksModel;

@RestController
@RequestMapping("/")
public class BooksController {
	@Autowired
	AuthorRepo ar;
	@Autowired 
	BookRepo br;
@RequestMapping("add")
public ModelAndView Book()
{ModelAndView mv = new ModelAndView();

	List<BookAuthor> a=ar.findAll();
	mv.setViewName("AddBook");
	Date date= new Date();
	DateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
	String currDate = dateFormat.format(date);
	mv.addObject("date",currDate);
	mv.addObject("author",a);
	return mv;
}
@PostMapping("add")
public ModelAndView  AddBook(BooksModel book){
	ModelAndView mv = new ModelAndView();
	BooksModel temp= br.findById(book.getBookCode()).orElse(new BooksModel());
	int n=temp.getBookCode();
	if(n!=0)
		{
		List<BookAuthor> a=ar.findAll();
		mv.setViewName("AddBook");
		Date date= new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
		String currDate = dateFormat.format(date);
		mv.addObject("date",currDate);
		
		mv.addObject("author",a);
		mv.addObject("error", "Book Code Already Exists");
}
		else {
			
		BooksModel ab= br.save(book);
		mv.setViewName("Index");
		List<BooksModel> b= br.findAll();
		mv.addObject("result",b);
		
		}
		return mv;
}
@GetMapping("/delete")
public ModelAndView delete(@RequestParam("Id") int code) {
	ModelAndView mv = new ModelAndView();
	 br.deleteById(code);
	 mv.setViewName("Index");
		List<BooksModel> b= br.findAll();
		mv.addObject("result",b);
		return mv;
}

@GetMapping("/edit")
public ModelAndView edit(@RequestParam("Id") int code) {
	ModelAndView mv = new ModelAndView();
	List<BookAuthor> a=ar.findAll();
	System.out.println("hello ");
	mv.addObject("author",a);
	 mv.setViewName("Edit");
	 	BooksModel bm = br.findById(code).orElse(new BooksModel());
		mv.addObject("result",bm);
		return mv;
}
@PostMapping("/edit")
public ModelAndView submitEdit(BooksModel b)
{ModelAndView mv= new ModelAndView();
	br.save(b);
	 mv.setViewName("Index");
		List<BooksModel> bm= br.findAll();
		mv.addObject("result",bm);
	return mv;

}
@RequestMapping("/logout")
public ModelAndView logout(HttpSession session)
{
	ModelAndView mv= new ModelAndView();
	session.invalidate();
	mv.setViewName("login");
	return mv;
}

}
