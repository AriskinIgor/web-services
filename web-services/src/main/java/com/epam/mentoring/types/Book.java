package com.epam.mentoring.types;

import java.io.Serializable;
import java.util.Arrays;

public class Book implements Serializable {

	private static final long serialVersionUID = -5976581171146121329L;

	private Long id;
	private String name;
	private String author;
	private String description;
	private byte[] content;

	public Book(Long id) {
		this.id = id;
	}

	public Book() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = (content == null) ? null : Arrays.copyOf(content, content.length);
	}

	@Override
	public String toString() {
		return new StringBuffer("Name : ").append(this.name)
				.append(" Author : ").append(this.author)
				.append(" Description : ").append(this.description)
				.append(" ID : ").append(this.id).toString();
	}

}
