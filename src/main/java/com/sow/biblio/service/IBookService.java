package com.sow.biblio.service;

import java.util.List;

import com.sow.biblio.service.model.Book;

public interface IBookService {
	
	public List<Book> findBook(String idStr, String name, String category, String author);
	
//	public Book getBook();
//	
//	public Book getAllBooks();
//	
//	public Book saveBook();
}
