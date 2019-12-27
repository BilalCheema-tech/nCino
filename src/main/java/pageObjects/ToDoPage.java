package pageObjects;

import java.util.Properties;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mycompany.app.Base;

public class ToDoPage extends Base {

	public WebDriver driver;

	public ToDoPage(WebDriver driver2) {
		// TODO Auto-generated constructor stub
		this.driver = driver2;
	}

	By newToDo = By.id("new-todo");

	By toDoItem = By.xpath("//li[2]//div[1]//label[1]");

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
