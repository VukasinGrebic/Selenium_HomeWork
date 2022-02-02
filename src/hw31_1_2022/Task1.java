package hw31_1_2022;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Task1 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "driver-lib/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.udemy.com/courses/search/?src=ukw&q=slksd");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		driver.findElement(By.xpath("//*[contains (@class, 'language-selector-button--button--1wgoL')]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[contains (@class, 'modal--dialog--3wvl7 modal--default-size--PTjsn')]")));
		System.out.println("Dialog showed");

		driver.close();
	}

}
