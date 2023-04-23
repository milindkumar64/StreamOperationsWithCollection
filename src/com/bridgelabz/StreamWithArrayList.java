package com.bridgelabz;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*creating MyComparator to compare elements */
class MyComparator<Integer> implements Comparator<Integer>{

	@Override
	public int compare(Integer I1, Integer I2) {
		int i1 = (int) I1;
		int i2 = (int) I2;
		if(i1>i2)
		return +1;
		if(i1<i2)
			return -1;
		else
			return 0;
	}
	
}

public class StreamWithArrayList {	

	public static void main(String[] args) {
		
		ArrayList<Integer> al = new ArrayList<>(Arrays.asList(2,3,4,5,6,6,7,9,10,7));
		System.out.println("primary ArrayList: "+al);
		
		/* count the number of elements in ArrayList */
		long count = al.stream().count();
		System.out.println(count);
		
		/* deriving list of distinct numbers using distinct()  and Collect() */
		
		List<Integer> dictinctList = al.stream().distinct().collect(Collectors.toList());
		System.out.println("Distinct List: "+dictinctList);

		/* deriving list of even numbers using filter()  and Collect() */
		
		List<Integer> evenList = dictinctList.stream().filter(t->t%2==0).sorted().collect(Collectors.toList());
		System.out.println("Derived ArrayList of Even numbers in Ascending order is : "+evenList);
		
		/* squaring list elements into even numbers using map() and printing using forEach() */
		
		System.out.println("Square of every elements: ");
		dictinctList.stream().map(t->t*t).forEach(t->System.out.print(t+" "));
		
		/*sum of element using reduce()*/
		
		int elementSum = dictinctList.stream().reduce(0,(sum,i)->sum+i);
		System.out.println("\nSum of every elements in arrayList: "+elementSum);

		/* finding max and min using selfmade comparator */
		
		System.out.println("maximum elements of list : "+dictinctList.stream().max(new MyComparator()));
		
		// Consumer to multiply 2 to every integer of a list
        Consumer<List<Integer> > modify = list ->
        {
            for (int i = 0; i < list.size(); i++)
                list.set(i, 2 * list.get(i));
        };
        // Consumer to multiply 2 to every integer of a list
        modify.accept(dictinctList);
        System.out.println(dictinctList);
        
        // Consumer to display a list of integers
        Consumer<List<Integer> >
        dispList = list -> list.stream().forEach(a -> System.out.print(a + " "));
        System.out.println("After *2 and printing using forEach");
        modify.andThen(dispList).accept(dictinctList);
	}

}
