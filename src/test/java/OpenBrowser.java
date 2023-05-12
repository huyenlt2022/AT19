import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OpenBrowser {
    static WebDriver driver; //Tạo đối tượng driver tham chiếu tới WebDriver interface
    static String path = System.getProperty("user.dir"); //xuất ra đường dẫn hiện tại mà ứng dụng đang chạy

    public static void main(String[] args) {
        String browser = "Firefox";
        String url = "https://tiki.vn/";
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
        driver.get(url); //open browser
        driver.quit(); //close broser

    }
}
