package com.gktech.newcars;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.gktech.util.TestUtil;

public class Login extends TestSuiteBase{
	static int count=-1;
	@BeforeTest
	public void checkTestCaseSkip(){
		applogs.debug("Verifing Login test case runmode status");
		if(!TestUtil.testCaseRunnable(newcarsxls, "Login")){
			applogs.debug("Runmode of the testcase Login is set as no, so skipping Login test case");
			throw new SkipException("Runmode of the testcase Login is set as no, so skipping Login test case");
		}
		applogs.debug("Getting Login test case runmodes");
		runmodes=TestUtil.gettestDataRunmodes(newcarsxls, "Login");
	}
	
	//Testcase
	@Test(dataProvider="getData")
	public void login(String uname, String pass){		
		count++;
		if(!runmodes[count].equalsIgnoreCase("Y")){
			applogs.debug("Runmode of the Login test case is set as no, so skipping row number: "+count);
			throw new SkipException("Runmode of the Login test case is set as no, so skipping row number: "+count);
		}
		System.out.println("Executing Login Test case");
		applogs.debug(uname+"==="+pass);
		System.out.println(uname+"==="+pass);
		//webdriver code
		applogs.debug("Browser is opening for to execute Carwle Login test case:");
		OpenBrowser();
		applogs.debug("executing Carwle Login test case");
		driver.get("http://www.carwale.com/");
		getObject("logLink").click();
		getObject("logEmail").sendKeys(uname);
		getObject("logPass").sendKeys(pass);
		getObject("logButton").click();	
		
	}
	
	@DataProvider
	public Object[][] getData(){
		return TestUtil.getTestData(newcarsxls, "Login");
		
	}

}
