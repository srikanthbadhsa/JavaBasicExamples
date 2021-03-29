package demopackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringReverse {
	static Scanner text=new Scanner(System.in);
	static String enterText=text.nextLine();

	public void singleStringReverse()
	{
		int n=enterText.length();
		
		for(int i=n-1;i>=0;i--)
		{
			System.out.print(enterText.charAt(i));
		}
	}
	
	public void multipleStringReverse()
	{
		List l=new ArrayList();
		l.add("vinodkumar");
		l.add("srikanth");
		l.add("shivagajjala");
		System.out.println(l);
		
		int size=l.size();
		System.out.println("array size:"+size);
	for(int i=0;i<size;i++)
		{
			String name1=(String) l.get(i);
			int length1=name1.length();
			char c='\0';
			for(int j=length1-1;j>=0;j--)
			{
				c=(char) (c+name1.charAt(j));
			}
	
		}
	}
	public static void main(String[] args) {
		
		StringReverse reverse=new StringReverse();
		System.out.println("---------------------------");
		reverse.singleStringReverse();
		System.out.println("---------------------------");
		reverse.multipleStringReverse();
		

	}

}
