package com.travel.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.travel.bean.ImageForm;
import com.travel.bean.LoginForm;

@Controller
public class ImageController {
	
	@GetMapping("/image/login")
	public String imagelogin(@ModelAttribute LoginForm loginForm){
		return "imagelogin";
	}
	
	@PostMapping("/image/login")
	public String imageloginSubmit(@ModelAttribute LoginForm loginForm,@ModelAttribute ImageForm imageForm,Model model){
		if(loginForm.getUserName().equalsIgnoreCase("support@volfly.com") && loginForm.getPassword().equals("volflyimages")){
			return "imageupload";
		}
		else{
		model.addAttribute("loginError", "Username & Password didn't matched");	
		return "imagelogin";
		}
	}
	
		
	@PostMapping("/image/submit")
	public String imagesubmit(@ModelAttribute ImageForm imageForm,HttpServletRequest request,Model model){
		System.out.println("folder name : " + imageForm.getFolderName());
		
		String UPLOADED_FOLDER = request.getServletContext().getRealPath("")+"//resources//images//"+imageForm.getFolderName().toLowerCase().replaceAll(" ", "-")+"//";   // for server
		//String UPLOADED_FOLDER = request.getServletContext().getRealPath("")+"\\resources\\images\\"+clientForm.getClientName().toLowerCase().replaceAll(" ", "-")+"\\"; 
		File directory = new File(UPLOADED_FOLDER);
	   	 if (! directory.exists()){
	   	        directory.mkdir();
	   	    }
		byte[] bytesLogo = null;
		 try {
    		 bytesLogo = imageForm.getFile().getBytes();
    		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 Path path = Paths.get(UPLOADED_FOLDER + imageForm.getFile().getOriginalFilename());
          try {
        	  Files.write(path, bytesLogo);
        	 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         model.addAttribute("imageSuccess", "Image Uploaded Successfully!");
		return "imageupload";
	}

}
