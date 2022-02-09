package hw8_2_2022_tests;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import hw8_2_2022_pages.FormPage;

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
		File file1 = new File("file/form.html");
		driver.get(file1.getAbsolutePath());
		
	}

	@Test
	public void Form() throws IOException {
		File file = new File("Data/FormData.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("form");
		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			String username = sheet.getRow(i).getCell(0).getStringCellValue();
			String gender = sheet.getRow(i).getCell(1).getStringCellValue();
			String dateOfBirth = sheet.getRow(i).getCell(2).getStringCellValue();
			String eMail = sheet.getRow(i).getCell(3).getStringCellValue();
			String role = sheet.getRow(i).getCell(4).getStringCellValue();
			String waysOfDev = sheet.getRow(i).getCell(5).getStringCellValue();
			String comment = sheet.getRow(i).getCell(6).getStringCellValue();
			fp.Add(username, gender, dateOfBirth, eMail, role, waysOfDev, comment);
			Assert.assertTrue(fp.waitForFormToBeSaved(), "Didn't save");
		}
	}
		


	
	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}

//Zadatak
//Za potrebe zadatka kreirati FormPage koji ima sve potrebne metode.
//	Zatim kreirati FormTest koji 
//Ucitava form.html stranicu (form.html je u folderu za domaci skinite je i otvorite u chrome i iskopirajte url)
//I popunjava formu koristeci FormData.xlsx fajl (u folderu je za domaci)
//Postavite odgovarajuce waitere tako da se saceka sledeci unos podataka u formu nakon submitovanja

