package edu.abhi.Java8.training.services;

import java.util.function.BiFunction;

import edu.Java8.training.pojos.Book;
import edu.abhi.Java8.training.function.MySupplier;

public class UsingBiFunction {

	public static void main(String[] args) {
		//Lambda Way
		BiFunction<Integer, Integer, Integer> result = (first, second) -> {
			return first + second;
		};

		/**
		 * Method Reference Reference to an instance method of a particular object
		 * Syntax :-instance::instanceMethod
		 * Method Reference:calculate::add;	
		 * lambda expression:  () -> (first, second) -> {return first + second;};
		 */
		
		Calculate calculate = new Calculate();
		BiFunction<Integer, Integer, Integer> result1 = calculate ::add;
		System.out.println("++++++++++++++Test Lambda++++++++");
		System.out.println(result.apply(15, 20));
		System.out.println("++++++++++++++Test Method Reference++++++++");
		System.out.println(result1.apply(15, 205));
		
		
		MySupplier supplier = Book::new;
		Book book =supplier.getBook(101, "ABCD", 230, "abc");
		System.out.println(book);
	}
}

class Calculate {
	public Integer add(Integer a, Integer b) {
		return a + b;
	}
}