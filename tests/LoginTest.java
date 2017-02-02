package com.selenium.tests;

import java.io.File;
import java.awt.Component;
import java.awt.Frame;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Point;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.openqa.selenium.WebElement;

public class LoginTest {

	private static final Component frame = null;
	public static WebDriver driver;

	public static void main(String[] args) throws Exception {
		// download geckodriver.exe, taruh di spesific location
		System.setProperty("webdriver.gecko.driver", "E:/SoftwareQA/geckodriver/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://stageops.tiket.com/");

		// login
		try {
			driver.findElement(By.linkText("Login")).click();
			// email sndiri
			driver.findElement(By.cssSelector("input[placeholder='Email Anda'][name='email']")).sendKeys("");
			// password sendiri
			driver.findElement(By.cssSelector("input[placeholder='Kata Sandi'][name='password']")).sendKeys("");
			driver.findElement(By.cssSelector("button[name='Login']")).click();
			Thread.sleep(2000);
			String loginText = driver.findElement(By.className("profileView")).getText();
			Assert.assertNotEquals(loginText, "Login");
			Thread.sleep(3000);
			JOptionPane.showMessageDialog(frame, "Login berhasil");
			takeScreenShot("Login Berhasil");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(frame, "Login gagal");
			Thread.sleep(1000);
			takeScreenShot("Login Gagal");
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
