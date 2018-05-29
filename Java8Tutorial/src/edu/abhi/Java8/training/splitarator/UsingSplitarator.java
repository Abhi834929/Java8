package edu.abhi.Java8.training.splitarator;

import java.util.List;
import java.util.Spliterator;

import edu.Java8.training.pojos.Book;
import edu.abhi.Java8.training.services.BookService;

public class UsingSplitarator {
	public static void main(String[] args) {
		BookService bk = new BookService();
		List<Book> listOfBook = bk.getAllBooks();
		
		Spliterator<Book> itrOne = listOfBook.spliterator();
		System.out.println("===========tryAdvance in Spliterator===========");
		System.out.println("size of itrOne :" + itrOne.estimateSize());
		itrOne.tryAdvance(System.out::println);

		System.out.println("===========forEachRemaining in Spliterator===========");
		itrOne.forEachRemaining(System.out::println);
		
		System.out.println("===========trySplit in Spliterator===========");
		Spliterator<Book> itrtwo = listOfBook.spliterator();
		Spliterator<Book> itr3 = itrtwo.trySplit();
		Spliterator<Book> itr4 = itr3.trySplit();
		// inside the lambda can create further stream and process the,
		System.out.println("size of itr2 :" + itrtwo.estimateSize());
		if (itrtwo != null) {
			System.out.println("from itr3 :");
			itrtwo.forEachRemaining(n -> System.out.println(n));
		}
		if (itr3 != null) {
			System.out.println("size of itr3 :" + itr3.estimateSize());
			System.out.println("from itr3 :");
			itr3.forEachRemaining(System.out::println);
		}

		if (itr4 != null) {
			System.out.println("size of itr4 :" + itr4.estimateSize());
			System.out.println("from itr4 :");
			itr4.forEachRemaining(System.out::println);
		}

	}

}