package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseFactory {
    private long TIMEOUT = 30;
    private WebDriverWait explicitWait;
    private Actions actions;

    public void sendKeysToElement(WebDriver driver, WebElement element, String value){
        element.sendKeys(value);
    }

    public void clickToElement(WebDriver driver, WebElement element){
        element.click();
    }



}
