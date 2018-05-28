package edu.abhi.Java8.training.services;


import java.util.ArrayList;
import java.util.List;

import edu.Java8.training.pojos.Author;
import edu.Java8.training.pojos.Book;

public class BookService {
	
	private List<Book> bookList = new ArrayList<>();

public BookService() {
		this.bookList.add(new Book(101,"HeadFirst To Java",340,"Orelliy",new Author(901,"Kathy Sierra","Kathy@abc.com")));
		this.bookList.add(new Book(101,"HeadFirst To Java 3",340,"Orelliy3",new Author(901,"Kathy Sierra5","Kathy5@abc.com")));
	}

	public List<Book> getAllBooks(){
		return bookList;
	}

}
