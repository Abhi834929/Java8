package edu.abhi.Java8.training.services;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

import edu.Java8.training.pojos.Book;

public class UsingFunction {

	public static void main(String[] args) {
		// Calculate net Price of the Book and quantity and tax @10% and cess 5%
		BookService bookServ = new BookService();
		List<Book> bkLst = bookServ.getAllBooks();

		BiFunction<Double, Integer, Double> basePrice = (rpu, qty) -> {
			return rpu * qty;
		};
		Function<Double, Double> tax = (price) -> {
			return price * 0.1;
		};
		Function<Double, Double> cess = (price) -> {
			return price * 0.05;
		};

		BiFunction<Double, Double, Double> netPrice = (totalPrice, totaltax) -> {
			return totalPrice + totaltax;
		};

		bkLst.forEach((eachBook) -> {
			Double totalprice = basePrice.apply(eachBook.getRatePerUnit(), 3);
			Double totaltax = tax.apply(totalprice) + cess.compose(tax).apply(totalprice);
			System.out.println(netPrice.apply(totaltax, totalprice));
		});

	}
}
