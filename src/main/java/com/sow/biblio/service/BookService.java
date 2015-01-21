package com.sow.biblio.service;

import java.util.List;

import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.sow.biblio.service.model.Book;

@Service("bookService")
public class BookService extends BiblioServiceBaseAccessor implements IBookService {
	
	private static final Logger log = LoggerFactory.getLogger(BookService.class);

	public List<Book> findBook(String idStr, String name, String category, String author) {
		
		String query = "from Book where ";
		
		if (null != idStr && !idStr.isEmpty()) {
			query += " bookId = " + Integer.parseInt(idStr) + " and ";
		}
		
		if (null != name && !name.isEmpty()) {
			query += " lower(bookName) like '%" + name.toLowerCase() + "%' and ";
		}
		
		if (null != category && !category.isEmpty()) {
			query += " lower(category) like '%" + category.toLowerCase() + "%' and ";
		}
		
		if (null != author && !author.isEmpty()) {
			query += " lower(authorName) like '%" + author.toLowerCase() + "%' and ";
		}
		
		query = query.replaceFirst("(.*)and", "$1"); //remove the last 'and'
			
		TypedQuery<Book> q = em.createQuery(query, Book.class);
		List<Book> bookList = q.getResultList();
		
		log.debug("query:{}", query);
		
		return bookList;
	}
}
