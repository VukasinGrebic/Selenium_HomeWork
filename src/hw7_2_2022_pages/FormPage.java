package hw7_2_2022_pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class FormPage {
	private WebDriver driver;
	private WebDriverWait wait;

	public FormPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	public WebElement getNameInput() {
		return driver.findElement(By.id("first-name"));
	}
	
	public WebElement getRadioInput(String radioValue) {
		return driver.findElement(By.xpath("//*[@name='gender'][@value='"+ radioValue +"']"));
	}
	
	
	public WebElement getDateOfBirthInput() {
		return driver.findElement(By.id("dob"));
	}
	
	public WebElement getEmailInput() {
		return driver.findElement(By.id("email"));
	}
	
	public void getRoleInput(int index) {
		Select role = new Select (driver.findElement(By.id("role")));
		role.selectByIndex(index);
	}
	public WebElement getCommentInput() {
		return driver.findElement(By.id("comment"));
	}
	
	public WebElement getCheckBoxInput(String checkboxValue) {
		return driver.findElement(By.xpath("//*[@type='checkbox'][@value='"+ checkboxValue +"']"));
	}
	
	public WebElement getButton () {
		return driver.findElement(By.id("submit"));
	}
	public boolean waitForFormToBeSaved () {
		try {
			wait.until(ExpectedConditions.attributeContains(By.id("submit"), "style", "visibility: visible"));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}