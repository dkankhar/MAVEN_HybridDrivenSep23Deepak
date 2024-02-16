package testScripts;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import base.ControlActions;
import pages.DashboardPage;
import pages.LoginPage;

public class TestBase {
	LoginPage login;
	DashboardPage dashboard;
	static int count;

	@BeforeMethod
	public void setUp() {
		ControlActions.launchBrowser();
		login = new LoginPage();
		dashboard = new DashboardPage();
	}
	
	public void login(String uEmail, String uPassword) {
		System.out.println("STEP: Login with login credentials.");
		login.verifyLogin(uEmail, uPassword);
		Assert.assertTrue(login.isLoginSuccessMsgDisplayed());
	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		if (ITestResult.FAILURE == result.getStatus()) {
			ControlActions.captureScreenshot(result.getName()+"-"+count++);
		}
		ControlActions.closeBrowser();
	}
}
