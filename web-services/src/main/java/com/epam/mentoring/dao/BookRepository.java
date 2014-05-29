package com.epam.mentoring.dao;

import java.util.List;

import com.epam.mentoring.types.Book;

public interface BookRepository {

	public boolean addBook(Book book);

	public Book editBook(Book book);

	public boolean removeBook(Long id);

	public List<Book> getAllBooks();

	public Book getBook(Long id);

}
