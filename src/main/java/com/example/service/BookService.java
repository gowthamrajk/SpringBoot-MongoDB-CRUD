package com.example.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exception.AuthorNameNotFoundException;
import com.example.exception.BookIdNotFoundException;
import com.example.exception.BookNameNotFoundException;
import com.example.exception.DuplicateBookException;
import com.example.exception.PriceNotFoundException;
import com.example.exception.PublishedYearNotFoundException;
import com.example.model.Book;
import com.example.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	public void saveBook(Book book) throws DuplicateBookException {
		
		Book bookObj = findBookById(book.getBookId());
		if(null != bookObj)
			throw new DuplicateBookException("Book Already Present !!!");
		else
		    bookRepository.save(book);
	}
	
	public void updateBook(Book book) throws BookIdNotFoundException {
		
		Book bookObj = findBookById(book.getBookId());
		if(null != bookObj)
			bookRepository.save(book);
		else
			throw new BookIdNotFoundException("Book Not Present !!, Please add the book first !!!");
	}
	
	public List<Book> getAllbooks() {
		
		return bookRepository.findAll();
	}
	
	public Book findBookById(Integer bookId) {
		
		Optional<Book> bookObj = bookRepository.findById(bookId);
		if(bookObj.isEmpty())
			return null;
		else
			return bookObj.get();
	}
	
    public Book findBookByBookName(String bookName) {
		
		return bookRepository.getBookByBookName(bookName);
	}
    
    public Book findBookByAuthorName(String authorName) {
		
		return bookRepository.getBookByAuthorName(authorName);
	}
    
    public Book findBookByPublishedYear(Integer publishedYear) {
		
		return bookRepository.getBookByPublishedYear(publishedYear);
	}
    
    public Book findBookByPrice(double price) {
		
		return bookRepository.getBookByPrice(price);
	}

	public void deleteBookById(Integer bookId) throws BookIdNotFoundException {
		
		Book book = findBookById(bookId);
		if(null != book)
		    bookRepository.delete(book);
		else 
			throw new BookIdNotFoundException("Book With ID: " + bookId + " Not found in the Stack !!, Please enter Proper Book ID !!!"); 
	}
	
	public void deleteBookByName(String bookName) throws BookNameNotFoundException {
		
		Book book = findBookByBookName(bookName);
		if(null != book)
			bookRepository.delete(book);
		else 
			throw new BookNameNotFoundException("Book With Name: " + bookName + " Not found in the Stack !!, Please enter Proper Book Name !!!"); 
	}
	
    public void deleteBookByAuthorName(String authorName) throws AuthorNameNotFoundException {
		
		Book book = findBookByAuthorName(authorName);
		if(null != book)
			bookRepository.delete(book);
		else 
			throw new AuthorNameNotFoundException("Book With Author Name: " + authorName + " Not found in the Stack !!, Please enter Proper Author Name !!!"); 
	}
    
	public void deleteBookByPublishedYear(Integer publishedYear) throws PublishedYearNotFoundException {
		
		Book book = findBookByPublishedYear(publishedYear);
		if(null != book)
		    bookRepository.delete(book);
		else 
			throw new PublishedYearNotFoundException("Book With Published Year: " + publishedYear + " Not found in the Stack !!, Please enter Proper Published Year !!!"); 
	}
	
	public void deleteBookByPrice(Double price) throws PriceNotFoundException {
		
		Book book = findBookByPrice(price);
		if(null != book)
		    bookRepository.delete(book);
		else 
			throw new PriceNotFoundException("Book With price Rs: " + price + " Not found in the Stack !!, Please enter Proper Price details !!!"); 
	}

}
