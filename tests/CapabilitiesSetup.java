package com.selenium.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;

public class CapabilitiesSetup {
	WebDriver driver;

	@BeforeClass
	public void setAuto() throws Exception {
		System.setProperty("webdriver.gecko.driver", "E:/SoftwareQA/geckodriver/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://stageops.tiket.com/");
	}

	@AfterClass
	public void tearDown() throws Exception {
		Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("E:/hasilss/");
		this.driver.quit();
	}
}
