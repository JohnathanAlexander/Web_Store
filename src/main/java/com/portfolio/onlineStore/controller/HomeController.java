package com.portfolio.onlineStore.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.portfolio.onlineStore.common.Navigation;
@Controller
public class HomeController{
	@RequestMapping("/")
	public RedirectView home(Model model){
		System.out.println("words");
		RedirectView redirect = new RedirectView();

		redirect.setUrl(Navigation.HOME);
		
		return redirect;
	}
}

