package testScripts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DashboardTest extends TestBase {

	@Test
	public void verifySideFilterOptions() {
		
		login("dgkankhar@gmail.com","Deepak@21");
		List<String> expectedListOfCategoriesOptions = new ArrayList<String>(
				Arrays.asList("fashion", "electronics", "household"));
		List<String> expectedListOfSubCategoriesOptions = new ArrayList<String>(
				Arrays.asList("t-shirts", "shirts", "shoes", "mobiles", "laptops"));
		List<String> expectedListOfSearchForOptions = new ArrayList<String>(Arrays.asList("men", "women"));

		System.out.println("STEP: Get the list of options displayed under Categories! ");
		List<String> listOfCategoriesOptions = dashboard.getListOfCategoriesOptions();
		
		System.out.println("VERIFY: Validate the number of options under Categories! ");
		Assert.assertEquals(dashboard.getCountOfCategoriesOptions(), 3);
		System.out.println("VERIFY: Validate the options under Sub Categories against expected! ");
		Assert.assertEquals(listOfCategoriesOptions, expectedListOfCategoriesOptions);

		System.out.println("STEP: Get the list of options displayed under Sub Categories! ");
		List<String> listOfSubCategoriesOptions = dashboard.getListOfSubCategoriesOptions();
		
		System.out.println("VERIFY: Validate the number of options under Sub Categories! ");
		Assert.assertEquals(dashboard.getCountOfSubCategoriesOptions(), 5);
		System.out.println("VERIFY: Validate the options under Sub Categories against expected! ");
		Assert.assertEquals(listOfSubCategoriesOptions, expectedListOfSubCategoriesOptions);

		System.out.println("STEP: Get the list of options displayed under Search For! ");
		List<String> listOfSearchForOptions = dashboard.getListOfSearchForOptions();
		
		System.out.println("VERIFY: Validate the number of options under Search For! ");
		Assert.assertEquals(dashboard.getCountOfSearchForOptions(), 2);
		System.out.println("VERIFY: Validate the options under Search For against expected! ");
		Assert.assertEquals(listOfSearchForOptions, expectedListOfSearchForOptions);
	}
	
	@Test
	public void verifyFilterSearchResults() {
		System.out.println("STEP - User logs in successfully!");
		login("dgkankhar@gmail.com","Deepak@21");
		
		System.out.println("STEP - User clicks on the filter option!");
		dashboard.clickOnFilterOption("fashion");
		
		System.out.println("VERIFY - Validate if the checkbox is selected or not");
		Assert.assertTrue(dashboard.isElementSelected("fashion"),"Filter option not selected!");
		
		System.out.println("VERIFY - Validate if the results are displayed based on selected option!");
		int searchResultCount = dashboard.getNumberOfFilterResults();
		Assert.assertEquals(searchResultCount, 1);
	}
}
