package base;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

public class Selenium4_WindowHandle {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice");
		
		driver.switchTo().newWindow(WindowType.TAB);
//		driver.switchTo().newWindow(WindowType.WINDOW);

		Set<String> handle = driver.getWindowHandles();
		Iterator<String> it = handle.iterator();
		String parentWindowId = it.next();
		String childWindowId = it.next();
		
		driver.switchTo().window(childWindowId);
		
		driver.get("https://rahulshettyacademy.com/");
		String urlText = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']"))
		.get(1).getText();
		
		driver.switchTo().window(parentWindowId);
		WebElement name = driver.findElement(By.cssSelector("[name='name']"));
		name.sendKeys(urlText);

//      Get screenshot of Particular Element not whole page	
//		Import File Utils instead of Files while doing it, we have import it
		File file = name.getScreenshotAs(OutputType.FILE);
		Files.copy(file, new File("/Users/mohitsharma/Desktop/logo.png"));
		
//      Get height,width of Particular Element	
		System.out.println(name.getRect().getDimension().getHeight());
		System.out.println(name.getRect().getDimension().getWidth());

		driver.quit();
	}
}
