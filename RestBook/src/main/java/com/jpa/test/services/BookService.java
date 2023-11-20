package com.jpa.test.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jpa.test.Entities.Book;
import com.jpa.test.dao.BookRepository;

@Component
public class BookService 
{
//	private static List<Book> list=new ArrayList<>();
//	static
//	{
//		list.add(new Book(11,"Bhagvat gita","Shri Krishna"));
//		list.add(new Book(12,"Ramayana","Rishi Valmiki"));
//	}
	
	@Autowired
	private BookRepository bookRepositoy;

	//get all books
	public List<Book> getAllBooks()
	{
		List<Book> list=(List<Book>)this.bookRepositoy.findAll();
		return list;
	}
	
	//get book by its Id
	public Book getBookById(int id)
	{
		Book book = null;
		try {
//		book=list.stream().filter(e->e.getId()==id).findFirst().get();
		this.bookRepositoy.findById(id);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return book;
	}
	
	//adding the book
	public Book addBook(Book b)
	{
		Book result=bookRepositoy.save(b);
		return result;
	}
	
	//deleting book
	public void deleteBook(int bid)
	{
		
//		list=list.stream().filter(book ->book.getId()!=bid).collect(Collectors.toList());
		bookRepositoy.deleteById(bid);
	}
	
	
	//updating book
	public void updateBook(Book book,int bookId)
	{
//		list = list.stream().map(b->{
//			if(b.getId()==bookId)
//			{
//				b.setTitle(book.getTitle());
//				b.setAuthor(book.getAuthor());
//			}
//			return b;
//		}).collect(Collectors.toList());
		
		book.setId(bookId);
		bookRepositoy.save(book);
	}
}
