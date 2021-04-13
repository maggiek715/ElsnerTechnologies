package com.golden.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.golden.basepage.BaseClass;
import com.golden.basepage.CommonMethod;

public class Loginpage extends BaseClass {
	
	public By SigninAccount=By.xpath("//span[text()='SIGN IN/ACCOUNT']");
	public By Signin=By.xpath("//*[@id=\"ui-id-1\"]/ul/li[5]/a");
	
	
	public By Email= By.id("email");
	public By Password=By.id("pass");
	public By robot= By.xpath("//*[@id=\"recaptcha-anchor\"]/div[1]");
	public By Signin_button=By.id("send2");
	public By SignOut_Account=By.xpath("//span[text()='SIGN OUT/ACCOUNT']");


	public void valid_Login() throws InterruptedException, IOException 
	{
	CommonMethod.mouseHover(driver, SigninAccount);
	CommonMethod.click(Signin);
	Thread.sleep(5000);
	CommonMethod.SendKeys(Email, "automationmadhavi@gmail.com");
	CommonMethod.SendKeys(Password, "Sudha@59");
	CommonMethod.click(robot);
	CommonMethod.click(Signin_button);
	Thread.sleep(5000);
	//assertEqual(SignOut_Account.isDisplayed(), true);
	
	String Expectedresult = "SIGN OUT/ACCOUNT";
	String Actualresult = CommonMethod.getText(driver, SignOut_Account);
	Assert.assertEquals(Actualresult, Expectedresult);
	
	
	
	}
	}


