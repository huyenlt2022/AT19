import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestNG_Day10 {
    public WebDriver driver;
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Before Suite");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("After Suite");
    }

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browser){
        if(browser.equalsIgnoreCase("Chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }else if(browser.equalsIgnoreCase("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
    }

    @AfterClass
    public void afterClass(){
        System.out.println("After Class");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("Before Test");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("After Test");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before Method");
    }

    @Test(enabled = false)
    public void Test01_Create_Product(){
        System.out.println("Test case 01");
    }

    @Test
    public void test02_edit_data(){
        System.out.println("Test case 02");
        driver.get("https://tiki.vn/");
    }
    @Test
    public void test03_delete(){
        System.out.println("Test case 03");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("After Method");
    }
}
