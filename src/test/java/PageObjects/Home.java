package PageObjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Home {
	WebDriver driver;

	@FindBy(xpath = "//iframe")
	List<WebElement> iframes;

	@FindBy(css = "input[value='radio2']")
	WebElement radio2;

	@FindBy(css = "#dropdown-class-example")
	WebElement dropdown;

	@FindBy(css = "input#autocomplete")
	WebElement suggestionClass;

	@FindBy(css = "#checkBoxOption1")
	WebElement checkBoxOption1;

	@FindBy(css = "#checkBoxOption2")
	WebElement checkBoxOption2;

	@FindBy(css = "#checkBoxOption3")
	WebElement checkBoxOption3;

	public String getMenuItem(String search) {
		return "//div[@class='ui-menu-item-wrapper'][text()='" + search + "']";
	}

	public Home(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	}

	public int getIframeCount() {
		return iframes.size();
	}

	public void clickRadio() {
		radio2.click();
	}

	public void selectSuggestion(String keyword, String item) {
		suggestionClass.sendKeys(keyword);
		WebDriverWait wait = new WebDriverWait(driver, 10000);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(getMenuItem(item)))));
		WebElement suggestion = driver.findElement(By.xpath(getMenuItem(item)));
		(suggestion).click();
	}

	public void selectDropdown(String option) {
		Select select = new Select(dropdown);
		select.selectByVisibleText(option);
	}

	public void checkOptionOne(Boolean state) {
		checkBoxOption1.click();
		WebDriverWait wait = new WebDriverWait(driver, 20000);
		wait.until(ExpectedConditions.elementSelectionStateToBe(checkBoxOption1, state));
		if (state=true) {
			Assert.assertTrue(checkBoxOption1.isEnabled() == true);
		} else {
			Assert.assertTrue(checkBoxOption1.isEnabled() == false);
		}
	}

	public void checkOptionTwo(Boolean state) {
		checkBoxOption2.click();
		WebDriverWait wait = new WebDriverWait(driver, 10000);
		wait.until(ExpectedConditions.elementSelectionStateToBe(checkBoxOption2, state));
		if (state=true) {
			Assert.assertTrue(checkBoxOption2.isEnabled() == true);
		} else {
			Assert.assertTrue(checkBoxOption2.isEnabled() == false);
		}
	}

	public void checkOptionThree(Boolean state) {
		checkBoxOption3.click();
		WebDriverWait wait = new WebDriverWait(driver, 10000);
		wait.until(ExpectedConditions.elementSelectionStateToBe(checkBoxOption3, state));
		if (state=true) {
			Assert.assertTrue(checkBoxOption3.isEnabled() == true);
		} else {
			Assert.assertTrue(checkBoxOption3.isEnabled() == false);
		}
	}
}
