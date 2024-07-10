package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class selenium4_Relative {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice");
		
		WebElement element = driver.findElement(By.cssSelector("[name='name']"));
		
		System.out.println(driver.findElement(with(By.tagName("label")).above(element)).getText());

		
		WebElement bdayElement = driver.findElement(By.cssSelector("[for='dateofBirth']"));
		driver.findElement(with(By.tagName("input")).below(bdayElement)).click(); 
//		Its not clicking date of birth field because it is flex component not an HTML component,
//		so it will click the next below input component which is Submit button.
		
		WebElement iceCreamClick = driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
		driver.findElement(with(By.tagName("input")).toLeftOf(iceCreamClick)).click();
		
		WebElement rdb = driver.findElement(By.id("inlineRadio1"));
		System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(rdb)).getText());
	}

}
