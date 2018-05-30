package edu.abhi.Java8.trainng.exceptionhandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ExceptnHandlingWithJava7 {

	public static void main(String[] args) throws IOException, SQLException {
		oldWayOfReadingFile();

		readingFileWithTryWithResource();

		reThrowExample();
		
		try{
			rethrow("abc");
		}catch(FirstException | SecondException | ThirdException e){
			//below assignment will throw compile time exception since e is final
			//e = new Exception();
			System.out.println(e.getMessage());
		}

	}

	private static void readingFileWithTryWithResource() {
		try (FileReader reader = new FileReader(new File("DataFile"));) {
			reader.read();
			DriverManager.getConnection(null);
		} catch (IOException | SQLException e) {
			System.out.println("Try With Resource way");
			e.printStackTrace();
		}
	}

	private static void oldWayOfReadingFile() {
		FileReader reader = null;
		try {
			reader = new FileReader(new File("DataFile"));
			reader.read();
		} catch (FileNotFoundException e) {
			System.out.println("Old way");
			e.printStackTrace();
		}

		catch (IOException e) {
			System.out.println("Old way");
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				System.out.println("Old way");
				e.printStackTrace();
			}

		}
	}

	private static void reThrowExample() throws IOException, SQLException {
		FileReader reader = null;
		try {
			reader = new FileReader(new File("DataFile"));
			reader.read();
		} /*
			 * catch (FileNotFoundException e) { System.out.println("Old way");
			 * e.printStackTrace(); }
			 */

		catch (Exception e) {
			System.out.println("Old way");
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (Exception e) {
				System.out.println("Old way");
				e.printStackTrace();
			}

		}
	}

	private static void rethrow(String s) throws FirstException, SecondException, ThirdException {
		try {
			if (s.equals("First"))
				throw new FirstException("First");
			else if (s.equals("Second"))
				throw new SecondException("Second");
			else
				throw new ThirdException("Third");
		} catch (Exception e) {
			// below assignment disables the improved rethrow exception type
			// checking feature of Java 7
			// e=new ThirdException();
			throw e;
		}
	}

	static class FirstException extends Exception {

		public FirstException(String msg) {
			super(msg);
		}
	}

	static class SecondException extends Exception {

		public SecondException(String msg) {
			super(msg);
		}
	}

	static class ThirdException extends Exception {

		public ThirdException(String msg) {
			super(msg);
		}
	}

}
