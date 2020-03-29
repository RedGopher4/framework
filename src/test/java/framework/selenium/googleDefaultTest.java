package framework.selenium;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import framework.selenium.pageobjects.GooglePage;
import framework.selenium.pageobjects.Util;

public class googleDefaultTest {
	private WebDriver driver = null;
	private GooglePage googlePage;
	
	@BeforeSuite
	public void initialize() throws IOException {
//		System.setProperty("webdriver.chrome.driver", "//framework/src/test/resources/chromedriver.exe");
		driver = new ChromeDriver(); // chromedriver's in "src/test/resources"
		// maximize browser
		driver.manage().window().maximize();
		// implicit wait
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@BeforeTest
	public void setupTest() {
		// open Google
		driver.get("http://www.google.com");
		googlePage = new GooglePage(driver);
	}
	
	@Test
	public void defaultPageTest() throws InterruptedException {
		Assert.assertNotNull(googlePage.searchBar());
		Assert.assertNotNull(googlePage.logo());
		driver.navigate().refresh();
		Assert.assertNotNull(googlePage.searchBar());
		Assert.assertNotNull(googlePage.logo());
	}
	
	@Test
	public void enterSearchQueryTest() throws InterruptedException, IOException {
		googlePage.searchBar().sendKeys("googling stuff");
		Assert.assertEquals(googlePage.searchBar().getAttribute("value"), "googling stuff");
		googlePage.googleSearchBtn().click();
		Assert.assertNotNull(googlePage.miniLogo());
		Assert.assertEquals(googlePage.searchBar().getAttribute("value"), "googling stuff");
		Assert.assertNotNull(googlePage.resultStats());
		Util.captureScreenshot(driver, "image1");
	}
	
	@Test
	public void goToImagesPageTest() throws InterruptedException, IOException {
		driver.get("http://www.google.com");
		googlePage.imagesTab().click();
		Assert.assertEquals(googlePage.imagesLogo().getAttribute("title"), "Google Images");
	}
	
	@AfterTest
	public void destroyTest() {
		googlePage = null;
		driver.close();
	}
	
	@AfterSuite
	public void teardownSuite() {
		driver.quit();
	}
}
