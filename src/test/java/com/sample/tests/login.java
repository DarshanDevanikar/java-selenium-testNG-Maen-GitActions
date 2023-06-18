package com.sample.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sample.base.Base;
import com.sample.pom.LoginPage;

public class login extends Base {
	LoginPage loginpage;

	@Test
	public void TC0001_login() {
		loginpage = new LoginPage(driver, properties);
		Assert.assertTrue(loginpage.login());
	}
}
