package base;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StreamLiveDemo {

	@Test
	public static void SortFoodCart() 
	{			
			WebDriver driver = new ChromeDriver();
			driver.get("https://rahulshettyacademy.com/greenkart/#/offers");
			
			// Click on column to get sorted result
			driver.findElement(By.xpath("//tr/th[1]")).click();
			
			// Capture all the WebElement into the list
			List<WebElement> orginalList = driver.findElements(By.xpath("//tr//td[1]"));
			
			// Get text of all the WebElement and from the original list
			List<String> textOriginalList = orginalList.stream().
					map(text -> text.getText()).collect(Collectors.toList());
			
//			Sort on the original list of step 3 -> Sorted List
			List<String> sortedOriginalList = textOriginalList.
					stream().sorted().collect(Collectors.toList());
			
//			Comparing original list with sorted list
			Assert.assertEquals(textOriginalList, sortedOriginalList);
			Assert.assertTrue(textOriginalList.equals(sortedOriginalList));
			driver.quit();
	}
	
	@Test
	public static void veggiePrice()
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/greenkart/#/offers");
		List<WebElement> orginalList = driver.findElements(By.xpath("//tr//td[1]"));
		List<String> vegPrice = orginalList.stream().filter(veg -> veg.getText()
		.contains("Beans")).map(veg -> getVegPrice(veg)).collect(Collectors.toList());
		
		vegPrice.forEach(price -> System.out.println(price));
		driver.quit();
	}
	
	// if the product didn't found on 1st list of vegetable, do the pagination until you get it
	@Test
	public static void pagination()
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/greenkart/#/offers");
		
		List<String> vegPrice;
		
		do 
		{
			List<WebElement> orginalList = driver.findElements(By.xpath("//tr//td[1]"));
			
			vegPrice = orginalList.stream().filter(veg -> veg.getText()
			.contains("Beans")).map(veg -> getVegPrice(veg)).collect(Collectors.toList());
			
			vegPrice.forEach(price -> System.out.println(price));
			
			if(vegPrice.size()<1)
				{
					driver.findElement(By.cssSelector("[aria-label='Next']")).click();
				}
		} while(vegPrice.size()>1);
		
		driver.quit();
	}
	
	public static String getVegPrice(WebElement veg)
	{
		String priceValue = veg.findElement(By.xpath("following-sibling::td[1]")).getText();
		return priceValue;
	}
	
	@Test
	public static void searchVeggies()
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/greenkart/#/offers");
		
		driver.findElement(By.id("search-field")).sendKeys("Rice");
		List<WebElement> veggiesList = driver.findElements(By.xpath("//tr/td[1]"));
		List<WebElement> filteredList = veggiesList.stream().filter(veg -> veg.getText().contains("Rice"))
		.collect(Collectors.toList());
		
		Assert.assertEquals(veggiesList, filteredList);
	}
	
}
