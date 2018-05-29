package edu.abhi.Java8.training.streams;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileHandlingWithStreams {
	public static void main(String[] args) {

		try (Stream<String> dataStream = Files
				.lines(Paths.get("C:\\Users\\Administrator\\workspace\\java8\\Java8Tutorial\\src\\dataFile"));) {
			System.out.println("++++++++++++++Print unique containts in File+++++++++++++++");
			List<String> containts = dataStream.flatMap(line -> Arrays.stream(line.split("\n")))
					.distinct().collect(Collectors.toList());
			containts.forEach(System.err::println);
			System.out.println("++++++++++++++Print count of unique containts in File+++++++++++++++");
			
			Long count = containts.stream().flatMap(line -> Arrays.stream(line.split("\n"))).distinct()
					.count();
			System.out.println("List<String> containts:-"+count);
			Long count1 = dataStream.flatMap(line -> Arrays.stream(line.split("\n"))).distinct()
					.count();
			System.out.println("From dataStream:-"+count1);
		} catch (Exception e) {
			
		}
	}
}
