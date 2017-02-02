package com.selenium.tests;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.Component;
import java.awt.Frame;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;
import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

public class HotelPositivePromo {
	private static final Component Frame = null;
	public static WebDriver driver;

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.gecko.driver", "E:/SoftwareQA/geckodriver/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://stageops.tiket.com/");

		try {

			driver.findElement(By.linkText("Hotel")).click();
			Thread.sleep(3000);
			driver.findElement(By.className("icon-search")).click();
			Thread.sleep(3000);
			driver.findElement(By.linkText("The Sunset Hotel & Restaurant")).click();
			Thread.sleep(3000);
			driver.findElement(By.id("buttonroom2179")).click();
			driver.switchTo().alert().accept();
			Thread.sleep(3000);
			JFrame frame = new JFrame("Enter Promocode");
			String promocode = JOptionPane.showInputDialog(frame, "Insert promocode");
			driver.findElement(By.linkText("Kartu Kredit")).click();
			Thread.sleep(4000);
			driver.findElement(By.id("usepromo")).sendKeys(promocode);
			driver.findElement(By.id("btnRedeem")).click();
			Thread.sleep(4000);

			JOptionPane.showMessageDialog(frame, " Promocode " + promocode + " berhasil ditambahkan ");
			Thread.sleep(3000);
			Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("E:/hasilss/");
			Thread.sleep(10000);
			// insert identitiy
			driver.findElement(By.id("fullname")).sendKeys("");
			driver.findElement(By.id("phonenumber")).sendKeys("");
			driver.findElement(By.id("youremail")).sendKeys("");
			WebElement mySelectElement = driver.findElement(By.name("express_country"));
			org.openqa.selenium.support.ui.Select dropdown = new org.openqa.selenium.support.ui.Select(mySelectElement);
			dropdown.selectByVisibleText("Indonesia");
			driver.findElement(By.id("txt_card_number")).sendKeys("");
			WebElement month = driver.findElement(By.name("txt_expire_month"));
			org.openqa.selenium.support.ui.Select monthdropdown = new org.openqa.selenium.support.ui.Select(month);
			monthdropdown.selectByVisibleText("01 - Jan");

			WebElement tahun = driver.findElement(By.name("txt_expire_year"));
			org.openqa.selenium.support.ui.Select yeardropdown = new org.openqa.selenium.support.ui.Select(tahun);
			yeardropdown.selectByVisibleText("2019");

			driver.findElement(By.id("txt_card_holder_name")).sendKeys("");
			driver.findElement(By.id("txt_identification_number")).sendKeys("");

			driver.findElement(By.className("complete")).click();
			driver.switchTo().alert().accept();
			Thread.sleep(1000);
			JOptionPane.showMessageDialog(frame, " Testing Promocode " + promocode + " pass!");
			Thread.sleep(10000);
			Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("E:/hasilss/");
			Thread.sleep(10000);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(Frame, "Testing promocode failed!");
			Thread.sleep(1000);
			Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save("E:/hasilss/");
		}
		driver.quit();

	}

	// visible ss

	public static void takeVisibleScreenShot(String fileName) throws IOException {
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File screenshotLocation = new File("E:/hasilss/" + fileName + ".jpg");
		int i = 0;
		while (screenshotLocation.exists()) {
			i += 1;
			screenshotLocation = new File("E:/hasilss/" + fileName + "(" + i + ").jpg");
		}
		FileUtils.copyFile(screenshot, screenshotLocation);
	}
}
