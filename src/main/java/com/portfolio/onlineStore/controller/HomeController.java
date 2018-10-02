package com.alexandersEmporium.onlineStore.controller;


import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.alexandersEmporium.onlineStore.domain.Product;
import com.alexandersEmporium.onlineStore.domain.Users.User;
@Controller
public class HomeController {
	@RequestMapping("/")
	public String home(Model model){
		System.out.println("words");
		return "home";
	}
	@RequestMapping("/register")
	public String register(@ModelAttribute User user, Model model) {
		//model.addAttribute("users", user);
		System.out.println("Email: "+ user.getEmail());
		System.out.println("Hello, Worlds");
		model.addAttribute("users", user);
		return "about";
	}
}

