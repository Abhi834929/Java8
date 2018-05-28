package edu.abhi.Java8.training.function;

//T refers to input or target and R refers to return value.
public interface InterestCalculator<T,R> {
	
	R calculator(T amount);

}
