package hw_4_2_2022;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
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
		wait.until(ExpectedConditions.textToBePresentInElementValue(By.className("searchKeywordsInput"), "iphone"));
		driver.findElement(By.className("searchButton")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("priceSec")));
		driver.findElement(By.className("choiceLabel")).click();
		driver.findElement(By.xpath("//*[@id='menuGroup0']/div")).click();
		driver.findElement(By.className("choiceLabelText")).click();
		driver.findElement(By.xpath("//*[@value='eur']")).click();
		
		
		List<WebElement> prices = driver.findElements(By.className("adPrice "));
		
		
		
		Assert.assertTrue(firstItemcheaper(prices), "It's in right order");

		
	}
	
	public boolean firstItemcheaper (List<WebElement> prices) {
		return Double.valueOf(prices.get(0).getText()) < Double.valueOf(prices.get(29).getText());
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
//Dohvatite rejting prvog rezultata pretrage
//Dohvatite rejting zadnjeg rezultata pretrage (HELP: trebace vam getText metoda)
//	[HELP] Dohvatite rejting kao listu  pa iz liste izvucite prvi i zadnji element.
//Proverite da li je reting prvog veci od rejtinga zadnjeg rezultata
//pretvaranje stringa u double link ce vam trebati za ovaj zadatak
