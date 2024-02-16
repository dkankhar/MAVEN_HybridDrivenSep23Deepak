package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ControlActions;

public class DashboardPage extends ControlActions {
	
	public DashboardPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//Section[@id='sidebar']//h6[text()='Categories']//following-sibling::div[not(@id)]/label")
	List <WebElement> listOfCategoriesOptions; 
	
	@FindBy(xpath = "//Section[@id='sidebar']//h6[text()='Sub Categories']//following-sibling::div[not(@id)]/label")
	List <WebElement> listOfSubCategoriesOptions;
	
	@FindBy(xpath = "//Section[@id='sidebar']//h6[text()='Search For']//following-sibling::div[not(@id)]/label")
	List <WebElement> listOfSearchForOptions;
	
	@FindBy(css = "div.card")
	List <WebElement> listofItemsDisplayed;
	
	public List<String> getListOfCategoriesOptions() {
		return listOfWebElements(listOfCategoriesOptions);
	}	
	public int getCountOfCategoriesOptions() {
		return listOfWebElements(listOfCategoriesOptions).size();
	}	
	
	public List<String> getListOfSubCategoriesOptions() {
		return listOfWebElements(listOfSubCategoriesOptions);
	}
	public int getCountOfSubCategoriesOptions() {
		return listOfWebElements(listOfSubCategoriesOptions).size();
	}
	
	public List<String> getListOfSearchForOptions() {
		return listOfWebElements(listOfSearchForOptions);
	}
	public int getCountOfSearchForOptions() {
		return listOfWebElements(listOfSearchForOptions).size();
	}
	
	public void clickOnFilterOption(String itemName) {
		String locatorValue = String.format
				("//section//label[text()='%s']/preceding-sibling::input", itemName);
		clickOnElement("XPATH", locatorValue, true);
	}
	
	public boolean isElementSelected(String itemName) {
		String locatorValue = String.format
				("//section//label[text()='%s']/preceding-sibling::input", itemName);
		WebElement element = getElement("XPATH", locatorValue, false);
		return element.isSelected();
	}
	
	public int getNumberOfFilterResults() {
		return listOfWebElements(listofItemsDisplayed).size();
	}
	
	
}
