package com.bridgelabz;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class StreamOperationWithQueue {

	public static void main(String[] args) {
		
        Queue<Integer> queue = new PriorityQueue<>((Arrays.asList(2,3,4,5,6,6,7,9,10,7)));
        System.out.println(queue);
		
        /* count the number of elements in Queue */
		long count = queue.stream().count();
		System.out.println(count);
		
		/* deriving Queue of distinct numbers using distinct()  and Collect() */
		List<Integer> dictinctQueue = queue.stream().distinct().collect(Collectors.toList());
		System.out.println("Distinct queue: "+dictinctQueue);
		
        /* deriving Queue of even numbers using filter()  and Collect() */
		
		List<Integer> evenList = dictinctQueue.stream().filter(t->t%2==0).sorted().collect(Collectors.toList());
		System.out.println("Derived queue of Even numbers in Ascending order is : "+evenList);
		
        /* squaring list elements into even numbers using map() and printing using forEach() */
		
		System.out.println("Square of every elements: ");
		dictinctQueue.stream().map(t->t*t).forEach(t->System.out.print(t+" "));
		
		/*sum of element using reduce()*/
		
		int elementSum = dictinctQueue.stream().reduce(0,(sum,i)->sum+i);
		System.out.println("\nSum of every elements in queue: "+elementSum);

		/* finding max and min using selfmade comparator */
		
		System.out.println("maximum elements of queue : "+dictinctQueue.stream().max(new MyComparator()));
		
		// Consumer to multiply 2 to every integer of a queue
        Consumer<List<Integer> > modify = list ->
        {
            for (int i = 0; i < list.size(); i++)
                list.set(i, 2 * list.get(i));
        };
        // Consumer to multiply 2 to every integer of a queue
        modify.accept(dictinctQueue);
        System.out.println(dictinctQueue);
        
        // Consumer to display a queue of integers
        Consumer<List<Integer> >
        dispList = list -> list.stream().forEach(a -> System.out.print(a + " "));
        System.out.println("After *2 and printing using forEach");
        modify.andThen(dispList).accept(dictinctQueue);

	}

}
