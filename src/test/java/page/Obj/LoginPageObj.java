package page.Obj;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import page.UI.LoginPageUI;

public class LoginPageObj extends BasePage {
    WebDriver driver;
    public LoginPageObj(WebDriver driver){
        this.driver = driver;
    }

    public void enterToEmaiTxt(String value){
        sendKeysToElement(driver, LoginPageUI.TXT_EMAIL, value);
    }

    public void enterToPasswordTxt(String value){
        sendKeysToElement(driver, LoginPageUI.TXT_PASSWORD, value);
    }

    public void clickToBtnSignIn(){
        clickToElement(driver, LoginPageUI.BTN_SIGNIN);
    }
}
