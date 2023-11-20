package com.jpa.test.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.test.Entities.Book;
import com.jpa.test.services.BookService;

@RestController
public class BookController 
{
	@Autowired
	private BookService bookservice;
	
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getBooks()
	{
		List<Book> list=bookservice.getAllBooks();
		if(list.size()<=0)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
	}

	@GetMapping("/books/{id}")
	public ResponseEntity<Book> getBook(@PathVariable("id") int id)
	{
		Book book=bookservice.getBookById(id);
		if(book==null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return 	ResponseEntity.of(Optional.of(book));		
	}
	
	@PostMapping("/books")
	public Book addBook(@RequestBody Book book)
	{
		Book b=this.bookservice.addBook(book);
		return b;
	}
	@DeleteMapping("/books/{bookId}")
	public void deleteBook(@PathVariable("bookId") int bookId)
	{
		this.bookservice.deleteBook(bookId);
	}
	
	@PutMapping("/books/{bookId}")
	public Book updateBook(@RequestBody Book book,@PathVariable("bookId") int bookId)
	{
		this.bookservice.updateBook(book,bookId);
		return book;
	}
}
