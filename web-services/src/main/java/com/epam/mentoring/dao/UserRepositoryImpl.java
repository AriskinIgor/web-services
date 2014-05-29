package com.epam.mentoring.dao;

import java.sql.SQLException;

import org.hibernate.Query;
import org.hibernate.Session;

import com.epam.mentoring.types.User;
import com.epam.mentoring.util.HibernateUtil;

public class UserRepositoryImpl implements UserRepository {

	public User getUserByLoginPassword(String login, String password)
			throws SQLException {
		Session session = null;
		User user = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Query query = session
					.createQuery(
							" select u "
									+ " from User u where u.login = :login and u.password = :password ")
					.setString("login", login).setString("password", password);
			user = (User) query.uniqueResult();
			session.getTransaction().commit();

		} finally {
			if (session != null) {
				session.close();
			}
		}
		return user;
	}

}
