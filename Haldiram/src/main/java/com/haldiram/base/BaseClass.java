package com.haldiram.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public static Properties prop;

	public WebDriver setUp() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\config.properties");
		prop.load(fis);
		System.out.println(prop.getProperty("browser"));
          
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("chrome browser opened");
		} else if (browserName.equals("firefox")) {
			driver = new FirefoxDriver();
			System.out.println("firefox browser is opend");
		} else if (browserName.equals("edge")) {
			driver = new EdgeDriver();
			System.out.println("edge browser is opened");
		}
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		System.out.println(prop.getProperty("url"));

		driver.get(prop.getProperty("url"));

		return driver;
	}

	public void waitForVisibilityWait(WebElement e) {

		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        // Wait until the element is visible
	        wait.until(ExpectedConditions.visibilityOf(e));
	}

	public void elementToBeClickable(WebElement e) {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        // Wait until the element is visible
	        wait.until(ExpectedConditions.visibilityOf(e));
	}

	public void click(WebElement e) {
		waitForVisibilityWait(e);
		elementToBeClickable(e);
		e.click();
	}

	public void sendkeys(WebElement e, String Text) {
		waitForVisibilityWait(e);
		e.sendKeys(Text);
	}

	public void clearText(WebElement e) {
		waitForVisibilityWait(e);
		e.clear();
	}

	public String getText(WebElement e) {
		waitForVisibilityWait(e);
		return e.getText();
	}

	public String getAttribute(WebElement e, String attribute) {
		waitForVisibilityWait(e);
		return e.getAttribute(attribute);
	}

	public void acceptAlert(WebElement e) {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		System.out.println("alert -----" + driver.switchTo().alert().getText());
		alert.accept();
		System.out.println("alert is accepted");
	}

	public void dismissAlert(WebElement e) {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		System.out.println("alert ---" + driver.switchTo().alert().getText());
		alert.dismiss();
		System.out.println(" alert is dismiss");
	}

	public void switchToframe(int framenum) {
		int totalFrames = driver.findElements(By.tagName("iframe")).size();
		System.out.println("total no of frames------" + totalFrames);
		driver.switchTo().frame(framenum);
	}

	public void switchToDefaultContent() {
		int totalFrames = driver.findElements(By.tagName("iframe")).size();
		System.out.println("total no of frames------" + totalFrames);
		driver.switchTo().defaultContent();
	}

	public void tearDown() {
		driver.close();
	}
}