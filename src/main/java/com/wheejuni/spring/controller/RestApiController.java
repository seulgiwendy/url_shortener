package com.wheejuni.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wheejuni.spring.domain.Redirection;
import com.wheejuni.spring.domain.Request;
import com.wheejuni.spring.handler.ShortenedUrlGenerationHandler;
import com.wheejuni.spring.repositories.RedirectionRepository;

@RestController("/api")
public class RestApiController {
	
	@Autowired
	RedirectionRepository redirectionRepo;
	
	@PostMapping("/new")
	public Redirection setNewRedirectionRestApi(Request request) {
		Redirection redirect = ShortenedUrlGenerationHandler.newRedirectionMaker(request);
		redirectionRepo.save(redirect);
		return redirect;
	}
	
	@GetMapping("/{mappedurl}")
	public Redirection getRedirectionInfo(@PathVariable String mappedurl) {
		
		Redirection requestedRedirect = redirectionRepo.findByMappedUrl(mappedurl);
		return requestedRedirect;
		
	}
}
