package controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class WhatTimeController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// TODO Auto-generated method stub
		ModelAndView mav = new ModelAndView();
		
		Date date = new Date();
		String dateStr = date.toString();
		mav.addObject("whatTime", dateStr);
		mav.setViewName("whatTime");
		
		return mav;
	}

}
