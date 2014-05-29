package com.epam.mentoring.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import com.epam.mentoring.types.Book;
import com.epam.mentoring.util.HibernateUtil;

public class BookRepositoryImpl implements BookRepository {

	@Override
	public boolean addBook(Book book) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(book);
			session.getTransaction().commit();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public Book editBook(Book book) {
		Session session = null;
		Book newBook = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			newBook = (Book) session.merge(book);
			session.getTransaction().commit();
			return newBook;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public boolean removeBook(Long id) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.delete(new Book(id));
			session.getTransaction().commit();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Book> getAllBooks() {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Query query = session.createQuery(" select b from Book b");
			return query.list();
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ArrayList<Book>();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public Book getBook(Long id) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			return (Book) session.get(Book.class, id);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

}
