package utilities;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtilities {

	// **************************Explicit
	// Wait***************************************************//
	
	// element clickable -xpath
	public void waitForElementToBeClickableByXpathLocator_Utility(WebDriver driver, String locatorValue, int timeOut) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locatorValue))); // locator value or web element can
																						// be passed
	}

	// element clickable - ID
	public void waitForElementToBeClickableByIDLocator_Utility(WebDriver driver, String locatorValue, int timeOut) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.elementToBeClickable(By.id(locatorValue))); // locator value or web element can be
																					// passed
	}

	// element clickable - WebElement
	public void waitForElementToBeClickableByWebElement_Utility(WebDriver driver, WebElement element, int timeOut) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.elementToBeClickable(element)); // locator value or web element can be passed
	}

	// Element is visible
	public void waitForElementTobeVisible(WebDriver driver, WebElement element, int timeOut)

	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	// visibility of all elementlocated
	public void waitFortheVisibilityOfAllElementLocated(WebDriver driver, List<WebElement> elements, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.visibilityOfAllElements(elements));

	}

	// presenetsOfElementLocated
	public void waitForthePresentsofElemetLocated(WebDriver driver, String locatorValue, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locatorValue)));

	}

	// isAlertPresent
	public void waitForAlertIsPresent(WebDriver driver, WebElement element, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.alertIsPresent());

	}

	// **************************Fluent
	// Wait***************************************************//

	public void fluentWaitForElementtoBeClickableByXpathLocator_Utility(WebDriver driver, String locatorValue,
			int totalTimeOut, int pollingTimeOut) {

		FluentWait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(totalTimeOut))
				.pollingEvery(Duration.ofSeconds(pollingTimeOut)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locatorValue)));
	}

}
