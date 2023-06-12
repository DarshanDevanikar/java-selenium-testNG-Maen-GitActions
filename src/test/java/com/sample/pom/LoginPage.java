package com.sample.pom;

import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * this method will login
	 * 
	 * @author {darshandevanikar}
	 */
	public Boolean login() {
		System.out.println("Login function called...");
		driver.get("https://google.com");
		
		String url = driver.getCurrentUrl();
		if (url.contains("google"))
			return true;
		else
			return false;
	}
}
