package Tests;

import org.testng.AssertJUnit;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.*;
import org.testng.annotations.*;

import Pages.HomePage;

public class Login_Try {
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
	}

	@Test(description = "Login fail with blank acc and pw")
	public void Blank_acc_pw() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		HomePage home = new HomePage(driver);
		home.submit();
		String mess = null;
		mess = home.getMessage1();
		System.out.println(mess);
		AssertJUnit.assertEquals(home.getMessage1().contentEquals("ログイン名またはパスワードが違います。もう一度入力して下さい。"), true);
	}

	@Test(description = "Login fail with blank acc")
	public void Blank_acc() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		HomePage home = new HomePage(driver);
		home.typeUsername("");
		home.typePassword("admin");
		home.submit();
		AssertJUnit.assertEquals(home.getMessage1().contentEquals("ログイン名またはパスワードが違います。もう一度入力して下さい。"), true);
	}

	@Test(description = "Login fail with blank pw")
	public void Blank_pw() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		HomePage home = new HomePage(driver);
		home.typeUsername("admin");
		home.typePassword("");
		home.submit();
		AssertJUnit.assertEquals(home.getMessage1().contentEquals("ログイン名またはパスワードが違います。もう一度入力して下さい。"), true);
	}

	@Test(description = "Login fail with invalid pw")
	public void Invalid_pw() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		HomePage home = new HomePage(driver);
		home.typeUsername("admin");
		home.typePassword("admin1");
		home.submit();
		AssertJUnit.assertEquals(home.getMessage1().contentEquals("ログイン名またはパスワードが違います。もう一度入力して下さい。"), true);
	}

	@Test(description = "Login fail with unexisted acc")
	public void Unexisted_acc() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		HomePage home = new HomePage(driver);
		home.typeUsername("abc");
		home.typePassword("admin");
		home.submit();
		AssertJUnit.assertEquals(home.getMessage1().contentEquals("ログイン名またはパスワードが違います。もう一度入力して下さい。"), true);
	}

	@Test(description = "Login Success")
	public void LoginSuccess() throws InterruptedException {
		HomePage home = new HomePage(driver);
		home.typeUsername("admin");
		home.typePassword("admin");
		home.submit();
		Thread.sleep(10000);
		System.out.println(driver.getTitle());
		System.out.println(home.getUsername());
		 home.userlist();
		 home.user();
	}

	@AfterMethod
	public void AfterMethod() {
		driver.close();
	}
}