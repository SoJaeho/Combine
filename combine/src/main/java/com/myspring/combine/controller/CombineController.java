package com.myspring.combine.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



public interface CombineController {
	public ModelAndView game(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView score(HttpServletRequest request, HttpServletResponse response) throws Exception;
}