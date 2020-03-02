package com.kneat.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.kneat.commons.Utils;

public class SearchPage {
	private WebElement resultFrame;
	private WebElement filterFacilitiesShowAll;
	private WebElement filterFacilitiesSpaAndWellnessCentre;
	private WebElement filterFunThingsToDoSauna;
	private WebElement category5Stars;

	private Utils utils;

	public SearchPage(Utils utils) {
		this.utils = utils;

	}

	public WebElement getResultFrame() {
		resultFrame = utils.getDriver().findElement(By.id("searchresultsTmpl"));
		return resultFrame;
	}

	public WebElement getFilterFacilitiesShowAll() {

		filterFacilitiesShowAll = utils.getDriver().findElement(By.xpath("//button[contains(text(),'Show all 13')]"));
		return filterFacilitiesShowAll;
	}

	public WebElement getFilterFacilitiesSpaAndWellnessCentre() {

		filterFacilitiesSpaAndWellnessCentre = utils.getDriver()
				.findElement(By.xpath("//div[@id='filter_facilities']//a[10]"));
		return filterFacilitiesSpaAndWellnessCentre;
	}

	public WebElement getFilterFunThingsToDoSauna() {

		filterFunThingsToDoSauna = utils.getDriver()
				.findElement(By.xpath("//div[@id='filter_popular_activities']//a[3]"));
		return filterFunThingsToDoSauna;
	}

	public WebElement getCategory5Stars() {
		category5Stars = utils.getDriver().findElement(By.xpath("//div[@id='filter_class']//a[3]"));
		return category5Stars;
	}
}
