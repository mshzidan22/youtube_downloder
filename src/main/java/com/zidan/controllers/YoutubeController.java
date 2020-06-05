package com.zidan.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.zidan.model.UrlBean;
import com.zidan.model.Video;
import com.zidan.service.YoutubeService;




@Controller
public class YoutubeController {
  @Autowired
  private YoutubeService youtubeService;

  

	
	
	@GetMapping("/")
	public String viewindex(Model model) {
          		model.addAttribute("urlBean", new UrlBean());
		return "index";
	}
	
	@PostMapping("/getvideo")
	public String getUrl(@Valid @ModelAttribute("urlBean")  UrlBean urlBean ,BindingResult error, Model model ,RedirectAttributes ra ) {
		if(error.hasErrors()) {
			System.out.println("there is error");
			return "index";
			}else {
		Video video  =youtubeService.getVideo(urlBean.getUrl());
		ra.addFlashAttribute("video", video);
		return "redirect:download";}
	}
	
	@GetMapping("/download")
	public String download( ) {

		
		return "download";
	}
	
	@GetMapping("/error")
	public String error(){
		return "redirect:getvideo";
	}
}
