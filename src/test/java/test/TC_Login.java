package test;

import core.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.Obj.LoginPageObj;

public class TC_Login extends BaseTest {
    LoginPageObj objLoginPage;

    @BeforeMethod
    public void openBrowser(){
        String url = "https://demo.guru99.com/test/login.html";
        driver.get(url);
        objLoginPage = new LoginPageObj(driver);
    }

    @Test
    public void TC_01_Login(){
        objLoginPage.enterToEmaiTxt("test01@gmail.com");
        objLoginPage.enterToPasswordTxt("abc123");
        objLoginPage.clickToBtnSignIn();
    }
}
