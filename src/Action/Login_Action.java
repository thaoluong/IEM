package Action;

import org.apache.bcel.classfile.Constant;
import org.testng.Reporter;

import Pages.HomePage;
import Utility.ExcelUtils;

//import utility.ExcelUtils;
//import utility.Log;
//import utility.Utils;
//import utility.Log;
public class Login_Action {
	public static void Execute(int iTestCaseRow) throws Exception {

		// Clicking on the My Account link on the Home Page
		// HomePage home = new HomePage(driver);
		HomePage.account();
		// Log.info("account menu element is not found" );
		HomePage.login();
		// Log.info("Login element is not found" );
		String sUserName = ExcelUtils.getCellData(iTestCaseRow, Utility.Constant.Col_UserName);
		HomePage.typeUsername(sUserName);
		String sPassword = ExcelUtils.getCellData(iTestCaseRow, Utility.Constant.Col_Password);
		HomePage.typePassword(sPassword);
		HomePage.submit();
		// Utils.waitForElement(Home_Page.lnk_LogOut());
		// Reporter.log("SignIn Action is successfully perfomred");
	}
}
