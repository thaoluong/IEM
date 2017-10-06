package Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import Pages.HomePage;
import Pages.UserList;

public class CreateUser {
	WebDriver driver;

	@BeforeMethod
	public void BeforeMethod() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://192.168.7.43:9001/#/");
		driver.manage().window().maximize();
		Thread.sleep(30000);
		HomePage home = new HomePage(driver);
		home.account();
		home.login();
		home.typeUsername("admin");
		home.typePassword("admin");
		home.submit();
	}
	@Test
	public void CreateUser() throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		HomePage home = new HomePage(driver);
		home.userlist();
		home.user();
		UserList.ClickCreateUser();
		
	}
}
