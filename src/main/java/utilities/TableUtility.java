package utilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TableUtility {
	
	
	/**
     * Searches for specific text in a web table.
     *
     *  driver       WebDriver instance
     *  tableXpath   XPath for the table rows (e.g., "//table/tbody/tr")
     *  searchText   Text to search for in the table rows
     *  true if the text is found, false otherwise
     */
    public static boolean isTextPresentInTable(WebDriver driver, String tableXpath, String searchText) {
        List<WebElement> rows = driver.findElements(By.xpath(tableXpath));

        for (WebElement row : rows) {
            String rowText = row.getText();
            if (rowText.contains(searchText)) {
                System.out.println("Text found in row: " + rowText);
                return true;  // Text found
            }
        }
        return false; // Text not found
    }


}
