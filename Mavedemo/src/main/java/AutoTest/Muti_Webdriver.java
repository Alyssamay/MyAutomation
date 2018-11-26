package AutoTest;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Muti_Webdriver {
	
	private Properties p;
	public Muti_Webdriver() {
		this.p=new Properties();
		FileInputStream is;
		try {
			is=new FileInputStream("");
		} catch (Exception e1) {
			// TODO: handle exception
		}
		
		
	}
	public void testFirefox() {
		//System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/firefox/"+p.getProperty("fire_driver_version")+"/geckodriver.exe");
		System.setProperty("webdriver.gecko.driver", "C:\\demo\\MyAutomation\\Mavedemo\\src\\main\\resources\\drivers\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.get("https://cn.bing.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();//最大化屏幕
		driver.close();

	}
	public void testChrome() {
		//System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chrome/"+p.getProperty("chrome_driver_version")+"/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", "C:\\demo\\MyAutomation\\Mavedemo\\src\\main\\resources\\drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://cn.bing.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();//最大化屏幕
		driver.close();

	}
	public void testIE() {
		//System.setProperty("webdriver.ie.driver", "src/main/resources/drivers/ie/"+p.getProperty("ie_driver_version")+"/IEDriverServer.exe");
		System.setProperty("webdriver.ie.driver", "C:\\demo\\MyAutomation\\Mavedemo\\src\\main\\resources\\drivers\\IEDriverServer.exe");
		WebDriver driver=new InternetExplorerDriver();
		driver.get("https://cn.bing.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();//最大化屏幕
		driver.close();

	}
    
	@Test
	public void test() {
		Muti_Webdriver s=new Muti_Webdriver();
		s.testIE();
	}

}
