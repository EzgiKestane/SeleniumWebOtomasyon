package trendyolTestAutomationCore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageControl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ezgi\\eclipse-workspace\\SeleniumWebOtomasyon\\src\\test\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();//Google Chrome driver olarak secildi.

		driver.get("https://www.trendyol.com");
		driver.manage().window().maximize();
	}

}
