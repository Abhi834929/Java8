package edu.abhi.Java8.training.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import edu.Java8.training.pojos.Book;
import edu.Java8.training.pojos.Student;
import edu.abhi.Java8.training.services.BookService;
import edu.abhi.Java8.training.services.StudentService;

public class UsingStreams {

	public static void main(String[] args) {

		IntStream marks = IntStream.of(45, 65, 67, 77, 89, 90);
		System.out.println("------------Print marks---------------");
		printStream(marks);
		IntStream oddNumbers = IntStream.iterate(1, (i) -> {
			return i + 2;
		}).limit(6);
		System.out.println("\n" + "-----------Print oddNumbers----------");
		printStream(oddNumbers);
		BookService bk = new BookService();
		List<Book> listOfBook = bk.getAllBooks();
		System.out.println("\n" + "---------------Print Costly Book----------------------");
		filerConsumer(listOfBook.stream().filter(book -> book.getRatePerUnit() > 400));
		System.out.println("=========Print Cheap Book=====");
		filerConsumer(listOfBook.stream().filter(book -> book.getRatePerUnit() < 400));
		System.out.println("========Print Orelley Book=========");
		filerConsumer(listOfBook.stream().filter(book -> book.getPublisher().equalsIgnoreCase("Orelliy")));

		Consumer<Stream<Book>> functionPrinter = (Stream) -> {
			Stream.forEach(System.out::println);
		};
		System.out.println("=========Print Cheap Book==========");
		functionPrinter.accept(listOfBook.stream().filter(book -> book.getRatePerUnit() < 400));
		System.out.println("========Popular Book============");
		List<String> popularBook = listOfBook.stream().filter(book -> book.getRatePerUnit() < 400).map((book) -> {
			return book.getBookName();
		}).collect(Collectors.toList());
		System.out.println(popularBook);

		// GetDistinct Books
		System.out.println("++++++++GetDistinct Books+++++");
		List<String> bookName = listOfBook.stream().map(e -> e.getBookName()).distinct().collect(Collectors.toList());
		System.out.println(bookName);

		// Sort Books
		System.out.println("++++++++Sort Books+++++");
		listOfBook.stream().sorted(Comparator.comparing(Book::getRatePerUnit)).forEach(System.out::println);
		System.out.println("++++++++Sort Book Price+++++");
		listOfBook.stream().map(book -> book.getRatePerUnit()).sorted().forEach(System.out::print);
		System.out.println("\n" + "++++++++Sort Books In Reverse+++++");
		listOfBook.stream().sorted(Comparator.comparing(Book::getRatePerUnit).reversed()).forEach(System.out::println);

		// flat Map with peek :- peek is used for debugging takes a consumer as
		// input
		System.out.println("\n" + "++++++++flat Map conversting set to list+++++");
		StudentService student = new StudentService();
		List<Student> listOfStudent = student.getAllStudents();
		List<String> studentList = listOfStudent.stream().map(x -> x.getBook()).peek(System.out::print)
				.flatMap(x -> x.stream()).peek(System.out::print).distinct().peek(System.out::print)
				.collect(Collectors.toCollection(ArrayList::new));
		studentList.forEach(System.out::println);

		System.out.println("\n" + "++++++++total number of bks+++++");
		Long booksCount = listOfBook.stream().count();
		System.out.println(booksCount);

		System.out.println("\n" + "++++++++total number of pearson bks+++++");
		Long booksCount1 = listOfBook.stream().filter(book -> book.getPublisher().equalsIgnoreCase("Pearson")).count();
		System.out.println(booksCount1);

		System.out.println("\n" + "++++++++Max Priced Book+++++");
		Optional<Book> bk1 = listOfBook.stream().max(Comparator.comparing(Book::getBookName));
		if (bk1.isPresent()) {
			System.out.println(bk1.get().getBookName());
		}

		System.out.println("\n" + "++++++++flat Map conversting set to Map+++++");
		Map<String, Double> bookMap = listOfBook.stream()
				.filter(book -> book.getPublisher().equalsIgnoreCase("Pearson"))
				.collect(Collectors.toMap(Book::getBookName, Book::getRatePerUnit));
		bookMap.forEach((k, v) -> {
			System.out.println("BookName is " + k + "Book Price is " + v);
		});

		System.out.println("\n" + "+++++++findFirst,findAny and orElse++++++");
		String result = listOfBook.stream().filter(book -> book.getPublisher().equalsIgnoreCase("Pearson"))
				.map(x -> x.getBookName()).findFirst().orElse("No Data");
		System.out.println(result);

		String result2 = listOfBook.stream().filter(book -> book.getPublisher().equalsIgnoreCase("Pearson2"))
				.map(x -> x.getBookName()).findFirst().orElse("No Data");
		System.out.println(result2);
		
		String result3 = listOfBook.stream().filter(book -> book.getPublisher().equalsIgnoreCase("Orelliy"))
				.map(x -> x.getBookName()).findAny().orElse("No Data");
		System.out.println(result3);
	}

	public static void printStream(IntStream s) {
		s.forEach(System.out::print);
	}

	public static void filerConsumer(Stream<Book> s) {
		s.forEach(System.out::println);
	}

}
