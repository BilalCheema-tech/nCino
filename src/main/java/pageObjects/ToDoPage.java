package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.javascript.host.dom.Document;
import com.gargoylesoftware.htmlunit.javascript.host.dom.ShadowRoot;
import com.mycompany.app.Base;

import io.github.sukgu.Shadow;

public class ToDoPage extends Base {

	public WebDriver driver;

	public ToDoPage(WebDriver driver2) {
		// TODO Auto-generated constructor stub
		this.driver = driver2;
	}

	By newToDo = By.id("new-todo");

	By toDoItem = By.xpath("//label[contains(text(),'Test2')]");

	By editItem = By.id("edit");

	public WebElement newTodo() {

		return driver.findElement(newToDo);

	}

	public WebElement todoItem() {
		return driver.findElement(toDoItem);
	}

	public WebElement editToDoItem() {
		return driver.findElement(editItem);
	}

}
