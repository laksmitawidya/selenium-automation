package com.selenium.tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;

public class SeleniumWebTesting extends CapabilitiesSetup {

	@Test(priority = 0)
	public void login() throws InterruptedException {
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.cssSelector("input[placeholder='Email Anda'][name='email']"))
				.sendKeys("");
		driver.findElement(By.cssSelector("input[placeholder='Kata Sandi'][name='password']"))
				.sendKeys("");
		driver.findElement(By.cssSelector("button[name='Login']")).click();
		Thread.sleep(2000);
		String loginText = driver.findElement(By.className("profileView")).getText();
		Assert.assertNotEquals(loginText, "Login");
		Thread.sleep(10000);
	}

	@Test(priority = 1)
	public void promohotel() throws InterruptedException {
		JFrame frame = new JFrame("Enter Promocode");
		String promocode = JOptionPane.showInputDialog(frame, "Insert promocode");
		driver.findElement(By.linkText("Hotel")).click();
		Thread.sleep(3000);
		driver.findElement(By.className("icon-search")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("The Sunset Hotel & Restaurant")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("buttonroom2179")).click();
		driver.switchTo().alert().accept();
		driver.findElement(By.id("usepromo")).sendKeys(promocode);
		driver.findElement(By.id("btnRedeem")).click();
		Thread.sleep(4000);
		driver.findElement(By.linkText("Kartu Kredit")).click();
		Thread.sleep(4000);
		
		// insert identitiy
		driver.findElement(By.id("fullname")).sendKeys("Testin Hotel");
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
		Thread.sleep(10000);
	}

	@Test(priority = 2)
	public void promoevent() throws InterruptedException {
		JFrame frame = new JFrame("Enter Promocode");
		String promocode = JOptionPane.showInputDialog(frame, "Insert promocode");
		WebElement chooseamount = driver.findElement(By.cssSelector("select[class='event_qty'][id='quantity2']"));
		Select amountdropdown = new Select(chooseamount);
		amountdropdown.selectByVisibleText("2");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("button[type='submit'][name='paynow']")).click();
		driver.findElement(By.id("usepromo")).sendKeys(promocode);
		driver.findElement(By.id("btnRedeem")).click();
		Thread.sleep(3000);

		// choose payment
		driver.findElement(By.linkText("Kartu Kredit")).click();
		Thread.sleep(3000);
		
		// insert identity
		driver.findElement(By.id("fullname")).sendKeys("");
		driver.findElement(By.id("phonenumber")).sendKeys("");
		driver.findElement(By.id("youremail")).sendKeys("");
		WebElement mySelectElement = driver.findElement(By.name("express_country"));
		org.openqa.selenium.support.ui.Select dropdown = new org.openqa.selenium.support.ui.Select(mySelectElement);
		dropdown.selectByVisibleText("Indonesia");
		
		// insert cc dummy number
		driver.findElement(By.id("txt_card_number")).sendKeys("");
		WebElement month = driver.findElement(By.name("txt_expire_month"));
		org.openqa.selenium.support.ui.Select monthdropdown = new org.openqa.selenium.support.ui.Select(month);
		monthdropdown.selectByVisibleText("01 - Jan");

		WebElement tahun = driver.findElement(By.name("txt_expire_year"));
		org.openqa.selenium.support.ui.Select yeardropdown = new org.openqa.selenium.support.ui.Select(tahun);
		yeardropdown.selectByVisibleText("2019");
		
		// insert cvv number
		driver.findElement(By.id("txt_card_holder_name")).sendKeys("");
		driver.findElement(By.id("txt_identification_number")).sendKeys("");

		driver.findElement(By.className("complete")).click();
		driver.switchTo().alert().accept();
		Thread.sleep(10000);
	}

}
