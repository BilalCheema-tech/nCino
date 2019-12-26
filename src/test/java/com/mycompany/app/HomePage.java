package com.mycompany.app;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
//import org.junit.Test;

import pageObjects.LandingPage;
import pageObjects.ToDoPage;

public class HomePage extends Base {

	@BeforeTest
	public void baseNavigation() throws IOException {
		driver = initializeDriver();
		// WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.get("http://todomvc.com/");
		driver.manage().window().maximize();

	}

	@Test
	public void landingPageTest() {

		// object of landingPage
		LandingPage l = new LandingPage(driver);
		l.clickJavascriptTab().click();
		l.clickPolymerLink().click();
	}

	@Test(priority = 2)
	public void toDoPageTest() throws InterruptedException {
		// object of ToDo Page
		ToDoPage t = new ToDoPage(driver);

		// actions class instance
		Actions action = new Actions(driver);

		action.moveToElement(t.newTodo()).sendKeys("Test").build().perform();
		action.moveToElement(t.newTodo()).sendKeys(Keys.ENTER).build().perform();
		action.moveToElement(t.newTodo()).sendKeys("Test2").build().perform();
		action.moveToElement(t.newTodo()).sendKeys(Keys.ENTER).build().perform();
		action.moveToElement(t.newTodo()).sendKeys(Keys.ENTER).build().perform();

		action.moveToElement(t.todoItem()).sendKeys(Keys.DOWN).build().perform();
		action.moveToElement(t.todoItem()).sendKeys(Keys.DOWN).build().perform();

		action.moveToElement(t.todoItem()).doubleClick().build().perform();

		action.moveToElement(t.editToDoItem()).sendKeys("Edit").build().perform();

	}

	@AfterTest
	public void quitBrowser() {

		driver.quit();
	}

}
