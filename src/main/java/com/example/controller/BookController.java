package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.exception.AuthorNameNotFoundException;
import com.example.exception.BookIdNotFoundException;
import com.example.exception.BookNameNotFoundException;
import com.example.exception.DuplicateBookException;
import com.example.exception.PriceNotFoundException;
import com.example.exception.PublishedYearNotFoundException;
import com.example.model.Book;
import com.example.service.BookService;

@RestController
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	private String message = "";
	
	@PostMapping("/savebook")
	public String saveBook(@RequestBody Book book) {
		
		try {
		    bookService.saveBook(book);
		    return "Book with ID : " + book.getBookId() + " successfully added to the stack !!!";
		}
		catch(DuplicateBookException duplicateBookException) {
			return duplicateBookException.getMessage();
		}
	}
	
	@GetMapping("/getAllBooks")
	public List<Book> getAllBooks() {
		
		return bookService.getAllbooks();
	}
	
	@PutMapping("/updateBook")
    public String updateBook(@RequestBody Book book) {
		
		try {
		    bookService.updateBook(book);
		    return "Book with ID : " + book.getBookId() + " updated successfully !!!";
		}
		catch(BookIdNotFoundException bookIdNotFoundException) {
			return bookIdNotFoundException.getMessage();
		}
	}
	
	@GetMapping("/findBookById/{bookId}")
	public String findBookById(@PathVariable Integer bookId) {
		
		Book bookObj = bookService.findBookById(bookId);
		if(null != bookObj)
			message = "Book details with ID: " + bookId + " is displayed below...\n" + bookObj;
		else
			message = "Book details with ID: " + bookId + " not found in the database !!!";
		return message;
	}
	
	@GetMapping("/findBookByBookName/{bookName}")
	public String findBookByBookName(@PathVariable String bookName) {
		
		Book bookObj = bookService.findBookByBookName(bookName);
		if(null != bookObj)
		    message = "Book details with Book Name: " + bookName + " is displayed below...\n" + bookObj;
		else
			message = "Book details with Book Name: " + bookName + " not found in the database !!!";
		return message;
	}
	
	@GetMapping("/findBookByAuthorName/{authorName}")
	public String findBookByAuthorName(@PathVariable String authorName) {
		
		Book bookObj = bookService.findBookByAuthorName(authorName);
		if(null != bookObj)
		    message = "Book details with Author Name: " + authorName + " is displayed below...\n" + bookObj;
		else
			message = "Book details with Author Name: " + authorName + " not found in the database !!!";
		return message;
	}
	
	@GetMapping("/findBookByPublishedYear/{publishedYear}")
	public String findBookByPublishedYear(@PathVariable Integer publishedYear) {
		
		Book bookObj = bookService.findBookByPublishedYear(publishedYear);
		if(null != bookObj)
		    message = "Book details with Published Year: " + publishedYear + " is displayed below...\n" + bookObj;
		else
			message = "Book details with Published Year: " + publishedYear + " not found in the database !!!";
		return message;
	}
	
	@GetMapping("/findBookByPrice/{price}")
	public String findBookByPrice(@PathVariable Double price) {
		
		Book bookObj = bookService.findBookByPrice(price);
		if(null != bookObj)
		    message = "Book details with Price Rs: " + price + " is displayed below...\n" + bookObj;
		else
			message = "Book details with Price Rs: " + price + " not found in the database !!!";
		return message;
	}
	
	@DeleteMapping("/deleteBookById/{bookId}")
	public String deleteBookById(@PathVariable Integer bookId) {
		
		try {
		    bookService.deleteBookById(bookId);
		    return "Book with ID: " + bookId + " successfully deleted !!!";
		}
		catch(BookIdNotFoundException bookIdNotFoundException) {
			return bookIdNotFoundException.getMessage();
		}
	}
	
	@DeleteMapping("/deleteBookByBookName/{bookName}")
	public String deleteBookByBookName(@PathVariable String bookName) {
		
		try {
		    bookService.deleteBookByName(bookName);
		    return "Book with Name: " + bookName + " successfully deleted !!!";
		}
		catch(BookNameNotFoundException bookNameNotFoundException) {
			return bookNameNotFoundException.getMessage();
		}
	}
	
	@DeleteMapping("/deleteBookByAuthorName/{authorName}")
	public String deleteBookByAuthorName(@PathVariable String authorName) {
		
		try {
		    bookService.deleteBookByAuthorName(authorName);
		    return "Book with Author Name: " + authorName + " successfully deleted !!!";
		}
		catch(AuthorNameNotFoundException authorNameNotFoundException) {
			return authorNameNotFoundException.getMessage();
		}
	}
	
	@DeleteMapping("/deleteBookByPublishedYear/{publishedYear}")
	public String deleteBookByPublishedYear(@PathVariable Integer publishedYear) {
		
		try {
		    bookService.deleteBookByPublishedYear(publishedYear);
		    return "Book with Published Year: " + publishedYear + " successfully deleted !!!";
		}
		catch(PublishedYearNotFoundException publishedYearNotFoundException) {
			return publishedYearNotFoundException.getMessage();
		}
	}
	
	@DeleteMapping("/deleteBookByPrice/{price}")
	public String deleteBookByPrice(@PathVariable Double price) {
		
		try {
		    bookService.deleteBookByPrice(price);
		    return "Book with Price Rs: " + price + " successfully deleted !!!";
		}
		catch(PriceNotFoundException priceNotFoundException) {
			return priceNotFoundException.getMessage();
		}
	}

}