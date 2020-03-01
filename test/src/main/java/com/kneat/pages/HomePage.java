package com.kneat.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.kneat.commons.Utils;

public class HomePage {

	private WebElement localInput;
	private WebElement datesInput;
	private WebElement datesInputNextButn;
	private WebElement datesInputToday;
	private WebElement searchBtn;

	private Utils utils;

	public HomePage(Utils utils) {

		this.utils = utils;

		localInput = utils.getDriver().findElement(By.id("ss"));
		datesInput = utils.getDriver().findElement(By.xpath("//div[@class='xp__dates xp__group']"));
		datesInputNextButn = utils.getDriver()
				.findElement(By.xpath("//div[contains(@class,'bui-calendar__control bui-calendar__control--next')]"));
		datesInputToday = utils.getDriver()
				.findElement(By.xpath("//td[contains(@class,'bui-calendar__date bui-calendar__date--today')]"));
		searchBtn = utils.getDriver().findElement(By.xpath("//button[contains(@class,'js-sb-submit-button')]"));

	}

	public void doFillTheInputs() {

		utils.waitForElement(localInput);

		localInput.click();
		localInput.sendKeys("Limerick");

		datesInput.click();

		int dayOfToday = Integer.parseInt(datesInputToday.getText());
		for (int i = 1; i <= 3; i++) {
			datesInputNextButn.click();
		}
		dayThreeMonthsFromToday(dayOfToday);

		searchBtn.click();
	}

	private void dayThreeMonthsFromToday(int dayOfToday) {

		WebElement datesInputRightTable = utils.getDriver()
				.findElement(By.xpath("//div[contains(@class,'xp-calendar')]//div[2]//table[1]"));

		List<WebElement> trs = datesInputRightTable.findElements(By.cssSelector("tr"));

		for (WebElement tr : trs) {
			List<WebElement> tds = tr.findElements(By.cssSelector("td"));
			for (WebElement td : tds) {
				int dayOfTd = Integer.parseInt(td.getText());
				if (dayOfTd == dayOfToday) {
					td.click();
				}
				if (dayOfTd + 1 == dayOfToday + 1) {
					td.click();
				}
			}
		}
	}
}
