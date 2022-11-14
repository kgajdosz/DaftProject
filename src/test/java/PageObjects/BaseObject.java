package PageObjects;

import DriverManagement.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.lang3.StringUtils;

public class BaseObject
{

    WebDriver driver = DriverManager.getWebDriver();
    WebDriverWait wait = new WebDriverWait(driver,10);

    @FindBy(tagName= "body")
    WebElement page;

    public boolean isSearchWordPresent(String word)
    {
        String pageURL = driver.getCurrentUrl();
        driver.get("view-source:"+pageURL);
        String pageSource = page.getText();
        //StringUtils.containsIgnoreCase(characterSequence, searchString));

        return StringUtils.containsIgnoreCase(pageSource, word);

    }
}
