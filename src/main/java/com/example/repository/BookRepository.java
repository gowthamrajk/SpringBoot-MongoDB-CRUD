package com.example.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import com.example.model.Book;

public interface BookRepository extends MongoRepository<Book, Integer>{

	@Query("{bookName: ?0}")
	public Book getBookByBookName(String bookName);
	
	@Query("{authorName: ?0}")
	public Book getBookByAuthorName(String authorName);
	
	@Query("{publishedYear: ?0}")
	public Book getBookByPublishedYear(Integer publishedYear);
	
	@Query("{price: ?0}")
	public Book getBookByPrice(Double price);
}
