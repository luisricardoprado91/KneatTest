package com.kneat.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.kneat.commons.CloseBrowser;
import com.kneat.commons.OpenBrowser;
import com.kneat.commons.Utils;

public class Tests {

	private String url = "http://booking.com";
	private Utils utils;

	@Before
	public void before() {
		utils = new Utils();
		OpenBrowser openBrowser = new OpenBrowser(utils);
		openBrowser.doOpenBrowser();
		utils.getDriver().get(url);
	}

	@After
	public void after() {
		CloseBrowser closeBrowser = new CloseBrowser(utils);
		closeBrowser.doCloseBrowser();
	}

	@Test
	public void Test1() {

	}

}
