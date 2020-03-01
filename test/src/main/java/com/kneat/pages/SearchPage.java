package com.kneat.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.kneat.commons.Utils;

public class SearchPage {
	private WebElement a;

	private Utils utils;

	public SearchPage(Utils utils) {
		this.utils = utils;
	}

	public void doSelectFilters() {
		a = utils.getDriver().findElement(By.id("hotelfacility"));
		a.click();
	}

	public void doSearch() {

	}
}
