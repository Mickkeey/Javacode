package base;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.asserts.SoftAssert;

import com.google.common.io.Files;

public class Miscellanous {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		
		// maximize the window
		driver.manage().window().maximize();
		
		//Delete all cookies of browser or particular cookie
		driver.manage().deleteAllCookies();
		
//		further steps if question is asked login cookies are deleted or not how to verify, 
//		then cookie delete and then click on any link and it will navigate to home page
		driver.manage().deleteCookieNamed("abcd");
		
		// click on any link 
		// Navigate to Home page
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		
		// Take screenshot
		File src = ((RemoteWebDriver) driver).getScreenshotAs(OutputType.FILE);
		Files.copy(src, new File ("/Users/mohitsharma/Desktop/screenshot.png"));
		
		// 404 page OR broken URL OR broken links 
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
//		String url = driver.findElement(By.cssSelector("a[href*='broken']")).getAttribute("href");
		
		List<WebElement> linkElements = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		
		SoftAssert a = new SoftAssert();  // Soft Assertion, to run code 
//		after code get fails to check other links
		
		for (WebElement linkElement : linkElements)
		
		{
			String url = linkElement.getAttribute("href");
			
		HttpURLConnection connection = (HttpURLConnection)new URL(url).openConnection();
		connection.setRequestMethod("HEAD");
		connection.connect();
		int respCode = connection.getResponseCode();	
		System.out.println(respCode);
		a.assertTrue(respCode<400, "Page is broken "
					+linkElement.getText()+ 
					" with status code as " +respCode);
		
//		Code for Hard Assert 
		
//		if (respCode>400)
//		{
//			System.out.println("Page is broken "
//					+linkElement.getText()+ 
//					" with status code as " +respCode);
//			
//			Assert.assertTrue(false);
//		
//		}
		
		}
		
		a.assertAll(); // To fail the Test case and print the result 
//		which scenarios actually got failed.
		
		driver.quit();
	}

}
