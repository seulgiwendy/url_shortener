package com.wheejuni.spring.handler;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;

import com.wheejuni.spring.domain.Redirection;
import com.wheejuni.spring.domain.Request;
import com.wheejuni.spring.repositories.RedirectionRepository;

public class ShortenedUrlGenerationHandler {
	
	@Autowired
	static RedirectionRepository redirectRepo;

	public static Redirection newRedirectionMaker(Request request) {

		String mappedUrl = newUrlMaker(7);
		Redirection redirect = new Redirection(mappedUrl, request.getRequestedUrl());
		redirectRepo.save(redirect);
		return redirect;
	}

	public static String newUrlMaker(int length) {

		Random rnd = new Random();

		StringBuffer buf = new StringBuffer();

		for (int i = 0; i < length; i++) {
			if (rnd.nextBoolean()) {
				buf.append((char) ((int) (rnd.nextInt(26)) + 97));
			} else {
				buf.append((rnd.nextInt(10)));
			}
		}

		return buf.toString();

	}

}
