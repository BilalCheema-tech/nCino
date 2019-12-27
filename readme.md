# nCino QA Automation Test

## Pre-Requisites
	1. Programming Language: Java
	2. Java 1.7 installed and configured
	3. JUnit installed and configured on the selected IDE. 
	4. Maven installed and configured on the selected IDE.
	

## End to End Automation Test
	1. Framework: Selenium
	2. Feature: http://todomvc.com/
		1. Load the Website
		2. Click within the JavaScript Tab
		3. Select the polymer link
		4. Add two todo items
		5.Edit the content of the second todoItem

	3. Design Pattern: Page Object Model (src/test/java/objectmodels)
	4. Browsers configured
		1. ChromeDriver (For both MAC and Windows)
		2. FirefoxDriver (For both MAC and Windows)
	5.Location of drivers --> external/webdrivers
	6. Dependencies: pom.xml
	
*Note: I could not verify chromedriver and firefoxdriver for MAC*
		
## Execution Details
	1. Unzip the Project (GitProjects)
	2. Import maven project in Eclipse or any other IDE. 
	
	### For End to End Automation Tests
		1. Navigate to project
		2. Open “data.properties” file
		3. Provide the correct values for eBay USERNAME (endToEndAutomationTest.username) and PASSWORD (endToEndAutomationTest.password)
		4. Default browser is set to Google Chrome. If you want to change that to Mozilla Firefox, please mention ‘firefox’ in the Browser (endToEndAutomationTest.selenium.browser)
		5. Navigate to src/test/java/com.mycompany.app
		6. Right click on HomePage.java and Run as ‘TestNg Test’


