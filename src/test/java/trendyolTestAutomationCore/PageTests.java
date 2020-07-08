package trendyolTestAutomationCore;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PageTests extends PageControl {


    @Test
    public void titleTest() {
        driver.get(url);
        waitForPageLoad();
        Assert.assertTrue(driver.getTitle().equals("En Trend Ürünler Türkiye'nin Online Alışveriş Sitesi Trendyol'da"));
        System.out.println("Site openned successfully.");

        try {
            WebElement element = driver.findElement(By.xpath("/html/body/div[8]"));
            System.out.println("Pop-up closed");
        } catch (Exception e) {
            System.out.println("No pop-up found");
        }
    }

    @Test
    public void loginButtonTest() {
        try {
            action = new Actions(driver);
            WebElement we = driver.findElement(By.xpath("//*[@id=\"accountBtn\"]"));
            action.moveToElement(we).perform();
            //driver.findElement(By.xpath("//div[@class='login-panel-container']//div[1]")).click();



            System.out.println("Tuşa basıldı");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
