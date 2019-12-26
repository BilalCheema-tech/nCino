package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class LandingPage {

	public WebDriver driver;

	By javascriptTab = By
			.xpath("//div[contains(concat(' ', normalize-space(@class), ' '), ' tab-content flex-auto ')]");
	By polymerLink = By.xpath("//a[contains(@href,'examples/polymer')]");

	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebElement clickJavascriptTab() {

		return driver.findElement(javascriptTab);

	}

	public WebElement clickPolymerLink() {

		return driver.findElement(polymerLink);

	}
}
