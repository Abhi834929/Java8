package edu.abhi.Java8.training.services;

import java.util.List;

import edu.Java8.training.pojos.Book;
import edu.abhi.Java8.training.function.MySupplier;

public class TestJava8 {

	public static void main(String[] args) {
		
		BookService service = new BookService();
		List<Book> bookList = service.getAllBooks();

		// Old way
		for (Book bk : bookList) {
			System.out.println(bk);
		}
		System.out.println("++++++++++++++++++++JAVA 8 WAY+++++++++++++++++");
		// Java 8 way
		bookList.forEach((e) -> {
			System.out.println(e);
		});
		System.out.println("++++++++++++++++++++JAVA 8 Method Reference+++++++++++++++++");
		//Method Reference
		bookList.forEach(
			System.out::println
		);
		bookList.forEach(
				System.err::println
			);

		MySupplier supplier = (bookNum, bookName, price, publisher) -> {
			return new Book(bookNum, bookName, price, publisher);
		};
		
		System.out.println("++++++++++++++++++++JAVA 8 Own Functional Interface+++++++++++++++++");
		System.out.println(supplier);// supplier is the lambda expression implementing functional interface.
		Book anyBook =supplier.getBook(101, "ABCD", 230, "abc");
		System.out.println(anyBook.getBookName());
		
	}

}
