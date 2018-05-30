package edu.abhi.Java8.training.prallelstreams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import edu.Java8.training.pojos.Book;
import edu.Java8.training.pojos.Employee;

public class ReduceExample {

	public static List<Employee> getEmployee() {
		List<Employee> empList = new ArrayList<>();
		empList.add(new Employee("RAKESH", "HR", 100050.00));
		empList.add(new Employee("RAJA", "IT", 560000.00));
		empList.add(new Employee("RABI", "ADMIN", 780000.00));
		empList.add(new Employee("ABHI", "IT", 106660.00));
		empList.add(new Employee("VAMSHI", "TRANS", 1000000.00));
		return empList;

	}

	@SuppressWarnings("rawtypes")
	static Comparator myComparator() {
		System.out.println(Thread.currentThread().getName());
		return Comparator.comparing(Employee::getSalary);
	}

	public static void main(String[] args) {
		Optional<Double> result = getEmployee().parallelStream().filter(e -> e.getDept().equalsIgnoreCase("IT"))
				.map(e -> {
					System.out.println("result: sorted "+Thread.currentThread().getName());
					return e.getSalary();
				}).reduce(Double::sum);
		Optional<Double> result1 = getEmployee().parallelStream().filter(e -> e.getDept().equalsIgnoreCase("IT"))
				.map(e -> e.getSalary()).reduce(Double::sum);

		Double result3 = getEmployee().parallelStream().filter(e -> e.getDept().equalsIgnoreCase("IT"))
				.sorted((e1, e2) -> {
					System.out.println("reult3: sorted " + Thread.currentThread().getName());
					return (int) (e1.getSalary() - e2.getSalary());
				}).map(e -> {
					System.out.println("reult3: map " + Thread.currentThread().getName());
					return e.getSalary();
				}).reduce(0.0, Double::sum);

		Double result4 = getEmployee().parallelStream().filter(e -> e.getDept().equalsIgnoreCase("hr")).map(e -> {
			System.out.println("result4: map " + Thread.currentThread().getName());
			return e.getSalary();
		}).reduce(0.0, Double::sum,(s1,s2)->{
			System.out.println("result4: reduce Cmbiner: " + Thread.currentThread().getName());
			return s1+s2;
		});

		if (result.isPresent()) {
			System.out.println("Total Salary is using result  :" + result);
			System.out.println("Total Salary is using result1 :" + result1);
			System.out.println("Check result3 :" + result3);
			System.out.println("Check result4 :" + result4);
		}
	}
}
