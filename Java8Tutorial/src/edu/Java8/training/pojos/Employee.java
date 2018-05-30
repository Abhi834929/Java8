package edu.Java8.training.pojos;

public class Employee {

	private String empName;
	private String dept;
	private Double salary;
	
	public Employee(String empName, String dept, Double salary) {
		this.empName = empName;
		this.dept = dept;
		this.salary = salary;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}
}
