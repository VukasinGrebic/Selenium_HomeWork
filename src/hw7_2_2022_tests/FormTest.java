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
		Assert.assertTrue(fp.waitForFormToBeSaved(), "Didn't save");
		

	}
	
	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}

//Zadatak
//Skinite form.html stranicu (iz ovog foldera za domaci) na svom racunaru i otvorite je u pretrazivacu, iskopirajte url stranice
//	Od klasa je potrebno:
//FormPage koja ima:
//getere za sve inpute
//geter za radio - //*[@name='gender'][@value='"+ radioValue +"'] - kao parametar prima value (male/female/middle) tog radio dugmeta
//geter za checkbox inpute - //*[@type='checkbox'][@value='"+ checkboxValue +"']  - kao parametar prima value (read_books, online_courses, opensource, tech_cons, tech_blogs, via_delivery - jednu od ovde navedenih) tog checkbox inputa
//getter koji hvata dugme treba da ceka da element postane klikabilan pre nego sto vrati element. Koristite waiter za ovaj slucaj.
//metodu koja vraca da li su podaci uspesno sacuvani, tako sto proverava da li element koji nosi poruku za atribut style ima vrednost "visibility: visible"
//
//FormTest
//Ucitava stranicu
//Popunite formu proizvoljnim podacima
//Submitujte formu 
//Proverite da li su podaci uspesno sacuvani. (imate metodu iz page-a koja vam vraca da li je uspesno sacuvano, iskorisite je)
//U AfterClass metodi zatvaramo stranicu

