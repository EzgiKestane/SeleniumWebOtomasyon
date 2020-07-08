package trendyolTestAutomationCore;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PageTests extends PageControl {

    /**
     * Bu test ile sitenin title'ı ile girilen url'in title'ının eşitliği doğrulanır.Buna göre consola
     * eşit olup olmama durumu yazdırılır.
     */
    @Test
    public void a_titleTest() {
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

    /**
     * Bu test ile mouse'un giriş menusu üzerine hover edilmesi sağlanır. Ve açılan submenude
     * Giriş Yap butonuna tıklandığının doğruluğu test edilir. Ve tıklanılırsa consola yazdırılır.
     */
    @Test
    public void b_loginButtonTest() {
        try {
            action = new Actions(driver);
            WebElement we = driver.findElement(By.id("accountBtn"));
            action.moveToElement(we).build().perform();
            action.moveToElement(driver.findElement(By.xpath("//*[@id=\"not-logged-in-container\"]/div/div[1]"))).click().build().perform();
            System.out.println("Tuşa basıldı");
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"email\"]")));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Bu test ile login pop-up'ında Email ve Şifre Girilerek Giriş Yap butonu tıklanılabilirliği doğrulanır.
     * Ve consola yazdırılır.
     */
    @Test
    public void c_loginProcessTest() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"email\"]"))).click();
            driver.findElement(By.id("email")).sendKeys("test.test12325@yahoo.com");
            driver.findElement(By.id("password")).sendKeys("Ckeck12345*");
            driver.findElement(By.id("loginSubmit")).click();
            System.out.println("You have been logged in");
        } catch (Exception e) {
            System.out.println("Login unsuccessful");
        }
    }

    /**
     * Bu test ile arama kutusuna "bilgisayar" kelimesi yazdırılarak Enter tuşuna basılır ve arama yapılabilirliği
     * test edilir. Ve consola yazdırılır.
     */
    @Test
    public void d_searchBoxTest() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(By.className("search-box")));
            driver.findElement(By.className("search-box")).sendKeys("bilgisayar");
            driver.findElement(By.className("search-box")).sendKeys(Keys.ENTER);
            System.out.println("Search done");
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"search-app\"]/div/div/div[2]/div[2]/div")));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Search failed.");
        }

    }

    /**
     * Bu test ile rastgele seçtiğim bir iteme tıklanılabilirlik test edilir.
     */
    @Test
    public void e_itemSelectTest() {
        try {
            waitForPageLoad();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"search-app\"]/div/div/div[2]/div[2]/div/div[1]")));
            driver.findElement(By.xpath("//*[@id=\"search-app\"]/div/div/div[2]/div[2]/div/div[1]")).click();
            waitForPageLoad();
        } catch (Exception e) {
            System.out.println("You couldn't select an item.");
        }
    }

    /**
     * Bu test ile sepete ekleme işleminin yapılabilirliği test edilir.
     */
    @Test
    public void f_addToBasketTest() {
        try {
            driver.findElement(By.className("add-to-bs-tx")).click();
            waitForPageLoad();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Item couldn't added to basket.");
        }
    }

    /**
     * Bu test ile ürün sayfasındaki fiyat ile pop-up sepetindeki ürün fiyatı karşılaştırılır ve eşitliği test
     * edilir.
     */
    @Test
    public void g_basketPriceTest() {
        try {
            String product_Price = driver.findElement(By.className("prc-slg")).getText();
            System.out.println(product_Price);
            WebElement we = driver.findElement(By.id("myBasketListItem"));
            action.moveToElement(we).build().perform();
            wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Sepete Git")));
            String product_box_price = driver.findElement(By.className("salePrice")).getText();
            System.out.println(product_box_price);
            if (product_Price.equals(product_box_price)) {
                System.out.println("Prices are equal.");
            } else {
                System.out.println("Prices are not equal.");
            }
        } catch (Exception e) {
            System.out.println("Something went wrong.");
        }
    }

    /**
     * Bu test ile sepete eklenen ürün '+' tıklanarak fonksiyonun çalıştığı kontrol edilir.
     * Ve ürün sayısının 2'ye eşit olduğu test edilir ve consola yazdırılır.
     */
    @Test
    public void h_productCountTest() {
        try {
            driver.findElement(By.xpath("//*[@id=\"myBasketListItem\"]")).click();
            waitForPageLoad();
            wait.until(ExpectedConditions.elementToBeClickable(By.className("ty-numeric-counter-button")));
            driver.findElement(By.xpath("//*[@id=\"partial-basket\"]/div/div[3]/div[2]/div[3]/div[1]/div/button[2]")).click();
            String productCount = driver.findElement(By.className("counter-content")).getText();
            String productMomentCount = "2";
            System.out.println(productCount);
            if (productCount.equals(productMomentCount)) {
                System.out.println(productCount);
            } else {
                System.out.println("Item count is not equal");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Bu test ile ürün çöp kutusuna tıklanarak silinebilirliği test edilir.
     */
    @Test
    public void i_deletingItemTest() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(By.className("i-trash")));
            driver.findElement(By.xpath("//*[@id=\"partial-basket\"]/div/div[2]/div[2]/div[3]/button")).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            wait.until(ExpectedConditions.elementToBeClickable(By.className("btn-item btn-remove")));
            driver.findElement(By.xpath("//*[@id=\"ngdialog1\"]/div[2]/form/div/div[2]/div/div[1]/button[2]")).click();

        } catch (Exception e) {
            try {
                driver.findElement(By.xpath("//*[@id=\"ngdialog1\"]/div[2]/form/div/div[2]/div/button[2]")).click();
                waitForPageLoad();
            } catch (Exception e2) {
                e2.printStackTrace();
            }

        } finally {
            waitForPageLoad();
            System.out.println("Items Deleted.");
        }

    }

}

