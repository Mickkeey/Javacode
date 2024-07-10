package base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

//@Test
public class Dropddown {

	public static void main(String[] args) throws InterruptedException {

		// TODO Auto-generated method stub

		// System.setProperty("webDriver.chrome.driver", "Path of the driver from your
		// system")
		// WebDriver driver = new FirefoxDriver();

		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		// driver.findElement(By.className("login-btn"));
		System.out.println("Title of the page ==>  " + driver.getTitle());
		System.out.println("URL -->  " + driver.getCurrentUrl());

		// select commands of Dropdown

		WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dropdown = new Select(staticDropdown);
		dropdown.selectByIndex(3);
		dropdown.getFirstSelectedOption().getText();
		dropdown.selectByVisibleText("AED");
		dropdown.getFirstSelectedOption().getText();
		Assert.assertTrue(true, dropdown.getFirstSelectedOption().getText());

		// enter the input and select from dropdown

		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		Thread.sleep(2000);
		List<WebElement> options = driver.findElements(By.xpath("//li[@class='ui-menu-item']/a"));

		for (WebElement option : options) {
			if (option.getText().equalsIgnoreCase("India")) {
				option.click();
				break;
			}
		}
		Thread.sleep(2000);

		// Clicking same element multiple times using loop

		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);
//		int n=1;
//		while (n<5)
//		{
//			driver.findElement(By.id("hrefIncAdt")).click();
//			n++;
//		}
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		for (int n = 1; n < 5; n++) {
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		driver.findElement(By.id("btnclosepaxoption")).click();
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

		// Dynamic DropDown
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='ctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='MAA']"))
				.click();

		// Calendar
		Thread.sleep(2000);

		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();

		// Select CheckBox
		Assert.assertFalse(
				driver.findElement(By.xpath("//input[@id='ctl00_mainContent_chk_SeniorCitizenDiscount']")).isSelected(),
				"Senior Citizen checkbox is selected");
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_chk_SeniorCitizenDiscount']")).click();
		Thread.sleep(2000);
		Assert.assertTrue(
				driver.findElement(By.xpath("//input[@id='ctl00_mainContent_chk_SeniorCitizenDiscount']")).isSelected(),
				"Senior Citizen checkbox is selected");

		// how many checkbox
		Assert.assertEquals(driver.findElements(By.xpath("//input[@type='checkbox']")).size(), 6);

		// Enable or Disable
		Assert.assertTrue(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5"), "Enabled");

		// Radio Button
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();

		// Enable or Disable

//		driver.findElement(By.id("ctl00_mainContent_view_date2")).isEnabled(); ---> we don't use this now because ->
//		mostly in new web sites this boxes are already enabled without selecting the method, 
//		so have to figure which element is getting changed while clicking on the return date box

		Assert.assertTrue(driver.findElement(By.id("Div1")).getAttribute("style").contains("1"), "Enabled");
//		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1"))
//		{
//			System.out.println("Enabled");
//		}
		driver.quit();

	}
}
