package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.errors.AppError;
import com.qa.opencart.utils.ExcelUtil;
import com.qa.opencart.utils.StringUtils;

public class RegisterPageTest extends BaseTest{
	
	@BeforeClass
	public void regSetup() {
		regPage = loginPage.navigateToRegisterPage();
	}
	
	
	
	@DataProvider
	public Object[][] userRegTestData() {
		return new Object[][] {
			{"Kavi", "selenium", "9876543223", "kavi@123","yes"},
			{"Amit", "sharma", "7876543223", "amit@123","no"},
			{"Praful", "automation", "6876543223", "praful@123","yes"}
		};
	}
	@DataProvider
	public Object[][] userRegTestDataFromSheet() {
		return ExcelUtil.getTestData(AppConstants.REGISTER_SHEET_NAME);
		
		
	}
	
	@DataProvider
	public Object[][] userRegTestDataFromCSV() {
		return ExcelUtil.getTestData(AppConstants.REGISTER_SHEET_NAME);
		
		
	}
	
	
	
	@Test(dataProvider = "userRegTestDataFromCSV")
	public void userRegisterationTest(String firstName, String lastName, String telephone, String password, String subscribe) {
		
		Assert.assertTrue(regPage.userRegister(firstName, lastName, StringUtils.getRandomEmailId(), telephone, password, subscribe),AppError.USER_REG_NOT_DONE);		
		
		//Assert.assertTrue(regPage.userRegister(firstName, lastName, lastName,StringUtils.getRandomEmailId(), telephone, password, subscribe),AppError.USER_REG_NOT_DONE);
		
	}

}
