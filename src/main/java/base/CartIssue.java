package base;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CartIssue {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		String[] items = {"Cucumber", "Brocolli", "Beetroot"};
		
		List<WebElement> products = driver.findElements(By.xpath("//h4[@class='product-name']"));
		
		for (int i=0;i<products.size();i++)
		{
			String[] name = products.get(i).getText().split("-");
			
			//Trim it and format it get actual product name
			
			String formattedName = name[0].trim();
			
			// convert array into ArrayList for easy search
			List<String> itemsList = Arrays.asList(items);
			
			int count=0;
			
			// check weather name you extracted is present in Array List or not
			if(itemsList.contains(formattedName))
			{
				count++;
				// click to add cart
				driver.findElements(By.id("//div[@class='product-action']/button")).get(i).click();
				
				if(count==items.length)
				{
					break;
			}
			
		}
	}
	}
}
