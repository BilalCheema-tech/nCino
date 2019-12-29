package com.mycompany.app;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;

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
	public void toDoPageTest() throws InterruptedException, AWTException {
		// object of ToDo Page
		ToDoPage t = new ToDoPage(driver);

		// actions class instance
		Actions action = new Actions(driver);

		// Add first todo item

		String testData = prop.getProperty("testData");

		t.newTodo().sendKeys(testData);
		t.newTodo().sendKeys(Keys.ENTER);

		// Add second todo item
		String testDataName = prop.getProperty("testDataName");

		t.newTodo().sendKeys(testDataName);
		t.newTodo().sendKeys(Keys.ENTER);

		String testDataCheck = t.todoItem1().getText();

		// Assertion to check first todoItem actual value is same as expected
		assertEquals(testDataCheck, testData);

		String testDataNameCheck = t.todoItem2().getText();

		// Assertion to check second todoItem actual value is same as expected
		assertEquals(testDataNameCheck, testDataName);

		action.moveToElement(t.todoItem2()).sendKeys(Keys.DOWN).doubleClick().build().perform();

		// Edit second todoItem

		for (int i = 0; i < testDataName.length(); i++) {

			// using action class as element was not interactable
			action.moveToElement(t.editToDoItem()).sendKeys(Keys.BACK_SPACE).build().perform();

		}

		String testDataEdit = prop.getProperty("testDataEdit");

		t.editToDoItem().sendKeys(testDataEdit);
		t.editToDoItem().sendKeys(Keys.ENTER);

		String testDataEditCheck = t.todoItem2().getText();

		// Assertion to check second todoItem edited value is same as expected
		assertEquals(testDataEditCheck, testDataEdit);

	}

	@AfterTest
	public void quitBrowser() {

		driver.quit();
		System.out.println("Browser closed after Tests ");
	}

}
