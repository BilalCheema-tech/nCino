package com.mycompany.app;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.Keys;

import org.openqa.selenium.interactions.Actions;

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

		driver.get(prop.getProperty("url"));
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

		// Add first todo item

		String testData = prop.getProperty("testData");
		action.moveToElement(t.newTodo()).sendKeys(testData).build().perform();

		assertEquals(testData, "Hi");

		action.moveToElement(t.newTodo()).sendKeys(Keys.ENTER).build().perform();

		// Add second todo item
		String testDataName = prop.getProperty("testDataName");
		action.moveToElement(t.newTodo()).sendKeys(testDataName).build().perform();
		assertEquals(testDataName, "Aaron.");
		action.moveToElement(t.newTodo()).sendKeys(Keys.ENTER).build().perform();

		action.moveToElement(t.todoItem()).sendKeys(Keys.DOWN).build().perform();
		action.moveToElement(t.todoItem()).doubleClick().build().perform();

		// Edit second todoItem

		for (int i = 0; i < testDataName.length(); i++) {

			action.moveToElement(t.editToDoItem()).sendKeys(Keys.BACK_SPACE).build().perform();

		}

		String testDataEdit = prop.getProperty("testDataEdit");
		action.moveToElement(t.editToDoItem()).sendKeys(testDataEdit).build().perform();
		assertEquals(testDataEdit, "How are you");

	}

	@AfterTest
	public void quitBrowser() {

		driver.quit();
	}

}
