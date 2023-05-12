import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Browser_Commands_Day08 {
    static WebDriver driver; //Tạo đối tượng driver tham chiếu tới WebDriver interface
    static String path = System.getProperty("user.dir"); //xuất ra đường dẫn hiện tại mà ứng dụng đang chạy

    public static void main(String[] args) throws InterruptedException {
        String browser = "Chrome";
        switch (browser) {
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
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); //set timeout để tìm element hiển thị
        customDropdownList();
//        defaultDropdownList();
//        sendKeysCustomUpload();
//        sendKeysDefaultUpload();
//        getCurrentUrl();
        Thread.sleep(3000);
        driver.quit(); //close browser
    }

    public static void getCurrentUrl() {
        String url = "https://tiki.vn/";
        driver.get(url);
        WebElement btnGoodPrice = driver.findElement(By.xpath("//div[@title='Giá Tốt Mỗi Ngày']"));
        btnGoodPrice.click();
        System.out.println(driver.getCurrentUrl()); //get ra url hiện tại
    }

    public static void sendKeysDefaultUpload() {
        String url = "https://tus.io/demo.html";
        driver.get(url);
        WebElement btnDefaultUpload = driver.findElement(By.xpath("//input[@type='file']"));
        btnDefaultUpload.sendKeys(path + "/src/test/resources/cam.jpg");
    }

    public static void sendKeysCustomUpload() {
        String url = "https://formstone.it/components/upload/demo/";
        driver.get(url);
        WebElement btnDefaultUpload = driver.findElement(By.xpath("(//input[@type='file'])[1]"));
        btnDefaultUpload.sendKeys(path + "/src/test/resources/cam.jpg");
    }

    public static void defaultDropdownList() {
        String url = "https://demoqa.com/select-menu";
        driver.get(url);
//        WebElement btnDefaultDropdownList = driver.findElement(By.id("oldSelectMenu"));
//        btnDefaultDropdownList.click();
//        WebElement btnColor = driver.findElement(By.xpath("//option[text()='Yellow']"));
//        btnColor.click();
        Select select = new Select(driver.findElement(By.id("oldSelectMenu")));
        //get ra tổng số option
        System.out.println(select.getOptions().size()); //11 data
        System.out.println(select.isMultiple()); //xem có được chọn nhiều item không
        //3 cách để chọn giá trị trong dropdownlist
        //select.selectByVisibleText("Blue");
        //random index
        int length = select.getOptions().size() - 1;
        Random random = new Random();
        int index = random.nextInt(length);
        System.out.println(index);
//        select.selectByIndex(index);
        select.selectByValue("3");
        //Bỏ chọn item
        select.deselectByValue("3");
    }

    public static void customDropdownList(){
        String url = "https://demoqa.com/select-menu";
        driver.get(url);
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        WebElement btnCustomDropdown = driver.findElement(By.xpath("//div[text()='Select...']"));
        btnCustomDropdown.click();

        List<WebElement> list = driver.findElements(By.xpath("//div[@class=' css-11unzgr']//div"));
        int length = list.size() - 1;
        System.out.println(length);
        Random random = new Random();
        int index = random.nextInt(length);
        System.out.println(index);
        list.get(index).click();

    }

}
