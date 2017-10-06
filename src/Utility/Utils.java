package Utility;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {
	public static WebDriver driver = null;

	public static WebDriver OpenBrowser(int iTestCaseRow) throws Exception {
		String sBrowserName;
		try {
			sBrowserName = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_Browser);
			if (sBrowserName.equals("Mozilla")) {
				System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
				driver = new FirefoxDriver();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.get(Constant.URL);
			}
		} catch (Exception e) {
		}
		return driver;
	}

	public static String getTestCaseName(String sTestCase) throws Exception {
		String value = sTestCase;
		try {
			int posi = value.indexOf("@");
			value = value.substring(0, posi);
			posi = value.lastIndexOf(".");
			value = value.substring(posi + 1);
			return value;
		} catch (Exception e) {
			throw (e);
		}
	}

	public static void mouseHoverAction(WebElement mainElement, String subElement) {

		Actions action = new Actions(driver);
		action.moveToElement(mainElement).perform();
		if (subElement.equals("Accessories")) {
			action.moveToElement(driver.findElement(By.linkText("Accessories")));
		}
		if (subElement.equals("iMacs")) {
			action.moveToElement(driver.findElement(By.linkText("iMacs")));
		}
		if (subElement.equals("iPads")) {
			action.moveToElement(driver.findElement(By.linkText("iPads")));
		}
		if (subElement.equals("iPhones")) {
			action.moveToElement(driver.findElement(By.linkText("iPhones")));
		}
		action.click();
		action.perform();
	}

	public static void waitForElement(WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	// public static void takeScreenshot(WebDriver driver, String sTestCaseName)
	// throws Exception{
	// try{
	// File scrFile =
	// ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	// FileUtils.copyFile(scrFile, new File(Constant.Path_ScreenShot +
	// sTestCaseName +".jpg"));
	// } catch (Exception e){
	// Log.error("Class Utils | Method takeScreenshot | Exception occured while
	// capturing ScreenShot : "+e.getMessage());
	// throw new Exception();
	// }
}
