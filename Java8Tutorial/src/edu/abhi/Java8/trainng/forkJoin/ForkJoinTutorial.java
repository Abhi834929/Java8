package edu.abhi.Java8.trainng.forkJoin;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * search an element in a sorted array ->Binary Search algorithm Step 1: First
 * we split the array and determine the mid element of the array . Step 2: Check
 * searchable element is equal to mid element. If it is equal, then return the
 * element ,as it is found in the array. Step 3: If the element is less than mid
 * element then we create a new subtask, in this sub-task, we take left half of
 * the array. Step 4: If the element is greater than mid element then we create
 * a new subtask ,in this sub-task ,we take right half of the array. Step 5:
 * Until element is not found continue the step 4 and 5. Step 6: If the array
 * size is 1 and elements are not equal to that element. Return status as Not
 * Found.
 * 
 * @author Administrator
 *
 */
public class ForkJoinTutorial extends RecursiveTask<Boolean>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int[] arr;
    int searchableElement;
    
    ForkJoinTutorial(int[] arr,int search)
    {
           this.arr = arr;
           this.searchableElement=search;
    }

    public static void main(String[] args) {
		BinarySearch search = new BinarySearch();
		search.createForJoinPool(10);
		System.out.println("**********************");
		search.createForJoinPool(104);
	}
    
    
	@Override
	protected Boolean compute() {
		int mid=( 0 + arr.length)/2;
        System.out.println(Thread.currentThread().getName() + " says : After splliting the arry length is :: "+ arr.length + " Midpoint is " + mid);
        if(arr[mid]==searchableElement)
        {
               System.out.println(" FOUND !!!!!!!!!");
               return true;
        }
        else if(mid==1||mid == arr.length)
        {
               System.out.println("NOT FOUND !!!!!!!!!");
               return false;
        }
        else if(searchableElement < arr[mid])
        {
               System.out.println(Thread.currentThread().getName() + " says :: Doing Left-search");
               int[] left = Arrays.copyOfRange(arr, 0, mid);
               ForkJoinTutorial forkTask = new ForkJoinTutorial(left,searchableElement);
               forkTask.fork();
               return forkTask.join();
        }
        else if(searchableElement > arr[mid])
        {
               System.out.println(Thread.currentThread().getName() + " says :: Doing Right-search");
               int[] right = Arrays.copyOfRange(arr, mid, arr.length);
               ForkJoinTutorial forkTask = new ForkJoinTutorial(right,searchableElement);
               forkTask.fork();
               return forkTask.join();
        }            
        return false;
	}

}

class BinarySearch {
	int[] arr = new int[100];

	public BinarySearch() {
		init();
	}

	private void init()
    {
           for(int i = 0 ; i<arr.length;i++)
           {
                  arr[i]=i;
           }             
           Arrays.sort(arr);
    }

	public void createForJoinPool(int search) {
		ForkJoinPool forkJoinPool = new ForkJoinPool(50);
		ForkJoinTutorial searcher = new ForkJoinTutorial(this.arr, search);
		Boolean status = forkJoinPool.invoke(searcher);
		System.out.println(" Element ::" + search + " has been found in array? :: " + status);
	}
}
