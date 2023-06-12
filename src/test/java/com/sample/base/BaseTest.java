package com.sample.base;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	protected WebDriver driver;
	private Properties properties;
	private String browser;

	
	/**
	 * This method will read properties from the  test/resources folder
	 * @return
	 * 
	 * @author {darshandevanikar}
	 */
	public Properties loadProperties() {
		properties = new Properties();
		try {
			properties
					.load(new BufferedReader(new FileReader("src//test//resources//data//init.parameters")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("File not found....");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		browser = properties.getProperty("browser");
		return properties;
		
	}
/**
 * this method will load properties and create webderiver instance
 * @author {darshandevanikar}
 */
	@BeforeTest
	public void init() {
		loadProperties();
		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().browserVersion("113.0.5672.126").setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-dev-shm-usage");
			options.addArguments("--headless");
			driver = new ChromeDriver(options);
			break;

		default:
			break;
		}

	}
	/**
	 * This will do the closure after running all tests
	 * @author {darshandevanikar}
	 */

	@AfterTest
	public void teardown() {

		driver.close();
	}
}
