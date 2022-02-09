package hw8_2_2022_pages;
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
	
	public void getRoleInput(String role1) {
		Select role = new Select (driver.findElement(By.id("role")));
		role.selectByValue(role1);;
	}
	public WebElement getCommentInput(String comment) {
		return driver.findElement(By.id(comment));
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
	
	public void Add (String username, String gender, String dateOfBirth, String eMail, String role, String waysOfDev, String comment) {
		getNameInput().sendKeys(username);
		getRadioInput(gender);
		getDateOfBirthInput().sendKeys(dateOfBirth);
		getEmailInput().sendKeys(eMail);
		getRoleInput(role);
		getCheckBoxInput(waysOfDev);
		getCommentInput(comment);
		getButton().click();
		wait.until(ExpectedConditions.attributeContains(By.id("submit"), "style", "visibility: visible"));
	}
}
