package com.demo.gbook.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.gbook.dto.GbookDTO;
import com.demo.gbook.service.GbookService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	private final GbookService gbookService;
	
	@Autowired
	public HomeController(GbookService gbookService) {
		this.gbookService = gbookService;
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {
		List<GbookDTO> dtoList = gbookService.getAllGbookDTO();
		model.addAttribute("dtoList", dtoList);
		 
		return "list";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register() {
		return "register";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public void registerPost(GbookDTO dto) {
		gbookService.registerGbook(dto);
		//return "redirect:/gbook/register";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String modify() {
		return "modify";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String modifyPost(GbookDTO dto) {
		gbookService.updateById(dto);
		return "redirect:";
	}
	
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String modifyPost(Long id) {
		gbookService.deleteById(id);
		return "redirect:/list";
	}
}
