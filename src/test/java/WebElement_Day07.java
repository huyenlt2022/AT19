import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebElement_Day07 {
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
//        clickGoodPrice();
//        sendKeyGoogle();
        clickLinkText();
        Thread.sleep(3000);
        driver.quit(); //close browser
    }

    public static void clickGoodPrice() {
        String url = "https://tiki.vn/";
        driver.get(url);

        WebElement btnGoodPrice = driver.findElement(By.xpath("//div[@title='Giá Tốt Mỗi Ngày']"));
        btnGoodPrice.click();
        String actual = driver.getTitle();
        String expected = "Tiki";
        //System.out.println(driver.getTitle()); //sout
        if (actual.equals(expected)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAILED");
        }
    }

    public static void sendKeyGoogle() {
        String url = "https://www.google.com.vn/";
        driver.get(url);
        WebElement txtSearch = driver.findElement(By.xpath("//input[@type='text']"));
        txtSearch.clear();//xóa text trong textbox, ví dụ placeholder
        txtSearch.sendKeys("Selenium Webdriver");
        txtSearch.sendKeys(Keys.ENTER);
    }

    public static void clickLinkText() throws InterruptedException {
        String url = "https://tiki.vn/";
        driver.get(url);
//        WebElement btnFruit = driver.findElement(By.linkText("sữa, bơ, phô mai"));
        WebElement btnFruit = driver.findElement(By.cssSelector("input[id='userName'][type='text']"));
        btnFruit.click();
        Thread.sleep(5000);
        System.out.println(driver.getTitle());

    }
}
