package com.epam.mentoring.services;

import javax.xml.ws.Endpoint;

import com.epam.mentoring.services.AuthorizationServiceImpl;

public class AuthorizationServiceTest {

	public static void main(String[] args) {

		Endpoint authService = Endpoint.publish(
				"http://localhost:8080/AuthorizationService",
				new AuthorizationServiceImpl());
		System.out
				.println("AuthorizationService published: " + authService.isPublished());
	}

}
