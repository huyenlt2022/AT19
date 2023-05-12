import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Browser_Commands_Day09 {
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
//        isSelectedCheckbox();
//        windowHandle();
//        framesHandle();
//        alertHandle();
        authenticationAlert();
        Thread.sleep(3000);
        driver.quit(); //close browser
    }

    public static void isSelectedCheckbox() {
        String url = "https://demoqa.com/radio-button";
        driver.get(url);
        WebElement cbxYes = driver.findElement(By.id("yesRadio"));
        //Kiểm tra xem đã click vào checkbox chưa
        System.out.println(cbxYes.isSelected());//chưa click trả về false
        WebElement lblYes = driver.findElement(By.xpath("//label[@for='yesRadio']"));
        lblYes.click();
        System.out.println(cbxYes.isSelected());//click rồi trả về true
    }

    public static void windowHandle() {
        String url = "https://demoqa.com/browser-windows";
        driver.get(url);
        WebElement tabButton = driver.findElement(By.id("tabButton"));
        tabButton.click();
        System.out.println(driver.getWindowHandle()); //get ra 1 id 1 window hiện tại (đang đứng)
        Set<String> listWindow = driver.getWindowHandles();
        //dùng vòng lặp duyệt qua từng tab
        for(String id: listWindow){
            System.out.println(id);
            //switch sang từng window để check title
            driver.switchTo().window(id);
            //get ra title của từng tab
            System.out.println(driver.getTitle());
            String expected = driver.getTitle();
            if(expected == ""){
                break;
            }
        }
        WebElement text = driver.findElement(By.xpath("//h1[text()='This is a sample page']"));
        System.out.println(text.isDisplayed());
    }

    public static void framesHandle() {
        String url = "https://demoqa.com/frames";
        driver.get(url);
        //switch vào frame
        //switch bằng index 0, 1, 3 -> độ chính xác không cao
//        driver.switchTo().frame(0);
//        //switch bằng name hoặc id
//        driver.switchTo().frame("frame1");
        //switch bằng webElement
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='frame1']")));
        WebElement text = driver.findElement(By.xpath("//h1[text()='This is a sample page']"));
        System.out.println(text.getText());

    }

    public static void alertHandle(){
        String url = "https://demoqa.com/alerts";
        driver.get(url);
        //cancel alert -> dismiss()
        WebElement btnConfirm = driver.findElement(By.id("confirmButton"));
        btnConfirm.click();
        Alert alert = driver.switchTo().alert();
//        alert.dismiss();//cancel
        alert.accept();//ok

        WebElement btnPromt = driver.findElement(By.id("promtButton"));
        btnPromt.click();
        alert.sendKeys("Meomeo");

        WebElement btnSimple = driver.findElement(By.id("alertButton"));
        btnSimple.click();
        alert.getText();
    }

    public  static void authenticationAlert(){
        //https://username:password@URL
        String url = "https://the-internet.herokuapp.com/basic_auth";
        String [] lists = url.split("//");
        String username = "admin";
        String password = "admin";
        String authen = lists[0] +"//" +  username + ":" + password + "@" + lists[1];
        driver.get(authen);
    }



}
