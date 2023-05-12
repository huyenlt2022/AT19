package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class BasePage {
    private long TIMEOUT = 30;
    private WebDriverWait explicitWait;
    private Actions actions;

    public By getByXpath(String locator){
        return By.xpath(locator);
    }

    public WebElement getElement(WebDriver driver, String locator){
        return driver.findElement(getByXpath(locator));
    }

    public void clickToElement(WebDriver driver, String locator){
        getElement(driver, locator).click();
    }

    public void sendKeysToElement(WebDriver driver, String locator, String value){
        getElement(driver, locator).clear();
        getElement(driver, locator).sendKeys(value);
    }

    public String getTextByXpath(WebDriver driver, String locator){
        return getElement(driver, locator).getText();
    }

    public void doubleClickToElement(WebDriver driver, String locator){
        actions = new Actions(driver);
        actions.doubleClick(getElement(driver,locator)).build().perform();
    }

    public void waitForElementVisible(WebDriver driver, String locator){
        explicitWait = new WebDriverWait(driver, TIMEOUT);
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(locator)));
    }

    public void switchToWindowByTitle(WebDriver driver, String expectedWindowTitle){
        Set<String> allWindowID = driver.getWindowHandles();
        for(String item : allWindowID){
            driver.switchTo().window(item);
            String actualWindowTitle = driver.getTitle();
            if(actualWindowTitle.equals(expectedWindowTitle)){
                break;
            }
        }
    }
}
