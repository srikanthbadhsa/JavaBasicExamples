package demopackage;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class AddItemsGreenKart {

	public static void main(String[] args) {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\VINOD\\eclipse-workspace\\msedgedriver.exe");
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		
		
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		String[] itemsList= {"Beetroot","Cucumber","Cauliflower","Beans"};
		
		List<String> itemsName = Arrays.asList(itemsList);

		
		
		List<WebElement>  listOfItems=driver.findElements(By.cssSelector("h4.product-name"));
		
		for(int i=0;i<listOfItems.size();i++)
		{
			String[] productName=listOfItems.get(i).getText().split("-");
			String formatProductName=productName[0].trim();
			
			//click on Add to Cart
			if(itemsName.contains(formatProductName))
			{
				driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
			}	
			
			
			
		}

	}

	

}
