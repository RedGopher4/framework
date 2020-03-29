package framework.selenium.pageobjects;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Util {
	// reference: https://stackoverflow.com/questions/43386398/taking-screenshot-in-selenium-webdriver-in-chrome-browser
	public static String captureScreenshot(WebDriver driver, String scrnshotName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String dest = "/Users/macpro/eclipse-workspace/framework/target/"+scrnshotName+".png";
		File destination = new File(dest);
		FileUtils.copyFile(source, destination);
		return dest;
	}
}
