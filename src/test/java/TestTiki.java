import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.io.IOException;

public class TestTiki {
    WebDriver driver;
    @Parameters("browser")
    @BeforeClass
    public void setupBrowser(String browser){
        switch (browser){
            case "Chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "Firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                System.out.println("Chưa chọn browser !");
                break;
        }
    }

    @BeforeMethod
    public void openUrl(){
        String url = "https://tiki.vn/";
        driver.get(url);
    }

//    @DataProvider(name = "data_search")
//    public Object[][] getDataFromExcel() throws IOException {
//        String path = System.getProperty("user.dir");
//        String file = path + "\\src\\test\\resources\\testdata.xlsx";
//        String sheet = "Sheet2";
//        Object[][] dataSearch = ExcelUtils.getTableArray(file, sheet);
//        return dataSearch;
    //Dùng đặt dataprovider trong 1 classs
//    }

    @Test(dataProvider = "data_search", dataProviderClass = DataProviderSearch.class)
    public void testSearch(String data){
        WebElement txtSearch = driver.findElement(By.xpath("//input[@placeholder = 'Bạn tìm gì hôm nay']"));
        txtSearch.sendKeys(data);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
