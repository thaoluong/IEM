package Tests;

import org.apache.commons.logging.Log;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Action.Login_Action;
import Utility.Constant;
import Utility.ExcelUtils;
import Utility.Utils;

public class LoginIEM_POM {
	public WebDriver driver;
	private String sTestCaseName;
	private int iTestCaseRow;

	@BeforeMethod
	public void beforeMethod() throws Exception {
		sTestCaseName = this.toString();
		sTestCaseName = Utils.getTestCaseName(this.toString());
		Utility.Log.startTestCase(sTestCaseName);
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Sheet1");
		iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName, Constant.Col_TestCaseName);
		driver = Utils.OpenBrowser(iTestCaseRow);
	}

	@Test
	public void f() throws Exception {
		try {
			Login_Action.Execute(iTestCaseRow);
			ExcelUtils.setCellData("Pass", iTestCaseRow, Constant.Col_Result);
		} catch (Exception e) {
			ExcelUtils.setCellData("Fail", iTestCaseRow, Constant.Col_Result);
			// Utils.takeScreenshot(driver, sTestCaseName);
			// Log.error(e.getMessage());
			throw (e);
		}

	}
}