package com.kneat.commons;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {

	private WebDriver driver;

	public WebDriver getDriver() {
		return this.driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public void waitForElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(this.driver, 300);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void scrollIntoView(WebElement locator, WebDriver driver) {

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", locator);

	}
}
