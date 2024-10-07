package sdet;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SdetLive {
	
	private WebDriver driver;
	private String baseurl;
	private String baseurl2;
	
	
	@BeforeMethod
	void setup() {
		
		driver = new ChromeDriver();
		baseurl = "https://sdet.live/L6Ke";
		baseurl2 = "https://courses.thetestingacademy.com/courses/job-ready-automation-tester-blueprint-with-java-by-pramod-dutta";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}
	
	//@Test
	void checklinkUrl() {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.navigate().to(baseurl);
		//driver.findElement(By.cssSelector("ul#js-configuration-section>li[class='Bdrs(4px) ng-scope selected'] > a > div[class='C(dataTextColor) Fw(semi-bold) Mend(10px) Mend(0):lc Fxg(1) ng-binding']")).click();
		driver.findElement(By.xpath("//div[text()=' URLs ']")).click();
		//driver.findElement(By.cssSelector("div:contains(' URLs ')")).click();
		driver.findElement(By.xpath("//div[text()=' Variations ']")).click();
	}
	
	@Test
	void checklinkHeatmap() {
		
		
		driver.navigate().to(baseurl);
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		//WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='screenshot-thumb']/div/div[text()=' View Heatmap '])[2]")));
		//((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)", ele);
		//ele.click();
		//System.out.print("Success!!");
		driver.navigate().to(baseurl2);
		driver.findElement(By.xpath("//div[@class='option-tab vwo_player-option']")).click();
		
	}
	
	//@Test
	void HeatmapPage() {
		
		driver.navigate().to(baseurl2);
		driver.findElement(By.xpath("//div[@class='option-tab vwo_player-option']")).click();

		
	}
	
	//@AfterMethod
	void end() throws InterruptedException {
		
		Thread.sleep(10000);
		driver.quit();
	}

}
