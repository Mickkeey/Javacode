package base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StreamDemo {
	
	@Test
	public void regular()
	{
	ArrayList<String> names = new ArrayList<String>();
	names.add("Mohit");
	names.add("Arun");
	names.add("Akhil");
	names.add("RahulRaj");
	names.add("Anil");
	
	System.out.println("Regular Case Result");

	int count=0;
	
	for(int i=0;i<names.size();i++)
	{
		String actualName = names.get(i);
		if(actualName.startsWith("A"))
		{
			count++;
		}
	}
	System.out.println(count);
	}
	
	
	@Test
	public void streamFilter()
	{
		ArrayList<String> names = new ArrayList<String>();
		names.add("Mohit");
		names.add("Arun");
		names.add("Akhil");
		names.add("RahulRaj");
		names.add("Anil");
		System.out.println("Stream Filter Case Result");

//		There is no life of intermediate operation 
//		["actualName -> actualName.startsWith("A")"] if there is no terminal operation "count()"
		
//		Terminal operation will get execute if intermediate operation returns true
		
		Long result = names.stream().filter(actualName -> actualName.startsWith("A")).count();
		System.out.println(result);
	}
	
	@Test
	public void streamInput()
	{
//		we can create stream
//		Filter in stream API 
		Stream.of("Mohit","Arun","Akhil","RahulRaj","Anil")
		.filter(actualName -> actualName.startsWith("A")).count();
	}

	@Test
	public void streamInputConditional()
	{
	Stream.of("Mohit","Arun","Akhil","RahulRaj","Anil")
	.filter(actualName -> 
	{
		actualName.startsWith("A");
	}
	).count();
}
	
//	Print name have letters more than 4
	@Test
	public void streamPrintMoreThan4()
	{
		ArrayList<String> names = new ArrayList<String>();
		names.add("Mohit");
		names.add("Arun");
		names.add("Akhil");
		names.add("RahulRaj");
		names.add("Anil");

		names.stream().filter(actualName -> actualName.length()>4)
		.forEach(actualName -> System.out.println(actualName));
	}
	
//	Print name have letters more than 4 but only 1st result
	@Test
	public void streamPrintMoreThan4Limit()
	{
		ArrayList<String> names = new ArrayList<String>();
		names.add("Mohit");
		names.add("Arun");
		names.add("Akhil");
		names.add("RahulRaj");
		names.add("Anil");

		names.stream().filter(actualName -> actualName.length()>4).limit(1)
		.forEach(actualName -> System.out.println(actualName));
	}

//	Print name which have last letter ends with "j" with UpperCase
	@Test
	public void streamMap() 
	{
		System.out.println("streamMap");

		Stream.of("Mohit","Arun","Akhij","RahulRaj","Anil")
		.filter(actualName -> actualName.endsWith("j"))
		.map(actualName -> actualName.toUpperCase())
		.forEach(actualName -> System.out.println(actualName));;
	}
	
	
//	Print name which have first letter starts with "a" with UpperCase and sorted
	@Test
	public void streamMapSorted() 
	{
		System.out.println("streamMapSorted");

		List<String> names = Arrays.asList("Mohit","Arun","Akhij","RahulRaj","Anil");
		
		names.stream().filter(actualName -> actualName.startsWith("A")).sorted()
		.map(actualName -> actualName.toUpperCase())
		.forEach(actualName -> System.out.println(actualName));
	}

	@Test
	public void sorted() 
	{
		System.out.println("Sorting");

		List<String> names = Arrays.asList("Mohit","Arun","Akhij","RahulRaj","Anil");
		names.stream().sorted().forEach(actualName -> System.out.println(actualName));
	}
	
	@Test
	public void merge() 
	{
		System.out.println("Merge and Sorting");

		List<String> names = Arrays.asList("Mohit","Arun","Akhij","RahulRaj","Anil");
		List<String> newNames = Arrays.asList("Sweta","Shalini","Nidhi","Geeta","Seeta");

		Stream<String> newListName = Stream.concat(names.stream(), newNames.stream());
		newListName.sorted().forEach(actualName -> System.out.println(actualName));
	}
	
	@Test
	public void anyMatch()
	{
		System.out.println("Any Match Name");

		List<String> names = Arrays.asList("Mohit","Arun","Akhij","RahulRaj","Anil");
		Boolean flag = 
				names.stream().anyMatch(actualName -> actualName.equalsIgnoreCase("Anil"));
		Assert.assertTrue(flag);
	}

//	Create new list with name which have last letter ends with "j" with UpperCase
	@Test
	public void createNewOutputList()
	{
		System.out.println("Create New Output List");
		
		List<String> ls = Stream.of("Mohit","Arun","Akhij","RahulRaj","Anil")
		.filter(actualName -> actualName.endsWith("j"))
		.map(actualName -> actualName.toUpperCase()).collect(Collectors.toList());
		System.out.println(ls.get(1));
	}
		
// Print unique number from the Integer list and sorted
	@Test
	public void uniqueSorted()
	{
		System.out.println("Unique and Sorted Integer");
		List<Integer> values = Arrays.asList(1,2,2,5,7,8,1,2,6);
		
		// print unique from array
		values.stream().distinct().forEach(num -> System.out.println(num));
		
		// print unique and sorted from array
		values.stream().distinct().sorted().forEach(num -> System.out.println(num));

//		Another Way of doing 
		List<Integer> li = values.stream().distinct().collect(Collectors.toList());
		System.out.println("Sorted Integer Result");
		li.stream().sorted().forEach(num -> System.out.println(num));

//		Print 3rd integer of unique and sorted array
		System.out.println("3rd integer of unique and sorted array");
		List<Integer> uniqueSorted = values.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(uniqueSorted.get(2));
		
	}
		
}
