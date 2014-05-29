package com.epam.mentoring.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.epam.mentoring.dao.BookRepository;
import com.epam.mentoring.dao.BookRepositoryImpl;
import com.epam.mentoring.types.Book;

@Path("/atheneum")
public class AtheneumService {

	BookRepository repository = new BookRepositoryImpl();

	@PUT
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean addBook(Book book) {
		return repository.addBook(book);
	}

	@POST
	@Path("/edit")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Book editBook(Book book) {
		return repository.editBook(book);
	}

	@DELETE
	@Path("/remove")
	public boolean removeBook(Long id) {
		return repository.removeBook(id);
	}

	@GET
	@Path("/getAll")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Book> getAllBooks() {
		return repository.getAllBooks();
	}

	@POST
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public Book getBook(Long id) {
		return repository.getBook(id);
	}

}
