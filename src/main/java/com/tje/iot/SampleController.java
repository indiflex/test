package com.tje.iot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tje.iot.domain.Product;

@Controller
public class SampleController {
	
	private static final Logger logger = LoggerFactory.getLogger(SampleController.class);
	
	@RequestMapping("doA")
	public void doA() {
		logger.info("doA called....");
	}
	
	@RequestMapping("doB")
	public String doB() {
		logger.info("doB called ++++++++++++++++++++++++++++++++++");
		return "sample-b";
	}
	
	@RequestMapping("doC")
	public String doC(
			@ModelAttribute("msg") String msg,
			@ModelAttribute("id") String id,
			Model model
		) {
		logger.info("doC called ++++++++++++++++++++++++++++++++++");
		
		model.addAttribute("title", "Product");
		
		Product prod = new Product("도깨비팬티", 23000);
		model.addAttribute(prod);
		
		return "sample-c";
	}
	
	@RequestMapping("doR")
	public String doR(RedirectAttributes rattrs, @ModelAttribute("id") String id) {
		logger.info("doR for redirect...");
		
		// http://localhost:8080/iot/doR?id=123
		rattrs.addFlashAttribute("msg", "This is message with redirect!!");
		rattrs.addFlashAttribute("id", id);
		
		return "redirect:/doC";
	}
	
	@RequestMapping("doJson")
	public @ResponseBody Product doJson() {
		Product prod = new Product("도깨비팬티", 23000);
		return prod;
	}
	
}
