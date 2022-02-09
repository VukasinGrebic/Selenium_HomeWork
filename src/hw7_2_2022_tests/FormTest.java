package hw7_2_2022_tests;

import java.io.File;

import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import hw7_2_2022_pages.FormPage;

public class FormTest {
	private WebDriver driver;
	private WebDriverWait wait;
	private FormPage fp;

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		driver = new ChromeDriver();
		fp = new FormPage(driver, wait);
		driver.manage().window().maximize();
		this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		this.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		File file = new File("file/form.html");
		driver.get(file.getAbsolutePath());
	}

	@Test
	public void Form() {
		fp.getNameInput().sendKeys("random");
		fp.getRadioInput("male");
		fp.getDateOfBirthInput().sendKeys("10.10.1910");
		fp.getEmailInput().sendKeys("email@email.com");
		fp.getRoleInput(1);
		fp.getCheckBoxInput("read_books");
		fp.getButton().click();
		

	}
	
	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
