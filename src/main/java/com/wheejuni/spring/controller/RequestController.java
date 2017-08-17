package com.wheejuni.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.wheejuni.spring.domain.Redirection;
import com.wheejuni.spring.domain.Request;
import com.wheejuni.spring.handler.ShortenedUrlGenerationHandler;

@Controller
public class RequestController {

	@PostMapping("/new")
	public String setNewRedirection(Request request, Model model) {

		Redirection redirect = ShortenedUrlGenerationHandler.newRedirectionMaker(request);
		if (redirect == null) {
			return "result/fail";
		}
		model.addAttribute("redirectinfo", redirect);
		return "result/success";

	}

}
