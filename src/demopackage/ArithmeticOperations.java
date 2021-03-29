package demopackage;
import java.util.Scanner;

public class ArithmeticOperations {
	Scanner input=new Scanner(System.in);
	int firstValue=input.nextInt();
	int secondValue=input.nextInt();
	Float value1=input.nextFloat();
	Float value2=input.nextFloat();
	int sum;
	int result=0;
	public void SquareOfNumber()
	{
		System.out.println(firstValue*firstValue);
	}

	public void cubeOfANumber() {
		System.out.println(firstValue*firstValue*firstValue);
		
	}
	
	public void sumOfEveneNumber()
	{
		for(int i=1;i<=firstValue;i++)
		{
			sum=2*i;
			result=result+sum;
			System.out.println(sum);
		}
		System.out.println("sum of even numbers:"+result);
	}
	
	public void sumOfOddNumber()
	{
		for(int i=1;i<=firstValue;i++)
		{
			sum=2*i-1;
			result=result+sum;
			System.out.println(sum);
		}
		System.out.println("Sum of odd number:"+result);
	}
	
	public void productOfNumbers()
	{
		System.out.println("product of numbers:"+firstValue*secondValue);
	}
	
	public void productOfDoblueValues()
	{
		System.out.println("product of double values:"+value1*value2);
	}
	public static void main(String[] args) {
		
		
		ArithmeticOperations ao=new ArithmeticOperations();
		System.out.println("---------------------------------");
		ao.SquareOfNumber();
		System.out.println("---------------------------------");
		ao.cubeOfANumber();
		System.out.println("---------------------------------");
		ao.sumOfEveneNumber();
		System.out.println("---------------------------------");
		ao.sumOfOddNumber();
		System.out.println("---------------------------------");
		ao.productOfNumbers();
		System.out.println("---------------------------------");
		ao.productOfDoblueValues();
		System.out.println("---------------------------------");
		
		

	}

}
