package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ControlActions;
import utility.PropOperations;

public class LoginPage extends ControlActions {
	
	@FindBy(id = "userEmail")
	WebElement userEmailElement;

	@FindBy(id = "userPassword")
	WebElement userPasswordElement;

	@FindBy(id = "login")
	WebElement loginButtonElement;

	@FindBy(xpath = "//div[@aria-label='Login Successfully']")
	WebElement loginSuccessMsgElement;
	
	@FindBy(xpath = "//div[@aria-label='Incorrect email or password.']")
	WebElement loginFailureMsgElement;

	@FindBy(xpath = "//div[text()='*Email is required']")
	WebElement emailRequiredMsg;

	@FindBy(xpath = "//div[text()='*Password is required']")
	WebElement passwordRequiredMsg;

	public LoginPage() {
		PageFactory.initElements(driver, this); // Constructor to initialize elements
	}

	public void verifyLogin(String uName, String uPassword) {

		// driver.findElement(By.id("userEmail")).sendKeys(uName);
		enterUserEmail(uName);

		// driver.findElement(By.id("userPassword")).sendKeys(uPassword);
		enterPassword(uPassword);
		

		// driver.findElement(By.id("login")).click();
		clickLoginButton();
	}

	public void enterUserEmail(String uName) {
		System.out.println("STEP: User enters email!");
		userEmailElement.sendKeys(uName);
	}

	public void enterPassword(String uPassword) {
		System.out.println("STEP: User enters password!");
		userPasswordElement.sendKeys(uPassword);
	}

	public void clickLoginButton() {
		System.out.println("STEP: User clicks on Login button.");
		//loginButtonElement.click();
		clickOnElement(loginButtonElement, true);
	}

	public boolean isLoginSuccessMsgDisplayed() {
		// WebElement loginSuccess = getElement("xpath", "//div[@aria-label='Login
		// Successfully']", true);
		// waitTillElementIsVisible(loginSuccessMsgElement);
		System.out.println("VERIFY: Login Toast pop-up displayed after Login sucessfully!");
		return isElementVisible(loginSuccessMsgElement, true);
	}
	
	public boolean isLoginFailMsgDisplayed() {
		System.out.println("VERIFY: Login Toast pop-up displayed after Login Failure!");
		return isElementVisible(loginFailureMsgElement, true);
	}

	public boolean isEmailErrorMsgDisplayed() {

		return isElementVisible(emailRequiredMsg);

	}

	public boolean isPasswordErrorMsgDisplayed() {
		return isElementVisible(passwordRequiredMsg);
	}
	
	public String getValuePropertyFile(String key) {
		return getValueFromProperties(key);
		
	}
}
