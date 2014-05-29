package com.epam.mentoring.services;

import java.sql.SQLException;

import javax.jws.WebService;

import com.epam.mentoring.dao.UserRepository;
import com.epam.mentoring.dao.UserRepositoryImpl;
import com.epam.mentoring.types.AuthorizationCredential;
import com.epam.mentoring.types.User;

@WebService(endpointInterface = "com.epam.mentoring.services.AuthorizationService", targetNamespace = "http://web-services", portName = "AuthorizationServicePort", serviceName = "AuthorizationService")
public class AuthorizationServiceImpl implements AuthorizationService {

	public Boolean authorization(AuthorizationCredential credential) {
		UserRepository userDAO = new UserRepositoryImpl();
		User user = null;
		try {
			user = userDAO.getUserByLoginPassword(credential.getLogin(),
					credential.getPassword());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user != null;
	}

}
