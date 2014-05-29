package com.epam.mentoring.dao;

import java.sql.SQLException;

import com.epam.mentoring.types.User;

public interface UserRepository {

	public User getUserByLoginPassword(String login, String password) throws SQLException;
	
}
