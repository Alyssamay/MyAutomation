package AutoTest;

import static org.junit.Assert.assertTrue;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class BingTest {
	public static void main(String args[]) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\demo\\MyAutomation\\Mavedemo\\src\\main\\java\\drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://cn.bing.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();//最大化屏幕

		
		WebElement queryInputElement =driver.findElement(By.xpath("//input[@id='sb_form_q']"));//搜索关键字
		queryInputElement.sendKeys("Travelling");
		WebElement submitBtnElement=driver.findElement(By.className("b_searchboxSubmit"));
		submitBtnElement.click();
		
		WebElement ele=driver.findElement(By.linkText("Images"));//断言searchResult page 文字链接Images元素是否存在
		assertTrue(ele.isDisplayed());
		
		try {
			driver.findElement(By.xpath("//div[contains(@class,'shader_left')]"));//在searchResult页面找homepage元素时抛异常
		} catch (org.openqa.selenium.NoSuchElementException e) {
			// TODO: handle exception
		}
	
		WebElement resultNum=driver.findElement(By.xpath("//span[@class='sb_count']"));//打印检索的Result Number
		String info=resultNum.getText();
		info=(info.substring(0, 10)).replaceAll(",","");
		System.out.println(info);
		int Result1=Integer.parseInt(info);
		
	    
		//a[contains(text(),'Past 24 hours')]
	    driver.findElement(By.xpath("//span[@class='fs_label']")).click();
	    driver.findElement(By.linkText("Past 24 hours")).click();
	   
	   
	    WebElement resultNum2=driver.findElement(By.xpath("//span[@class='sb_count']"));//打印检索的Result Number
		String info2=resultNum2.getText();
		info2=info2.substring(0, 2);
		System.out.println(info2);
		int Result2=Integer.parseInt(info2);
		
		
	    if(Result2<Result1) {
	    	System.out.println("CompareResult is true");//比较连词检索的ResultNumber
	    }
	    else {
	    	System.out.println("CompareResult is false");
		}
		
	  driver.close();	
	 
		
	}

}
