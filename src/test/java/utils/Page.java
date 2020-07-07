package utils;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Page {
    protected static WebDriver driver;
    protected static String url = "https://www.trendyol.com/";

    static @BeforeClass
    public void openPage() {
        try {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ezgi\\eclipse-workspace" +
                    "\\SeleniumWebOtomasyon\\src\\test\\resources\\chromedriver.exe");
            //Kodumun çalışması için ChromeDriver'ın kendi bilgisayarınızdaki adresini ekleyiniz.
            driver = new ChromeDriver();//Google Chrome driver olarak secildi.
            driver.get(url);//Trendyol adresi açıldı.
            driver.manage().window().maximize();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static @AfterClass
    public void despose() {
        driver.close();
        driver.quit();
    }

}
