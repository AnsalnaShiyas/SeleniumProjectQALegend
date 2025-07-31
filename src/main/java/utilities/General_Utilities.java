package utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class General_Utilities {

	public String getAttributeof_Element(WebElement element, String attribute) {

		return element.getAttribute(attribute);

	}

	public boolean Is_Element_Displayed(WebElement element) {
		return element.isDisplayed();

	}

	public boolean is_Element_selected(WebElement element) {
		return element.isSelected();
	}

	public boolean is_Element_Enabled(WebElement element) {

		return element.isEnabled();
	}

	public boolean is_Dropdown_Multiselect(WebElement element) {

		Select select = new Select(element);
		return select.isMultiple();// command is used to check whether drop down is multiple

	}

	public void select_Option_From_Dropdown_Using_Index(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public void select_By_Value(WebElement element, String value) {

		Select select = new Select(element);
		select.selectByValue(value);
	}

	public void select_By_VisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);

	}

	public List<String> getAllOptions_From_Dropdown(WebElement element) {
		Select select = new Select(element);
		return select.getOptions().stream().map(WebElement::getText).collect(Collectors.toList());
	} // to get the name of all values from the drop down

	public List<String> getAllSelectedOptions_From_Dropdown(WebElement element) {
		Select select = new Select(element);
		return select.getAllSelectedOptions().stream().map(WebElement::getText).collect(Collectors.toList());
	}

	public void deselect_All(WebElement element) {
		deselect_All(element);

	}

	public void deselect_By_index(WebElement element, int index) {
		deselect_By_index(element, index);

	}

	public List<String> getTextsFromElements(List<WebElement> elements) {
		List<String> texts = new ArrayList<String>();
		for (WebElement element : elements) {
			texts.add(element.getText().trim());
		}
		return texts;

	}

	public void file_Upload(WebElement element, String filePath) {
		element.sendKeys(filePath);
	}

	public void keyDown_Utility(WebDriver driver, Keys key) {
		Actions actions = new Actions(driver);
		actions.keyDown(key).perform();
	}

	public void keyUp_Utility(WebDriver driver, Keys key) {
		Actions actions = new Actions(driver);
		actions.keyUp(key).perform();
	}

	public void dragAndDrop_Utility(WebDriver driver, WebElement sourceElement, WebElement destinationElement) {
		Actions actions = new Actions(driver);
		actions.dragAndDrop(sourceElement, destinationElement).perform();
	}

	public void alert_Accept(WebDriver driver) {
		driver.switchTo().alert().accept(); // accepting alert
	}

	public void alert_Dismiss(WebDriver driver) {

		driver.switchTo().alert().dismiss();// dismissing an alert
	}

	public String getTextof_Alertmsg(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}

	public void promptAlert_Input_Text(WebDriver driver, String text) {

		driver.switchTo().alert().sendKeys(text);
	}

	public void switchToFrameByNameOrID(WebDriver driver, String NameOrID) {
		driver.switchTo().frame(NameOrID);
	}

	public void switchToFrameByWebElement(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	public void switchBackFromTheiFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	public void addSleep_Utility(long timeOut) throws InterruptedException {
		Thread.sleep(timeOut);
	}
	
	public void scrollUsingJavaScriptExecutor_Utility(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
}
