package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	WebDriver driver;

	By account = By.id("account-menu");
	By login = By.xpath("//a[@id='login']/span/span");
	By username = By.id("username");
	By password = By.id("password");
	By submit = By.xpath("//button[@type='submit']");
//	By message1 = By.xpath("//*[contains(@class,'alert alert-danger alert-dismissible')]"); k đc
//	By message1 = By.cssSelector("div..firepath-matching-node"); k đc
	By message1 = By.xpath("//ngb-alert/div/div");
//	By message1 = By.xpath("//div[@role='alert']/div");

	By userlist = By.xpath("//a[@id='management-menu']/span/i");
	By user = By.xpath("//div[@id='navbarResponsive']/ul/li/ul/li/a/span/span");
	By username1 = By.xpath("//a[@id='account-menu']/span/span");

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public void account() {
		driver.findElement(account).click();
	}

	public void login() {
		driver.findElement(login).click();
	}

	public void typeUsername(String uid) {
		driver.findElement(username).sendKeys(uid);
	}

	public void typePassword(String pw) {
		driver.findElement(password).sendKeys(pw);
	}
	
	public void submit() {
		driver.findElement(submit).click();
	}
	
	public String getMessage1(){
		return driver.findElement(message1).getText();
	}
	
	public String getUsername(){
		return driver.findElement(username1).getText();
	}
	
	public void userlist(){
		driver.findElement(userlist).click();
	}
	
	public void user(){
		driver.findElement(user).click();
	}
}
