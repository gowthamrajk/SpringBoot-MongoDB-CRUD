package com.example.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Document(collection = "Book")
public class Book {
	
	@Id
	private Integer bookId;
	private String bookName;
	private String authorName;
	private Integer publishedYear;
	private Double price;

	public Integer getBookId() {
		return bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public String getAuthorName() {
		return authorName;
	}

	public Integer getPublishedYear() {
		return publishedYear;
	}

	public Double getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "Book => ID : " + bookId + ", Book Name : " + bookName 
				+ ", Author Name : " + authorName + ", Published Year : "
				+ publishedYear + ", Price : " + price;
	}
	
}
