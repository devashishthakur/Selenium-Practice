package com.sapient.publicis;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestNgClass {
	WebDriver driver;
	String baseURL = "https://www.calculator.net/";

	@BeforeTest
	@Parameters("browser")
	public void openBrowser(String browser) {
		try {
			if (browser.equalsIgnoreCase("Firefox")) {
				driver = new FirefoxDriver();
			} else if (browser.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();
			}
		} catch (WebDriverException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void calc() throws InterruptedException {

		driver.get(baseURL);
		
		driver.findElement(By.cssSelector("tbody:nth-child(1) tr:nth-child(1) td:nth-child(3) div.hh > a:nth-child(1)")).click();

		driver.findElement(By.cssSelector("table.smtb:nth-child(5) tbody:nth-child(1) tr:nth-child(1) td.sectionlists div:nth-child(3) > a:nth-child(1)")).click();

		driver.findElement(By.cssSelector("#cpar1")).sendKeys("20");

		driver.findElement(By.cssSelector("#cpar2")).sendKeys("190");
		
		driver.findElement(By.cssSelector("table.panel:nth-child(4) tbody:nth-child(2) tr:nth-child(2) td:nth-child(1) > input:nth-child(2)")).click();

		String text = driver.findElement(By.cssSelector("div:nth-child(3) div:nth-child(1) p.verybigtext:nth-child(5) font:nth-child(1) > b:nth-child(1)")).getText();
		
		driver.close();

		Assert.assertEquals(text, "38");
				
	}
}
