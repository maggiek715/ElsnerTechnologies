package com.golden.basepage;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.Status;

public class CommonMethod extends BaseClass {

public static WebElement findElement (By locator) {
return driver.findElement(locator);
}
public static void clear(By locator) {
WebDriverWait wait= new WebDriverWait(driver,30);
wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
findElement(locator).clear();
log.info("Clear is done"+locator);
test.log(Status.PASS,"Clearing Text Field:"+locator);
}
public static void click(By locator) {
WebDriverWait wait= new WebDriverWait(driver,30);
wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
findElement(locator).click();
log.info("Click performed successfully"+locator);
}
public static void SendKeys(By locator, String data) {
WebDriverWait wait= new WebDriverWait(driver,30);
wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
findElement(locator).sendKeys(data);
log.info("Data entered succesfully"+locator);
}
public static String getTitle() {
return driver.getTitle();
}

public static void mouseHover(final WebDriver driver,By locator) throws IOException{
	
	Actions action = new Actions(driver);
	action.moveToElement(findElement(locator)).build().perform();
		
	
}


public static String getText(WebDriver driver, By locater) throws IOException {
	
	return findElement(locater).getText();
	
}

public static void SelectByVisibleText(By locator,String text) {
new Select(driver.findElement(locator)).selectByVisibleText(text);
log.info("Text selected successfully"+locator);
}

 public static void SelectByIntindex(By locator,int index) {
new Select(driver.findElement(locator)).selectByIndex(index);
log.info("Index value selected successfully"+locator);
}
public static void SelectByvalue(By locator,String value) {
new Select(driver.findElement(locator)).selectByValue(value);
log.info("Value selected successfully"+locator);
}

}