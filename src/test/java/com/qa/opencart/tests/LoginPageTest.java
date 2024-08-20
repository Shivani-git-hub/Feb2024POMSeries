package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.errors.AppError;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
@Epic("Epic 100: Design open cart application with shopping workflow")
@Story("US 101: Design login page for open cart application")@Owner("Shivani")

//@Listeners({ExtentReportListener.class, TestAllureListener.class})
public class LoginPageTest extends BaseTest{

	//positive test case 
	@Description("checking login page title test-----")
	@Severity(SeverityLevel.MINOR)
	@Owner("Shivani")
	@Issue("Login-1234")//bug id number
	@Feature("login page title features")
	
	
	@Test(priority = 1)
	public void loginPageTitleTest() {
		String actTitle= loginPage.getLoginPageTitle();
		Assert.assertEquals(actTitle, AppConstants.LOGIN_PAGE_TITLE, AppError.TITLE_NOT_FOUND);
		
	}
	
	@Description("checking login page url-----")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 2)
	@Feature("login page url features")

	public void loginPageURLTest() {
		String actURL= loginPage.getLoginPageURL();
		Assert.assertTrue(actURL.contains(AppConstants.LOGIN_PAGE_FRACTION_URL), AppError.URL_NOT_FOUND);
		
	}
	
	@Description("checking forgot pwd link exit on the login page-----")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 3)
	@Feature("login page forgot pwd features")

	public void ForgotPwdLinkExistTest() {
		Assert.assertTrue(loginPage.checkForgotPwdLinkExist(), AppError.ELEMENT_NOT_FOUND);
		
	}
	
	@Description("checking user is able to login successfully-----")
	@Severity(SeverityLevel.BLOCKER)
	@Test(priority = 4)
	@Feature("login page  features")

	public void loginTest() {
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals(accPage.getAccPageTitle(), AppConstants.ACCOUNTS_PAGE_TITLE, AppError.TITLE_NOT_FOUND);
		
		
	}
	
	
	
}
