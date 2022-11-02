package allure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class allurereport {

	
	
	
	public WebDriver driver;
    @Description("This Test Should Set Up Browser and Open Given URL")
	@Severity(SeverityLevel.CRITICAL)
    @Feature("Browser Initalization")
	@BeforeTest
	public void Browser() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		//WebDriver driver=new ChromeDriver();

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://qb.msbte.ac.in/allexam_w21_qb_st/");
		Thread.sleep(500);
		
	Assert.assertEquals(driver.getTitle(), "Online Question Bank Portal of MSBTE");
	
	
		
	
	
	}

	 @Severity(SeverityLevel.CRITICAL)
	@Test(priority=0)
	public void Login_Credentials() throws InterruptedException
	{
		driver.findElement(By.linkText("Log In")).click();	
		driver.findElement(By.id("username")).sendKeys("qbadmin");
		driver.findElement(By.id("password")).sendKeys("msbte789#");
		Thread.sleep(1000);

	}

    @Severity(SeverityLevel.CRITICAL)
	@Test(priority=1)
	public void Captcha() throws InterruptedException
	{

		String no1 = driver.findElement(By.id("num1")).getAttribute("value"); // Getting capthch value 1
		int nu1 = Integer.parseInt(no1);

		String no2 = driver.findElement(By.id("num2")).getAttribute("value"); // Getting capthch value 2
		int nu2 = Integer.parseInt(no2);

		int sum = nu1 + nu2;  //addition of captcha
		driver.findElement(By.id("captcha")).sendKeys(""+sum);

		driver.findElement(By.xpath("/html/body/div[2]/div[3]/center/table/tbody/tr/td/center/div/form/a/button")).click();
		Thread.sleep(1000);

		
       String success=driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/ul/li[2]/a")).getText();
      
       
       Assert.assertEquals(success, "Log Out");
	}

    @Severity(SeverityLevel.NORMAL)
	@Test(priority=2)  
	public void Question_Bank_Report() 
	{

		driver.findElement(By.linkText("Question Bank Report")).click();
		//throw new SkipException("THis Case Not Implemented");
	}




    @Severity(SeverityLevel.NORMAL)
	@Test(priority=3)
	public void Question_Bank_Moderator_Report() 
	{
		driver.findElement(By.linkText("Question Bank Moderator       Report")).click();	
	}



    @Severity(SeverityLevel.NORMAL)
	@Test(priority=4)
	public void Paper_Setter_Details() 
	{
		driver.findElement(By.linkText("Paper Setter Details")).click();	
	}


    @Severity(SeverityLevel.NORMAL)
	@Test(priority=5)
	public void Moderator_Details() 
	{
		driver.findElement(By.linkText("Moderator Details")).click();	
	}

    @Severity(SeverityLevel.NORMAL)
	@Test(priority=6)
	public void Paper_Setter_Not_Confirmed() 
	{
		driver.findElement(By.linkText("Paper Setter Not Confirmed")).click();	
	}

    @Severity(SeverityLevel.NORMAL)
	@AfterTest
	public void Browser_close() 
	{
		driver.close();

	}

}
