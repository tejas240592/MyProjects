package curahealth;

import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DoLogin {
	
	private WebDriver driver;
	private String baseurl;
	
	@BeforeMethod
	void setup() {
		
		driver = new ChromeDriver();
		baseurl = "https://katalon-demo-cura.herokuapp.com/";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
	}
	
		
	//@Test
	void SimpleLogin() {
		
		driver.get(baseurl);
		driver.findElement(By.xpath("//a[text()='Make Appointment']")).click();
		
		//For username
		driver.findElement(By.xpath("//input[@type='text' and @id='txt-username']")).sendKeys("Tejas");
		driver.findElement(By.xpath("//div[@class='form-group'][3]/preceding-sibling::div[1]/div/input")).sendKeys("password123");
		driver.findElement(By.xpath("//div[@class='form-group'][3]/div/button")).sendKeys(Keys.ENTER);
	}
	
	@Test
	void ComplexLogin() {
		
		driver.get(baseurl);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//a[text()='Make Appointment']")).click();
		
		//For username
		WebElement copyname = driver.findElement(By.cssSelector("input[type=text][value='John Doe']"));
		Actions act = new Actions(driver);
		act.keyDown(copyname, Keys.CONTROL).sendKeys("A");
		act.keyDown(Keys.CONTROL).sendKeys("c");
		act.keyUp(Keys.CONTROL).build().perform();
		
		WebElement pastename = driver.findElement(By.xpath("//input[@type='text' and @id='txt-username']"));
		act.keyDown(pastename,Keys.CONTROL).sendKeys("V");
		act.keyUp(Keys.CONTROL).build().perform();
		
		//For password
		WebElement copypassword = driver.findElement(By.cssSelector("input[type=text][value='ThisIsNotAPassword']"));
		WebElement pastepassword = driver.findElement(By.xpath("//div[@class='form-group'][3]/preceding-sibling::div[1]/div/input"));
		
		copypassword.sendKeys(Keys.CONTROL,"a");
		copypassword.sendKeys(Keys.CONTROL,"c");
		
		pastepassword.sendKeys(Keys.CONTROL,"V");
		
		driver.findElement(By.cssSelector("div.form-group button#btn-login")).sendKeys(Keys.ENTER);
	}
	
	@AfterMethod
	void fillForm() {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		WebElement facility = driver.findElement(By.id("combo_facility"));
		Select sel = new Select(facility);
		sel.selectByValue("Hongkong CURA Healthcare Center");
		
		driver.findElement(By.id("chk_hospotal_readmission")).click();
		
		/*
		 * List<WebElement> chk =
		 * driver.findElements(By.cssSelector("div[class=form-group]:nth-of-type(3) div"
		 * )); int chkfinal = chk.size(); for(int i = 0 ; i<chk.size();i++) {
		 * chk.get(i).click(); }
		 */
		
		driver.findElement(By.cssSelector("input[value='Medicaid']")).click();
		
		/*
		 * Date d = new Date();
		 * 
		 * driver.findElement(By.cssSelector("#txt_visit_date")).sendKeys(d.toString());
		 */
		
		driver.findElement(By.cssSelector("#txt_visit_date")).sendKeys("10/06/1957");
		
		driver.findElement(By.cssSelector("#txt_comment")).sendKeys("I am a tester from now on. I will be working in IT industry");
		
		driver.findElement(By.cssSelector("#btn-book-appointment")).sendKeys(Keys.ENTER);
	}
	
	@AfterClass
	void end() throws InterruptedException {
		
		Thread.sleep(3000);
		driver.close();
	}

}
