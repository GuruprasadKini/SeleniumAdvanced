package test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LambdaTestScenarios {
	
	public void testScenario1(String platform, String browser, String browserVersion) {
		RemoteDriver remoteDriver = new RemoteDriver();
		remoteDriver.testCase1(platform, browser, browserVersion);
		remoteDriver.driver.get("https://www.lambdatest.com/");
		WebDriverWait wait = new WebDriverWait(remoteDriver.driver, Duration.ofSeconds(30));
		// Wait until all the elements are present in the DOM
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.tagName("html")));
		// Find the element to be scrolled into view
		WebElement element1 = remoteDriver.driver.findElement(By.xpath("//img[@alt='LambdaTest Integration with Asana']"));
		// Scroll the element into view
		((JavascriptExecutor) remoteDriver.driver).executeScript("arguments[0].scrollIntoView(true);", element1);
		//Element to be clicked 
		WebElement element2 = remoteDriver.driver.findElement(By.xpath("//a[text()='See All Integrations']"));
		//get original Window handle
		String originalWindow = remoteDriver.driver.getWindowHandle();
		//click the element to open in a new tab
		Actions actions = new Actions(remoteDriver.driver);
		actions.keyDown(Keys.CONTROL).click(element2).keyUp(Keys.CONTROL).build().perform();
		//Switch driver to new Window 
		List<String> allWindows = new ArrayList<>(remoteDriver.driver.getWindowHandles());
		for (String window : allWindows) {
			//print all windows open 
			System.out.println("Window handle: " + window);
			if (!window.equals(originalWindow)) {
				remoteDriver.driver.switchTo().window(window);
				break;
			}
		}
		//Assert if current URL is same as expected URL
		String actualUrl = remoteDriver.driver.getCurrentUrl();
		String expectedUrl = "https://www.lambdatest.com/integrations";
		Assert.assertEquals(expectedUrl, actualUrl);
		//scroll to the page where the WebElement(Codeless Automation) is present.
		// Find the element to be scrolled into view
		WebElement element3 = remoteDriver.driver.findElement(By.xpath("//a[text()='Integrate Katalon Studio with LambdaTest']"));
		// Scroll the element into view
		((JavascriptExecutor) remoteDriver.driver).executeScript("arguments[0].scrollIntoView(true);", element3);
		//click link to Learn More 
		remoteDriver.driver.findElement(By.xpath("//a[text()='Integrate Testing Whiz with LambdaTest']")).click();
		//getTitle
		String getTitle = remoteDriver.driver.getTitle();
		String expectedTitle = "Running Automation Tests Using TestingWhiz LambdaTest | LambdaTest";
		Assert.assertEquals(expectedTitle, getTitle);
		//close current window
		allWindows.remove(remoteDriver.driver.getWindowHandle());
		remoteDriver.driver.close();
		remoteDriver.driver.switchTo().window(allWindows.get(0));
		//print number of window handles 
		System.out.println("Number of windows: " + allWindows.size());
		//navigate to URL
		remoteDriver.driver.navigate().to("https://www.lambdatest.com/blog");
		//Click on the ‘Community’ link 
		remoteDriver.driver.findElement(By.linkText("Community")).click();
		//verify whether the URL is https://community.lambdatest.com/.
		expectedUrl = "https://community.lambdatest.com/";
		actualUrl = remoteDriver.driver.getCurrentUrl();
		Assert.assertEquals(expectedUrl, actualUrl);
		//Close the current browser
		remoteDriver.driver.quit();

	}
	
	public void testScenario2(String platform, String browser, String browserVersion) {
		RemoteDriver remoteDriver = new RemoteDriver();
		remoteDriver.testCase1(platform, browser, browserVersion);
		remoteDriver.driver.get("https://www.lambdatest.com/");
		WebDriverWait wait = new WebDriverWait(remoteDriver.driver, Duration.ofSeconds(30));
		// Wait until all the elements are present in the DOM
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.tagName("html")));
		// Find the element to be scrolled into view
		WebElement element1 = remoteDriver.driver.findElement(By.xpath("//img[@alt='LambdaTest Integration with Asana']"));
		// Scroll the element into view
		((JavascriptExecutor) remoteDriver.driver).executeScript("arguments[0].scrollIntoView(true);", element1);
		//Element to be clicked 
		WebElement element2 = remoteDriver.driver.findElement(By.xpath("//a[text()='See All Integrations']"));
		//get original Window handle
		String originalWindow = remoteDriver.driver.getWindowHandle();
		//click the element to open in a new tab
		Actions actions = new Actions(remoteDriver.driver);
		actions.keyDown(Keys.COMMAND).click(element2).keyUp(Keys.COMMAND).build().perform();
		//Switch driver to new Window 
		List<String> allWindows = new ArrayList<>(remoteDriver.driver.getWindowHandles());
		for (String window : allWindows) {
			//print all windows open 
			System.out.println("Window handle: " + window);
			if (!window.equals(originalWindow)) {
				remoteDriver.driver.switchTo().window(window);
				break;
			}
		}
		//Assert if current URL is same as expected URL
		String actualUrl = remoteDriver.driver.getCurrentUrl();
		String expectedUrl = "https://www.lambdatest.com/integrations";
		Assert.assertEquals(expectedUrl, actualUrl);
		//scroll to the page where the WebElement(Codeless Automation) is present.
		// Find the element to be scrolled into view
		WebElement element3 = remoteDriver.driver.findElement(By.xpath("//a[text()='Integrate Katalon Studio with LambdaTest']"));
		// Scroll the element into view
		((JavascriptExecutor) remoteDriver.driver).executeScript("arguments[0].scrollIntoView(true);", element3);
		//click link to Learn More
		remoteDriver.driver.findElement(By.xpath("//a[text()='Integrate Testing Whiz with LambdaTest']")).click();
		//getTitle
		String getTitle = remoteDriver.driver.getTitle();
		String expectedTitle = "Running Automation Tests Using TestingWhiz LambdaTest | LambdaTest";
		Assert.assertEquals(expectedTitle, getTitle);
		//close current window
		allWindows.remove(remoteDriver.driver.getWindowHandle());
		remoteDriver.driver.close();
		remoteDriver.driver.switchTo().window(allWindows.get(0));
		//print number of window handles 
		System.out.println("Number of windows: " + allWindows.size());
		//navigate to URL
		remoteDriver.driver.navigate().to("https://www.lambdatest.com/blog");
		//Click on the ‘Community’ link and 
		remoteDriver.driver.findElement(By.linkText("Community")).click();
		//verify whether the URL is https://community.lambdatest.com/.
		expectedUrl = "https://community.lambdatest.com/";
		actualUrl = remoteDriver.driver.getCurrentUrl();
		Assert.assertEquals(expectedUrl, actualUrl);
		//Close the current browser
		remoteDriver.driver.quit();

	}
}
