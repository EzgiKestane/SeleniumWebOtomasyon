package trendyolTestAutomationCore;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class PageControl {

    private WebDriver driver;
    private String url;

    public PageControl(String url){
        try {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ezgi\\eclipse-workspace" +
                    "\\SeleniumWebOtomasyon\\src\\test\\resources\\chromedriver.exe");
            //Kodumun çalışması için ChromeDriver'ın kendi bilgisayarınızdaki adresini ekleyiniz.
            this.driver = new ChromeDriver();//Google Chrome driver olarak secildi.
            this.url = url;
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    public void openPage(){
        try {
            driver.get(url);//Trendyol adresi açıldı.
            driver.manage().window().maximize();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void despose(){
        driver.close();
        driver.quit();
    }

}
