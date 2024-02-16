/*
 * TC1 - Validate the login successful with the credentials
 * https://rahulshettyacademy.com/client/
 */

package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constants.ConstantPath;
import utility.ExcelOperations;

public class LoginTest extends TestBase{
	
//	//@Test(dataProvider = "loginDetails")
//	public void verifyLogin(String uEmail, String uPassword) {
//		System.out.println("STEP: Login with login credentials.");
//		login.login(uEmail, uPassword);
//		Assert.assertTrue(login.isLoginSuccessMsgDisplayed());
//	}

	@Test
	public void verifyValidationMsgs() {
		System.out.println("STEP: Click on Login button.");
		login.clickLoginButton();
		System.out.println("VERIFY: Email Error message is displayed!");
		Assert.assertTrue(login.isEmailErrorMsgDisplayed());
		System.out.println("VERIFY: Password Error message is displayed!");
		Assert.assertTrue(login.isPasswordErrorMsgDisplayed());
	}

	@Test
	public void verifyPasswordValidation() {
		System.out.println("STEP: Enter valid UserName.");
		login.enterUserEmail("dgkankhar@gmail.com");
		System.out.println("STEP: Click on Login button.");
		login.clickLoginButton();
		System.out.println("VERIFY: Email Error message is not displayed!");
		Assert.assertFalse(login.isEmailErrorMsgDisplayed());
		System.out.println("VERIFY: Password Error message is displayed!");
		Assert.assertTrue(login.isPasswordErrorMsgDisplayed());
	}

	@Test
	public void verifyEmailValidation() {
		System.out.println("STEP: Enter valid Password.");
		login.enterPassword("Deepak@21");
		System.out.println("STEP: Click on Login button.");
		login.clickLoginButton();
		System.out.println("VERIFY: Email Error message is displayed!");
		Assert.assertTrue(login.isEmailErrorMsgDisplayed());
		System.out.println("VERIFY: Password Error message is not displayed!");
		Assert.assertFalse(login.isPasswordErrorMsgDisplayed());
	}

	@Test(dataProvider = "LoginDataProviderFromExcel")
	public void verifyLoginDataDriven(String uEmail, String uPassword, String loginStatus) {
		System.out.println("STEP: Login with login credentials.");
		boolean flag;
		if (loginStatus.equalsIgnoreCase("Pass")) {
			login.verifyLogin(uEmail, uPassword);
			flag = login.isLoginSuccessMsgDisplayed();
			Assert.assertTrue(flag, "Login Successfully msg not displayed");

//			flag = login.isLoginFailMsgDisplayed();
//			Assert.assertFalse(flag, "Incorrect password msg not displayed");

		} else {
			login.verifyLogin(uEmail, uPassword);
			flag = login.isLoginFailMsgDisplayed();
			Assert.assertTrue(flag, "Incorrect password msg not displayed");

//			flag = login.isLoginSuccessMsgDisplayed();
//			Assert.assertFalse(flag, "Login Successfully msg not displayed");
		}
	}

	@DataProvider(name = "LoginDataProviderFromExcel")
	public Object[][] loginDetailsFromExcel() throws IOException {
		Object[][] data = ExcelOperations.readLoginData(ConstantPath.EXCEL_PATH, "Login");
		return data;
	}

//	@DataProvider
//	public Object[][] loginDetails() throws IOException {
//		Object[][] data = new Object[1][2];
//		data[0][0] = "dgkankhar@gmail.com";
//		data[0][1] = "Deepak@21";
//
//		return data;
//	}
}
