package com.wheejuni.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.wheejuni.spring.domain.Redirection;
import com.wheejuni.spring.repositories.RedirectionRepository;

@Controller
public class RedirectionController {

	@Autowired
	RedirectionRepository redirectionRepo;

	@GetMapping("/{mappedUrl}")
	public String getRedirectionRequest(@PathVariable String mappedUrl) {
		Redirection requestedRedirection = redirectionRepo.findByMappedUrl(mappedUrl);

		if (requestedRedirection == null) {
			return "redirect/error";
		}

		return requestedRedirection.redirect();
	}

}
