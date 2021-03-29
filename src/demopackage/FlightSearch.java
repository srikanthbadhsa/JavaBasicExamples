package demopackage;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class FlightSearch {
	
	static String countryName="ba";
	static String expectedCountryName="bangladesh";
	
	static String expectedCityNmae="Hyderabad (hyd)";
	static String expectedToCityNmae="jodhpur (jdh)";
	
	static String actualCheckBoxText="students";

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\VINOD\\eclipse-workspace\\msedgedriver.exe");
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		
		
		
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		
		//handling auto suggest text
		WebElement autoSuggestLocator=driver.findElement(By.id("autosuggest"));
		autoSuggestLocator.sendKeys(countryName);
		List<WebElement> suggestionsLocator=driver.findElements(By.cssSelector("li.ui-menu-item"));
		Iterator<WebElement>suggestions= suggestionsLocator.iterator();
		while(suggestions.hasNext())
		{
			WebElement countryName=suggestions.next();
			String actualCountryName=countryName.getText();
			if(actualCountryName.equalsIgnoreCase(expectedCountryName))
			{
				countryName.click();
			}
			
		}
		
		//Dynamic dropdown Select Country names of From and To
		driver.findElement(By.cssSelector("[value='Departure City']")).click();
		
		List<WebElement> ulsLocator=driver.findElements(By.xpath("(//div[@class='dropdownDiv'])[1]/ul"));
		Iterator<WebElement>uls=ulsLocator.iterator();
		while(uls.hasNext())
		{
			WebElement ul=uls.next();
			List<WebElement> lisLocator=ul.findElements(By.xpath("(//div[@class='dropdownDiv'])[1]/ul/li"));
			Iterator<WebElement> lis=lisLocator.iterator();
			while(lis.hasNext())
			{
				WebElement li=lis.next();
				String actualCityName=li.getText();
				if(actualCityName.equalsIgnoreCase(expectedCityNmae))
				{
					li.click();
				}
			}
		}
		
		List<WebElement> toUlsLocator=driver.findElements(By.xpath("(//div[@class='dropdownDiv'])[3]/ul"));
		Iterator<WebElement> toUls=toUlsLocator.iterator();
		while(toUls.hasNext())
		{
			WebElement toUl=toUls.next();
			List<WebElement> toLisLocator=toUl.findElements(By.xpath("(//div[@class='dropdownDiv'])[3]/ul/li"));
			Iterator<WebElement> toLis=toLisLocator.iterator();
			while(toLis.hasNext())
			{
				WebElement toLi=toLis.next();
				String actualToCityNmae=toLi.getText();
				if(actualToCityNmae.equalsIgnoreCase(expectedToCityNmae))
				{
					toLi.click();
				}
			}
		}
		
		//Static DropDown
		
		driver.findElement(By.id("divpaxinfo")).click();;		
		WebElement adultsLocator=driver.findElement(By.id("hrefIncAdt"));
		for(int i=1;i<=3;i++)
		{
			adultsLocator.click();
		}
		WebElement childLocator=driver.findElement(By.id("hrefIncChd"));
		for(int i=1;i<=3;i++)
		{
			childLocator.click();
		}
		WebElement infantsLocator=driver.findElement(By.id("hrefIncInf"));
		for(int i=1;i<=3;i++)
		{
			infantsLocator.click();
		}
		
		driver.findElement(By.id("btnclosepaxoption")).click();
		
		//handling Check Boxes
		List<WebElement> listOfCheckBoxesLocator=driver.findElements(By.cssSelector(".tool_info.mobile-tooltip.icon-margin"));
		while(listOfCheckBoxesLocator.iterator().hasNext())
		{
			WebElement checkBoxes=listOfCheckBoxesLocator.iterator().next();
			String actualCheckBoxText=checkBoxes.getText();
			if(actualCheckBoxText.equalsIgnoreCase(actualCheckBoxText))
			{
				checkBoxes.click();
			}
		}
		
		

		
	}

}
