package com.bridgelabz;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class StreamOperationWithHashSet {

	public static void main(String[] args) {
		
		Set<Integer> set = new HashSet<Integer>(Arrays.asList(2,3,4,5,6,6,7,9,10,7));
		 // Duplicate elements are not printed in a set.
        System.out.println(set);
        
        /* count the number of elements in set */
		long count = set.stream().count();
		System.out.println(count);
		
        /* deriving list of even numbers using filter()  and Collect() */
		
		List<Integer> evenSet = set.stream().filter(t->t%2==0).sorted().collect(Collectors.toList());
		System.out.println("Derived LinkedList of Even numbers in Ascending order is : "+set);
		
        /* squaring list elements into even numbers using map() and printing using forEach() */
		
		System.out.println("Square of every elements: ");
		set.stream().map(t->t*t).forEach(t->System.out.print(t+" "));
		
		/*sum of element using reduce()*/
		
		int elementSum = set.stream().reduce(0,(sum,i)->sum+i);
		System.out.println("\nSum of every elements in Set: "+elementSum);

		/* finding max and min using selfmade comparator */
		
		System.out.println("maximum elements of list : "+set.stream().max(new MyComparator()));

	}

}
