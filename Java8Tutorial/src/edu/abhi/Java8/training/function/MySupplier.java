package edu.abhi.Java8.training.function;

import edu.Java8.training.pojos.Book;

@FunctionalInterface
public interface MySupplier {
 Book getBook(int bookNumber, String bookName,double ratePerUnit,String publisher);
}
