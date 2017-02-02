package com.selenium.tests;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.Component;
import java.awt.Frame;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HotelPositivePromo {
	private static final Component Frame = null;
	public static WebDriver driver;

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.gecko.driver", "E:/SoftwareQA/geckodriver/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://stageops.tiket.com/");

		try {
			JFrame frame = new JFrame("Enter Promocode");
			String promocode = JOptionPane.showInputDialog(frame, "Insert promocode");

			driver.findElement(By.linkText("Hotel")).click();
			Thread.sleep(3000);
			driver.findElement(By.className("icon-search")).click();
			Thread.sleep(3000);
			driver.findElement(By.linkText("The One Legian (formerly The 101 Hotel Legian)")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("buttonroom1185")).click();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			Thread.sleep(3000);
			driver.findElement(By.linkText("Kartu Kredit")).click();
			Thread.sleep(3000);
			driver.findElement(By.id("usepromo")).sendKeys(promocode);
			driver.findElement(By.id("btnRedeem")).click();
			Thread.sleep(3000);
			JOptionPane.showMessageDialog(frame, " Promocode " + promocode + " berhasil ditambahkan ");
			driver.findElement(By.id("fullname")).sendKeys("Laksmita");
			driver.findElement(By.id("phonenumber")).sendKeys("08562860652");
			driver.findElement(By.id("youremail")).sendKeys("testing@tiket.com");
			WebElement mySelectElement = driver.findElement(By.name("express_country"));
			org.openqa.selenium.support.ui.Select dropdown = new org.openqa.selenium.support.ui.Select(mySelectElement);
			dropdown.selectByVisibleText("Indonesia");
			// nomor cc
			driver.findElement(By.id("txt_card_number")).sendKeys("");
			WebElement month = driver.findElement(By.name("txt_expire_month"));
			org.openqa.selenium.support.ui.Select monthdropdown = new org.openqa.selenium.support.ui.Select(month);
			monthdropdown.selectByVisibleText("01 - Jan");

			WebElement tahun = driver.findElement(By.name("txt_expire_year"));
			org.openqa.selenium.support.ui.Select yeardropdown = new org.openqa.selenium.support.ui.Select(tahun);
			yeardropdown.selectByVisibleText("2019");

			driver.findElement(By.id("txt_card_holder_name")).sendKeys("Laksmita");
			//card 
			driver.findElement(By.id("txt_identification_number")).sendKeys("");

			driver.findElement(By.className("complete")).click();
			driver.switchTo().alert().accept();
			Thread.sleep(1000);
			takeScreenShot("Promocode pass");
			JOptionPane.showMessageDialog(frame, " Testing Promocode " + promocode + " pass!");
			Thread.sleep(10000);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(Frame, "Testing promocode failed!");
			Thread.sleep(1000);
			takeScreenShot("Promocode failed");
		}
		driver.quit();

	}

	// visible ss
	public static void takeScreenShot(String fileName) throws IOException {
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
