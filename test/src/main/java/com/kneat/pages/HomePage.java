package com.kneat.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.kneat.commons.Utils;

public class HomePage {

	private WebElement localInput;
	private WebElement datesInput;
	private WebElement datesInputNextButn;
	private WebElement searchBtn;
	private int dayOfToday;

	private Utils utils;

	public HomePage(Utils utils) {

		this.utils = utils;

	}

	private int dayOfToday() {

		WebElement datesInputRightTable = utils.getDriver()
				.findElement(By.xpath("//td[@class='bui-calendar__date bui-calendar__date--today']"));

		dayOfToday = Integer.parseInt(datesInputRightTable.getText());

		return dayOfToday;
	}

	public void dayThreeMonthsFromToday(int dayOfToday) {

		WebElement datesInputRightTable = utils.getDriver()
				.findElement(By.xpath("//form[1]//div[1]//div[2]//div[2]//div[1]//div[1]//div[3]//div[2]//table[1]"));

		List<WebElement> trs = datesInputRightTable.findElements(By.cssSelector("tr"));

		for (WebElement tr : trs) {
			boolean stop = false;
			List<WebElement> tds = tr.findElements(By.cssSelector("td"));
			for (WebElement td : tds) {
				List<WebElement> spans = tr.findElements(By.cssSelector("span"));
				for (WebElement span : spans) {
					List<WebElement> spans2 = span.findElements(By.cssSelector("span"));
					for (WebElement span1 : spans2) {
						int dayOfTd = Integer.parseInt(span1.getText());
						if (dayOfTd == dayOfToday) {
							td.click();
						}
						if (dayOfTd + 1 == dayOfToday + 1) {
							td.click();
							stop = true;
						}
					}
					if (stop == true) {
						break;
					}
				}
				if (stop == true) {
					break;
				}
			}
		}
	}

	public WebElement getLocalInput() {
		localInput = utils.getDriver().findElement(By.id("ss"));
		return localInput;
	}

	public WebElement getDatesInput() {
		datesInput = utils.getDriver().findElement(By.xpath("//div[@class='xp__dates xp__group']"));
		return datesInput;

	}

	public WebElement getDatesInputNextButn() {
		datesInputNextButn = utils.getDriver()
				.findElement(By.xpath("//div[contains(@class,'bui-calendar__control bui-calendar__control--next')]"));
		return datesInputNextButn;
	}

	public int getDayOfToday() {

		return dayOfToday();
	}

	public WebElement getSearchBtn() {
		searchBtn = utils.getDriver().findElement(By.xpath("//button[contains(@class,'js-sb-submit-button')]"));
		return searchBtn;
	}

}
