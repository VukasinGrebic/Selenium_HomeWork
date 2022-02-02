package hw1_2_2022;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Task2 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "driver-lib/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://videojs.com/city");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(26));

		driver.findElement(By.xpath("//*[@title='Play Video']")).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@title='Play Video']")));
		System.out.println("Video loaded");
		wait1.until(ExpectedConditions.attributeToBe(By.xpath("//*[contains (@class, 'vjs-progress-holder')]"), "aria-valuenow", "100.00"));
		System.out.println("Video finished");

		driver.close();
	}

}

//Napisti program koji:
//Ucitava stranicu https://videojs.com/city
//Pusta video klikom na play dugme
//Cekamo da se video ucita
//Tako sto proveravamo da li vise to play dugme nije vidljivo

