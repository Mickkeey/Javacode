package base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class CalendarTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String yearSelect = "2027";
		String dateSelect = "15";
		String monthSelect = "6";

		String[] expectedDate = {monthSelect,dateSelect,yearSelect};
		
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		driver.findElement(By.cssSelector(".react-date-picker__inputGroup")).click();
		driver.findElement(By.cssSelector(".react-calendar")).isEnabled();
		
		Actions act = new Actions(driver);
		WebElement headerValue = driver.
				findElement(By.cssSelector(".react-calendar__navigation__label"));
		act.moveToElement(headerValue).doubleClick().build().perform();
		
		
//		driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
//		driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();

		driver.findElement(By.xpath("//button[text()='" +yearSelect+ "']")).click();
		
		driver.findElements(By.cssSelector(".react-calendar__year-view__months__month"))
		.get(Integer.parseInt(monthSelect) - 1).click();
		
		driver.findElement(By.xpath("//abbr[text()='" +dateSelect+ "']")).click();
		
		
		List<WebElement> actualDate = 
				driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));
		
		
		for (int i=0;i<actualDate.size();i++)
		{
			
			String printDate = actualDate.get(i).getAttribute("value");
			System.out.println(printDate);
			Assert.assertEquals(printDate, expectedDate[i]);
			}
		
		driver.quit();
	}

}
