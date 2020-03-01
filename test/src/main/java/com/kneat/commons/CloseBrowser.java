package com.kneat.commons;

public class CloseBrowser {

	Utils utils;

	public CloseBrowser(Utils utils) {

		this.utils = utils;
	}

	public void doCloseBrowser() {

		utils.getDriver().close();
	}
}
