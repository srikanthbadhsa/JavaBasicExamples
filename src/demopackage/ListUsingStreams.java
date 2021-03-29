package demopackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

public class ListUsingStreams {
	@Test
	public void test()
	{
		ArrayList<String> names=new ArrayList<String>();
		names.add("mahesh");
		names.add("vinod");
		names.add("kumar");
		names.add("srikanth");
		names.add("aravind");
		names.add("shiva");

		int count=0;

		for(int i=0;i<names.size();i++)
		{
			String name=names.get(i);
			if(name.startsWith("s"))
			{
				count++;
				System.out.println(name);
			}
			
		}
		System.out.println(count);
	}
	
	

}
