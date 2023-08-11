package com.nagarro.week4.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.week4.dao.TshirtDao;
import com.nagarro.week4.model.Tshirt;

@Controller
public class SearchController {

	static List<Tshirt> list = new ArrayList<Tshirt>();

	@Autowired
	TshirtDao tshirtdao;

	@RequestMapping("/search")
	public ModelAndView search(@RequestParam("color") String color, @RequestParam("size") String size,
			@RequestParam("gender") String gender, @RequestParam("preference") String preference)
			throws IllegalStateException, IOException {

		ModelAndView mv = new ModelAndView();

		color = getColor(color);
		size = getSize(size);
		gender = getGender(gender);
		preference = getPreference(preference);

		list = this.tshirtdao.matchingData(color, size, gender, preference);

		String result = "Sorry!!! No Items Found.";
		mv.addObject("notFound", result);
		mv.setViewName("home");
		return mv;
	}

	public static List<Tshirt> getList() {
		return list;
	}

	public String getColor(String color) {
		String first = color.substring(0, 1);
		String last = color.substring(1);
		color = first.toUpperCase() + last.toLowerCase();
		return color;
	}

	private String getSize(String size) {
		size = size.toUpperCase();
		return size;
	}

	private String getGender(String gender) {
		gender = gender.toUpperCase();
		return gender;
	}

	private String getPreference(String preference) {
		return preference;
	}
}
