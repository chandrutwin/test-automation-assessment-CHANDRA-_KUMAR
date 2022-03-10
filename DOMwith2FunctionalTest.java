package webProject;

import java.util.concurrent.TimeUnit;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class DOM {
	public void dom() throws InterruptedException, AddressException, MessagingException
	{
		
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver");
		ChromeDriver driver=new ChromeDriver();	
		driver.get("https://icehrm-open.gamonoid.com/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElementById("username").sendKeys("user1");
		
		driver.findElementById("password").sendKeys("demouserpwd");
		
		driver.findElementByXPath("//button[contains(text(),'Log in')]").click();
		
		//Scenario 1:
		
		//Edit profile in Dashboard
		driver.findElementById("myProfileLink").click();
		
		//To check whether navigated to the screen
		String ActualTitle = driver.findElementByXPath("//div[contains(text(), 'Employee Profile')]").getText();
		String ExpectedTitle = "Employee Profile";
		Assert.assertEquals(ExpectedTitle, ActualTitle);
	
		//Edit  button
		driver.findElementByXPath("//span[contains(text(),'Edit')]").click();
		
		//Enter the Second name
		driver.findElementById("middle_name").sendKeys("Chandra Kumar");
		
		//Select Gender as Male
		driver.findElementByXPath("(//div[@class='ant-select-selector'])[2]").click();
		driver.findElementByXPath("//div[@title='Male']").click();
		
		
		driver.findElementByXPath("//button[@class='ant-modal-close']/span/span").click();
		
		
		//Verify name got updates as
		String updatedName = driver.findElementByXPath("//div[@class='ant-space-item']/div/div/h4").getText();
		String ExpectedName = "Sofia O'Sullivan";
		Assert.assertEquals(ExpectedName, updatedName); 
		
		//Verify Gender
		String updatedGender = driver.findElementByXPath("(//div[@class='ant-descriptions-view'])[2]/table/tbody/tr[1]/td[2]").getText();
		System.out.println(updatedGender);
		
		
		//Verify status
		String updatedStatus = driver.findElementByXPath("(//div[@class='ant-descriptions-view'])[2]/table/tbody/tr[2]/td[1]").getText();
		System.out.println(updatedStatus);
		
		/*---------------------------------* SCENARIO 1 ENDS HERE *---------------------------- */
		
	
		//Scenario 2:
		//Click  Emergency contact details
		driver.findElementByXPath("(//ul[@class='sidebar-menu'])/li/a").click();
		driver.findElementByXPath("(//ul[@id='module_Personal_Information'])/li[5]").click();

		
		driver.findElementByXPath("//button[contains(text(), 'Add New ')]").click();
		
		driver.findElementByXPath("//input[@id='name']").sendKeys("Chandra Kumar");
		
		driver.findElementById("relationship").sendKeys("Single");
		
				
		driver.findElementByName("home_phone").sendKeys("044-224444");
				
		driver.findElementByName("work_phone").sendKeys("04142-826171");

		driver.findElementByXPath("//div[@class='controls col-sm-6']//input[@id='mobile_phone']").sendKeys("9876543210");

		driver.findElementByXPath("//button[contains(text(), 'Save')]").click();
		
		//Verify Marital Status
				String Marstat = driver.findElementByXPath("//table[@id='grid']/tbody/tr[2]/td[2]").getText();
				String ExpectedMar = "Single";
			    Assert.assertEquals(ExpectedMar, Marstat); 
						

		
		}
	}