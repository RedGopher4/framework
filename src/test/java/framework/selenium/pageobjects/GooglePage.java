package framework.selenium.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GooglePage {
	private WebDriver driver;
	private By searchBar = By.name("q");
	private By logo = By.id("hplogo");
	private By miniLogo = By.id("logo");
	private By imagesLogo = By.cssSelector("#hplogo");
	private By aboutTab = By.partialLinkText("About");
	private By storeTab = By.partialLinkText("Store");
	private By gmailTab = By.partialLinkText("Gmail");
	private By imagesTab = By.partialLinkText("Images");
	private By googleSearchBtn = By.name("btnK");
	private By imFeelingLuckyBtn = By.name("btnI");
	private By resultStats = By.id("resultStats");
	
	public GooglePage(WebDriver driver) {
		this.driver = driver;
	}
	
//	public void setSearchQuery(String query) {
//		driver.findElement(searchBar).sendKeys(query);
//	}
//	
//	public String getSearchQuery() {
//		return driver.findElement(searchBar).getText();
//	}
	
	public WebElement searchBar() {
		return driver.findElement(searchBar);
	}
	
	public WebElement logo() {
		return driver.findElement(logo);
	}
	
	public WebElement miniLogo() {
		return driver.findElement(miniLogo);
	}
	
	public WebElement imagesLogo() {
		return driver.findElement(imagesLogo);
	}
	
	public WebElement aboutTab() {
		return driver.findElement(aboutTab);
	}
	
	public WebElement storeTab() {
		return driver.findElement(storeTab);
	}
	
	public WebElement gmailTab() {
		return driver.findElement(gmailTab);
	}
	
	public WebElement imagesTab() {
		return driver.findElement(imagesTab);
	}
	
	public WebElement googleSearchBtn() {
		return driver.findElement(googleSearchBtn);
	}
	
	public WebElement imFeelingLuckyBtn() {
		return driver.findElement(imFeelingLuckyBtn);
	}
	
	public WebElement resultStats() {
		return driver.findElement(resultStats);
	}
}
