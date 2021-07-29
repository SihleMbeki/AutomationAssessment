package Automation.TestAutomation.testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import PageObjects.Home;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AppTest {
	WebDriver driver;

	@Test
	public void test() {
		WebDriverManager.chromedriver().config();
		driver = new ChromeDriver();
		Home home = new Home(driver);
		Assert.assertTrue(home.getIframeCount() > 0);
		home.clickRadio();
		home.selectSuggestion("South", "South Africa");
		home.selectDropdown("Option3");
		home.checkOptionTwo(true);
		home.checkOptionThree(true);
		home.checkOptionTwo(false);
		home.checkOptionOne(true);
	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
//			driver.close();
		}
	}

}
