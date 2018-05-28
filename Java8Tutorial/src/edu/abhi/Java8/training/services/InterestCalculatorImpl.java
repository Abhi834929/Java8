package edu.abhi.Java8.training.services;

import edu.abhi.Java8.training.function.InterestCalculator;

public class InterestCalculatorImpl {

	public static void main(String args[]){
		
		InterestCalculator<Double,Double> calc1 = (amount) -> {
			return amount *0.5;
		};
		
		InterestCalculator<Long,Double> calc2 = (amount) -> {
			return amount *0.85;
		};
		
		System.out.println(calc1.calculator(5000.90));
		System.out.println(calc2.calculator(6000L));
	}
	
}
