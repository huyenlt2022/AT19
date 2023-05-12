package page.Obj;

import core.BaseFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.UI.LoginPageUI;

public class LoginPageObjFactory extends BaseFactory {
    WebDriver driver;
    @FindBy(how = How.ID, using = "emmail")
    WebElement user99GuruName;

    @FindBy(how = How.XPATH, using = "//input[text()='abc']")
    WebElement user99GuruXpath;

    public LoginPageObjFactory(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);//this trỏ chính classs
        //init element có chức năng kết nối FindBy và element
    }


    public void enterToEmaiTxt(String value){
        sendKeysToElement(driver, user99GuruName, value);
    }


}
