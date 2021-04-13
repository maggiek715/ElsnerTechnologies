package com.golden.test;

import java.io.IOException;

import org.testng.annotations.Test;

import com.golden.basepage.BaseClass;
import com.golden.qa.pages.Loginpage;

public class SmokeTest extends BaseClass{
	Loginpage userlogin = new Loginpage();
	
	
	@Test(priority=1)
	public void Login() throws InterruptedException, IOException 
	{
		test=extent.createTest("Loginpage Test");
		userlogin.valid_Login();	
	}
	
	
	

}
