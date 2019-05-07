package com.feadback.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.feadback.bean.Regbean;
import com.feedback.dao.FeadbackDao;

@Controller
public class HomeController {
	
	@Autowired
	FeadbackDao theDao;
	
	@RequestMapping("/index")
	public String home(Model theModel){
		Regbean reg=new Regbean();
		theModel.addAttribute("reg",reg);
		return "index";
	}
	@RequestMapping("/store")
	public String store(@ModelAttribute("reg") Regbean reg ){
		theDao.store(reg);
		return "redirect:/show";
	}
	@RequestMapping("show")
	public String show(Model theModel){
		List<Regbean> list=theDao.getReg();
		theModel.addAttribute("list", list);
		return "display";
		
	}
	@RequestMapping("/delete")
	public String Delete(@RequestParam("userId") int id){
		theDao.delete(id);
		return "redirect:/show";
	}
	
}
