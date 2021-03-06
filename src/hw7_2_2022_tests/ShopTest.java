package hw7_2_2022_tests;
import java.io.File;

import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import hw7_2_2022_pages.NavigationPage;
import hw7_2_2022_pages.ProductPage;

public class ShopTest {
	private WebDriver driver;
	private WebDriverWait wait;
	private NavigationPage np;
	private ProductPage pp;

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		driver = new ChromeDriver();
		np = new NavigationPage(driver);
		pp = new ProductPage(driver, wait);
		driver.manage().window().maximize();
		this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		this.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
//		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.get("http://cms.demo.katalon.com/");
	}

	@Test
	public void Form() {
		np.getShopButton().click();
		pp.getProduct(1).click();
		pp.getNumber().clear();
		pp.getNumber().sendKeys("2");
		pp.getAddCartButton().click();
		pp.waitForMessage();
		pp.getViewCart().click();
		Assert.assertTrue(pp.enoughProducts(), "Didn't add 2");
		pp.getRemoveButton().click();
		Assert.assertTrue(pp.isDeleted(), "Didn't delete all");
		

	}
	
	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}

//2.Zadatak
//Napisati test koji:
//Ucitava stranicu http://cms.demo.katalon.com/
//Vrsi klik na Shop link iz navigacije
//Otvara stranicu prvog proizvoda klikom na karticu prvog proizvoda
//Dodaje proizvod u korpu sa kolicinom 2
//Verifikuje poruku nakon dodavanja ?has been added to your cart.?
//Odlazi u korpu klikom na dugme VIew Cart
//Verifikuje stanje u korpi, tj. da postoji proizvod sa kolicinom 2.
//Brise stavku iz korpe klikom na dugme x.
//Verifikuje poruku za praznu korpu.
//Osmislite pageve za ovaj zadatak!


