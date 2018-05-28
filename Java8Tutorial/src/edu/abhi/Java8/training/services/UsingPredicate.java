package edu.abhi.Java8.training.services;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

import edu.Java8.training.pojos.Book;

public class UsingPredicate {
	
	public static void printBook(Book bk,Predicate<Double> predicate1){
		if(predicate1.test(bk.getRatePerUnit())){
			System.out.println(bk);
		}
	}
	public static void main(String[] args) {
		Predicate<Double> predicate =(price)->{return price<400.00;};
		Predicate<Double> predicate1 =(price)->{return price>800.00;};
		BookService service = new BookService();
		List<Book> bkList=service.getAllBooks();
		System.out.println("Cheaper Book");
		bkList.forEach((eachBook)->{
			if(predicate.test(eachBook.getRatePerUnit())){
				System.out.println(eachBook);
			}
		});
		
		System.out.println("Costly Book");
		BiConsumer<Book,Predicate<Double>> bk = UsingPredicate::printBook;
		bkList.forEach((eachBook)->{
		bk.accept(eachBook, predicate1);
		});
		
		Predicate<String> oreliyPublisherPredicate=(publisher)->{
			return publisher.toLowerCase().equalsIgnoreCase("Orelliy");
		};
		Predicate<String> sambaPublisherPredicate=(publisher)->{
			return publisher.equalsIgnoreCase("Samba");
		};
		System.out.println("Predicate test Book");
		bkList.forEach((eachBook)->{
			if(oreliyPublisherPredicate.or(sambaPublisherPredicate).test(eachBook.getPublisher())){
				System.out.println(eachBook);
			}
			else{
				System.out.println("No Match Found");
			}
		});
	}

}
