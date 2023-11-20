package com.jpa.test.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Author
{
	@Id
	private int author_id;
	private String first_name;
	private String last_name;
	private String language;
	
	
	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Author(int author_id, String first_name, String last_name, String language) {
		super();
		this.author_id = author_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.language = language;
	}
	public int getAuthor_id() {
		return author_id;
	}
	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	
}
