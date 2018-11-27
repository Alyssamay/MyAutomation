package AutoTest;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class TestBase {
	protected WebDriver driver;
	protected String browser;
	
	public void setUp() throws Exception{
		Properties prop=ProUtil.getProperties();
		browser=prop.getProperty(browser);
		driver=DriverManage.getDriver(browser);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
}
