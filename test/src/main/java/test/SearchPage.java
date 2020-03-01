package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {

	WebDriver driver;

	public void doSelectFilters() {
		WebElement a = driver.findElement(By.id("hotelfacility"));
		a.click();
	}
}
