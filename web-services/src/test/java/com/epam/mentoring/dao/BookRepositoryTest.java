package com.epam.mentoring.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.epam.mentoring.types.Book;
import com.epam.mentoring.types.User;
import com.epam.mentoring.util.HibernateUtil;

public class BookRepositoryTest {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Book p1 = new Book();
		p1.setName("ranga");
		long bookId = (Long) session.save(p1);

		User user = new User();
		user.setFirstName("Igor");
		user.setLastName("Ariskin");
		user.setLogin("Igor_Ariskin");
		user.setPassword("ariskin");
		session.save(user);

		session.getTransaction().commit();

		Book person = (Book) session.get(Book.class, bookId);
		System.out.println(person);

		session.close();

	}

}
