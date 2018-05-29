package edu.abhi.Java8.training.services;


import java.util.ArrayList;
import java.util.List;

import edu.Java8.training.pojos.Author;
import edu.Java8.training.pojos.Book;

public class BookService {
	
	private List<Book> bookList = new ArrayList<>();

public BookService() {
		this.bookList.add(new Book(101,"HeadFirst To Java 35",3360,"Pearson",new Author(901,"Kathy Sierra55","Kathy5@abc.com")));
		this.bookList.add(new Book(102,"HeadFirst To Java",300,"Pearson",new Author(901,"Kathy Sierra","Kathy@abc.com")));
		this.bookList.add(new Book(103,"HeadFirst To Java 53",3240,"Orelliy",new Author(901,"Kathy Sie5rra5","Kathy5@abc.com")));
		this.bookList.add(new Book(104,"HeadFirst To Java 3",33,"Orelliy",new Author(901,"Kathy Sie55rra5","Kathy5@abc.com")));
		this.bookList.add(new Book(105,"HeadFirst To Java 33",3443,"Dinesh",new Author(901,"Kathy Sie55rra5","Kathy5@abc.com")));
	}

	public List<Book> getAllBooks(){
		return bookList;
	}
	
	
}
