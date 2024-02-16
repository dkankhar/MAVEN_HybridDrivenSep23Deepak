package constants;

public class ConstantPath {
	
	public final static String MAIN_RESOURCES = ".//src/main/resources";
	public final static String TEST_RESOURCES = ".//src/test/resources";
	
	public final static String ENV_FILEPATH = MAIN_RESOURCES+"/config//qa.properties";
	public final static String CHROME_DRIVER_KEY = "webdriver.chrome.driver";
	public final static String CHROME_DRIVER_PATH = TEST_RESOURCES+"/chromeDriver//chromedriver.exe";
	public final static int WAIT = 10;
	public final static int FAST_WAIT = 5;
	public final static String EXCEL_PATH = TEST_RESOURCES+"/testdata//LoginData.xlsx";
}
