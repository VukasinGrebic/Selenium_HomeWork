package hw_4_2_2022;

import java.time.Duration;


import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task1 {
	private WebDriver driver;
	private WebDriverWait wait;

	
	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(5));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.navigate().to("https://www.kupujemprodajem.com/");
		driver.manage().window().maximize();
		
		
		
		
	}
	
	@Test
	public void KupujemProdajem(){

		try {
			driver.findElement(By.className("kpBoxCloseButton")).click();;
		} catch (Exception e) {
			System.out.println("No dialog");
		}
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("welcome-holder")));
		driver.findElement(By.className("searchKeywordsInput")).sendKeys("iphone");
		driver.findElement(By.className("searchButton")).click();
		driver.findElement(By.className("choiceLabel")).click();
		driver.findElement(By.xpath("//*[@id='menuGroup0']/div")).click();
//		

		
	}
	
	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}

// kupuje prodajem
//Ucitajte stranicu (ako treba gasite onaj dijalog sto iskace)
//Ukucajte za pretragu iphone
//postavice za valutu eure
//Sortirajte prema ceni da bude najjefinije prvo
//Onda izvrsite proveru sortiranja kao sto je bilo za udemy
