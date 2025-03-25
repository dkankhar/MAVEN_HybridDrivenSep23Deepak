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

public class LoginTestPractice extends TestBase{

	@Test(dataProvider = "LoginDataProviderFromExcel")
	public void verifyLoginDataDriven(String uEmail, String uPassword, String loginStatus) throws IOException {
		login.enterUserEmail(uEmail);
		login.enterPassword(uPassword);
		login.clickLoginButton();
	}

	@DataProvider(name = "LoginDataProviderFromExcel")
	public Object[][] loginDetailsFromExcel() throws IOException {
		Object[][] data = ExcelOperations.readLoginData(ConstantPath.EXCEL_PATH, "Login2");
		System.out.println(data);
		return data;
	}
	
	@Test
	public void loginFromPropertyValues() {
		login.enterUserEmail(login.getValuePropertyFile("username"));
		login.enterPassword(login.getValuePropertyFile("password"));
		login.clickLoginButton();
		//Test
	}
	
	@Test
	public void verifyValidationMsgs() {
		System.out.println("STEP: Click on Login button.");
		login.clickLoginButton();
		System.out.println("VERIFY: Email Error message is displayed!");
		Assert.assertTrue(login.isEmailErrorMsgDisplayed());
		System.out.println("VERIFY: Password Error message is displayed!");
		Assert.assertTrue(login.isPasswordErrorMsgDisplayed());
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
