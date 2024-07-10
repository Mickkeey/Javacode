package base;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Random {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		
		// count no of links on the page 
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		
		// find the count of links on footer section of the page
		// we achieve it by decreasing the scope of driver element
		
		WebElement footerDriver = driver.findElement(By.id("gf-BIG"));  // limiting web driver scope
		System.out.println(footerDriver.findElements(By.tagName("a")).size());
		
		WebElement columnDriver = 
				footerDriver.findElement(By.xpath("//table//tr/td[1]/ul"));  
		//scope limited to one column of footer
		System.out.println(columnDriver.findElements(By.tagName("a")).size());
		int len = columnDriver.findElements(By.tagName("a")).size();
		
		List<WebElement> footerLinks = columnDriver.findElements(By.tagName("a"));
		
		// click on each link of footer column and check if page is opening [open all pages]
		for (int i=1;i<len;i++)
		{
			String clickOnLink = Keys.chord(Keys.COMMAND,Keys.ENTER);
			footerLinks.get(i).sendKeys(clickOnLink);
			Thread.sleep(2000);
		}
		
		// Print title of all pages
		Set<String> st = driver.getWindowHandles();
		Iterator<String> it = st.iterator();
		
		while(it.hasNext())
		{
			
		driver.switchTo().window(it.next());
		System.out.println(driver.getTitle());
		
		}
		driver.quit();
	}
}
