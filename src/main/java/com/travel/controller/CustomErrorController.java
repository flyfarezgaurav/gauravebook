package com.travel.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class CustomErrorController implements ErrorController{

    private static final String PATH = "/error";

    @RequestMapping(value = PATH)
    public ModelAndView error() {
    	ModelAndView mv  =new ModelAndView();
    	mv.setViewName("404");
    	return mv;
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}