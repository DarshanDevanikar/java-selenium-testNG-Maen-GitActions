package com.sample.pom;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	private WebDriver driver;
	protected String url;

	public LoginPage(WebDriver driver, Properties properties) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		url = properties.getProperty("prod.url");
	}

	@FindBy(name = "username")
	WebElement userName;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(partialLinkText = " Login ")
	WebElement submitButon;

	/**
	 * this method will login
	 * 
	 * @author {darshandevanikar}
	 */
	public Boolean login() {
		System.out.println("Login function called...");
		driver.get(url);
		System.out.println("url loaded=" + url);

		userName.clear();
		userName.sendKeys("Admin");

		password.clear();
		password.sendKeys("admin123");

		submitButon.click();

		if (url.contains("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index"))
			return true;
		else
			return false;
	}

}
