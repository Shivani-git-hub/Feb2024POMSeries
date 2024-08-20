package com.qa.opencart.utils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtil {

	private WebDriver driver;
	
	public JavaScriptUtil(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getTitleByJs() {
		JavascriptExecutor js = ((JavascriptExecutor) driver);

		return js.executeScript("return document.title").toString();
	}
	
	public void refreshBrowserByJs() {
		JavascriptExecutor js = ((JavascriptExecutor) driver);

		 js.executeScript("history.go(0)");
	}
	
	
	public String getURLByJs() {
		JavascriptExecutor js = ((JavascriptExecutor) driver);

		return js.executeScript("return document.URL").toString();
	}
	
	
	public void generateJSAlert(String mesg) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);

		js.executeScript("alert('"+mesg+"')");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		driver.switchTo().alert().accept();
	}
	
	public void generateJSConfirm(String mesg) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);

		js.executeScript("confirm('"+mesg+"')");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		driver.switchTo().alert().accept();
	}
	
	
	public void generateJSPrompt(String mesg, String value) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);

		js.executeScript("prompt('"+mesg+"')");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(value);
		alert.accept();
	}
	
	
	public void goBackWithJS() {
		JavascriptExecutor js = ((JavascriptExecutor) driver);

		js.executeScript("history.go(-1)");
	}
	
	public void goForwardWithJS() {
		JavascriptExecutor js = ((JavascriptExecutor) driver);

		js.executeScript("history.go(1)");
	}
	
	public void pageRefreshWithJS() {
		JavascriptExecutor js = ((JavascriptExecutor) driver);

		js.executeScript("history.go(0)");
	}
	
	public String getPageInnerText() {
		JavascriptExecutor js = ((JavascriptExecutor) driver);

		return js.executeScript("return document.documentElement.innerText;").toString();
	}
	
	public void scrollMiddlePageDown() {
		JavascriptExecutor js = ((JavascriptExecutor) driver);

		js.executeScript("window.scrollTo(0, document.body.scrollHeight/2);");
	}
	
	public void scrollPageDown() {
		JavascriptExecutor js = ((JavascriptExecutor) driver);

		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	}
	
	public void scrollPageDown(String height) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);

		js.executeScript("window.scrollTo(0, '"+height+"');");
	}
	
	public void scrollPageUp() {
		JavascriptExecutor js = ((JavascriptExecutor) driver);

		js.executeScript("window.scrollTo(document.body.scrollHeight, 0);");
	}
	
	public void scrollIntoView(WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);

		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	/**
	 * example: "document.body.style.zoom = '400.0%'"
	 * @param zoomPercentage
	 */
	public void zoomFirefoxChromeEdgeSafari(String zoomPercentage) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);

		String zoom = "document.body.style.zoom = '"+zoomPercentage+"%'";
		js.executeScript(zoom);
	}
	
	/**
	 * example: "document.body.style.MozTransform = 'scale(0.5)'; ";
	 * @param zoomPercentage
	 */
	public void zoomFirefox(String zoomPercentage) {
		String zoom = "document.body.style.MozTransform = 'scale("+zoomPercentage+")'";
		JavascriptExecutor js = ((JavascriptExecutor) driver);

		js.executeScript(zoom);
	}
	
	
	public void drawBorder(WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);

		js.executeScript("arguments[0].style.border='3px solid red'", element);
	}
	
	
	public void flash(WebElement element) {
		String bgcolor = element.getCssValue("backgroundColor");//grey-white
		for (int i = 0; i < 15; i++) {
			changeColor("rgb(0,200,0)", element);// green
			changeColor(bgcolor, element);// greywghite
		}
	}

	private void changeColor(String color, WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);
		//Green->gw->Green->gw

		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
		}
	}
	
	
	public void clickElementByJS(WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);

		js.executeScript("arguments[0].click();", element);
	}

	public void sendKeysUsingWithId(String id, String value) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);

		js.executeScript("document.getElementById('" + id + "').value='" + value + "'");
						  //document.getElementById('input-email').value ='tom@gmail.com'
	}
	
	
	

}
