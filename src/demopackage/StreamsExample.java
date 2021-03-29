package demopackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class StreamsExample {
	
	//@Test(priority=1)
	public void test1()
	{
		ArrayList<String> names=new ArrayList<String>();	
		names.add("vinod");
		names.add("shiva");
		names.add("vinay");
		names.add("laxmi");
		names.add("srikanth");
		names.add("vikram");
		int count=0;
	for(int i=0;i<names.size();i++)
	{
		String actualNmae=names.get(i);
		if(actualNmae.startsWith("v"))
		{
			count++;
		}
	}
	System.out.println(count);
	}
	
	//@Test(priority=2)
	public void test2()
	{
		ArrayList<String> names=new ArrayList<String>();
		names.add("vinod");
		names.add("shiva");
		names.add("vinay");
		names.add("laxmi");
		names.add("srikanth");
		names.add("vikram");
		
		Long countValue=names.stream().filter(s->s.startsWith("v")).count();
		System.out.println(countValue);
		
	}

	//@Test(priority=3)
	public void test3()
	{
		Long c=Stream.of("vinod","vikram","srikanth","vishal","santhosh","vishal").filter(s->s.startsWith("v")).count();
		System.out.println(c);
		
		
	}
	//@Test(priority=4)
	public void test4()
	{
		ArrayList<String> names=new ArrayList<String>();	
		names.add("vinod1");
		names.add("shiva");
		names.add("vinay4");
		names.add("laxmi");
		names.add("srikanth");
		names.add("vikram");
		//names.stream().filter(s->s.length()>5).forEach(s->System.out.println(s));
		names.stream().filter(s->s.length()>5).limit(2).forEach(s->System.out.println(s));
	}
	
	//@Test(priority=5)
	public void map()
	{
		//Stream.of("vinod","vikram","srikanth","vimal","santhosh","vishal").filter(s->s.endsWith("l")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		//print names in sorted order
		Stream.of("vinod","vikram","srikanth","vzimal","santhosh","vishal").sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
	}
	
	//@Test(priority=6)
	public void mergeLists()
	{
		ArrayList<String> names=new ArrayList<String>();	
		names.add("vinod1");
		names.add("shiva");
		names.add("vinay4");
		names.add("laxmi");
		names.add("srikanth");
		names.add("vikram");
		
		List<String> name1=Arrays.asList("super","man","power");
		
		Stream<String> newStream=Stream.concat(names.stream(), name1.stream());
		boolean b=newStream.anyMatch(s->s.equalsIgnoreCase("vinod12"));
		Assert.assertTrue(b);
		System.out.println(b);	
		
	}
	@Test
	public void collectors()
	{
		List<String> name1=Arrays.asList("super","man","power","pawan","pasha").stream().filter(s->s.startsWith("p")).map(s->s.toUpperCase()).collect(Collectors.toList());
		System.out.println(name1);
		System.out.println(name1.get(1));
		
		List<Integer> values=Arrays.asList(8,5,8,2,5,1,5,3,8,5,3,0,3);
		List printValues=values.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(printValues);
		System.out.println(printValues.get(4));
	}
}

