package AutomationAssessment;

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
		Thread.sleep(2000);
		driver.findElementById("username").sendKeys("user1");
		driver.findElementById("password").sendKeys("demouserpwd");
		driver.findElementByXPath("//button[contains(text(),'Log in')]").click();
		
		//Scenario 1:
		
		//Edit profile in Dashbaord
		driver.findElementById("myProfileLink").click();
		Thread.sleep(2000);
		
		//To check whether navigated to the screen
		String ActualTitle = driver.findElementByXPath("//div[contains(text(), 'Employee Profile')]").getText();
		String ExpectedTitle = "Employee Profile";
		Assert.assertEquals(ExpectedTitle, ActualTitle);
	
		//Edit  button
		driver.findElementByXPath("//span[contains(text(),'Edit')]").click();
		Thread.sleep(2000);
		
		//Enter the Second name
		driver.findElementById("middle_name").sendKeys("Chandru");
		
		//Select Gender as Male
		driver.findElementByXPath("(//div[@class='ant-select-selector'])[2]").click();
		driver.findElementByXPath("//div[@title='Male']").click();
	//	driver.findElementByXPath("(//div[@class='ant-select-selector'])[2]").sendKeys(Keys.ENTER);
		
		//Select Status as Single 
		//Thread.sleep(2000);
	//	driver.findElementByXPath("(//div[@class='ant-select-selector'])[3]").click();
	//	driver.findElementByXPath("//div[@title='Single']").click();
	//	Thread.sleep(3000);
		
		//To close [Temp code]
		Thread.sleep(4000);
		driver.findElementByXPath("//button[@class='ant-modal-close']/span/span").click();
		
		
		//Verify name got updates as
		Thread.sleep(2000);
		String updatedName = driver.findElementByXPath("//div[@class='ant-space-item']/div/div/h4").getText();
		String ExpectedName = "Sofia O'Sullivan";
		Assert.assertEquals(ExpectedName, updatedName); 
		
		//Verify Gender
		Thread.sleep(2000);
		String updatedGender = driver.findElementByXPath("(//div[@class='ant-descriptions-view'])[2]/table/tbody/tr[1]/td[2]").getText();
		System.out.println(updatedGender);
		
		
		//Verify status
		Thread.sleep(2000);
		String updatedStatus = driver.findElementByXPath("(//div[@class='ant-descriptions-view'])[2]/table/tbody/tr[2]/td[1]").getText();
		System.out.println(updatedStatus);
		
		/*---------------------------------* SCENARIO 1 ENDS HERE *---------------------------- */
		
	
		//Scenario 2:
		//Click  Emergency contact details
		Thread.sleep(2000);
		driver.findElementByXPath("(//ul[@class='sidebar-menu'])/li/a").click();
		Thread.sleep(2000);
		driver.findElementByXPath("(//ul[@id='module_Personal_Information'])/li[5]").click();
		
		}
	}
