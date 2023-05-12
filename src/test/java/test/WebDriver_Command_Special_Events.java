package test;

import core.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.security.Key;

public class WebDriver_Command_Special_Events extends BaseTest {
    @Parameters("url")
    @BeforeMethod
    public void openBrowser(String url){
        driver.get(url);
    }

//    @Test
    public void Test_Special_Events() throws InterruptedException {
        WebElement btnRightClick = driver.findElement(By.xpath("//span[text()='right click me']"));
        Actions actions = new Actions(driver);
        actions.contextClick(btnRightClick).build().perform();
        Thread.sleep(5000);
        WebElement btnEdit = driver.findElement(By.xpath("//span[text()='Edit']"));
        btnEdit.click();
    }

    @Test
    public void activeKey() throws InterruptedException {
        WebElement txtSearch = driver.findElement(By.xpath("//input[@placeholder='Bạn tìm gì hôm nay']"));
        txtSearch.click();
        Actions actions = new Actions(driver);
        //keyDown: ấn giữ
        //keyUp: thả phím ra
        actions.keyDown(Keys.SHIFT).sendKeys("selenium").keyUp(Keys.SHIFT).sendKeys("tươi").build().perform();
        Thread.sleep(5000);
    }

}
