package hw;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1 {

	public static void main(String[] args) throws InterruptedException {
		Scanner s = new Scanner(System.in);
		System.setProperty("webdriver.chrome.driver", "driver-lib/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		int n = 0;
		driver.navigate().to("https://s.bootsnipp.com/iframe/WaXlr");
		driver.manage().window().maximize();
		
		List <WebElement> stars = driver.findElements(By.xpath("//*[@class='form-group']/button"));
		
		System.out.println("Enter number (1-5): ");
		n = s.nextInt();
		
		
//		if (n <= 5) {
//			driver.findElement(By.id("rating-star-" + Integer.toString(n))).click();
//			Thread.sleep(5000);
//		} else {
//			System.out.println("Wrong number");
//		}
		
		if (n <= 5) {
			stars.get(n-1).click();
			Thread.sleep(5000);
		} else {
			System.out.println("Wrong number");
		}
		
		driver.close();
		

	}

}

//Maksimizirati prozor
//Ucitati stranicu https://s.bootsnipp.com/iframe/WaXlr
//Od korisnika ucitati broj na koju zvezdicu je potrebno kliknuti (u rasponu od 1 do 5)
//I izvrsite akciju klik na odgovarajuci element
//Na kraju programa ugasite pretrazivac.
