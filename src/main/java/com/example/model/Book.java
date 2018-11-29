package com.example.model;

public class Book {
	int id;
	String name;
	String writer;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Book(int id, String name, String writer) {
		super();
		this.id = id;
		this.name = name;
		this.writer = writer;
	}
	
	
}
