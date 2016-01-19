package com.gktech.newcars;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.gktech.util.TestUtil;

public class Registration extends TestSuiteBase{
	static int count=-1;
	@BeforeTest
	public void checkTestCaseSkip(){
		if(!TestUtil.testCaseRunnable(newcarsxls, "Registration")){
			throw new SkipException("Runmode of the Registration test case is set as no, so skipping Registration test case");
		}
		runmodes=TestUtil.gettestDataRunmodes(newcarsxls, "Registration");
	}
	
	//test case
	@Test(dataProvider="getData")
	public void registration(String name, String email, String mobile, String password, String confpass){
		count++;
		if(!runmodes[count].equalsIgnoreCase("Y")){
			throw new SkipException("Runmode of the test data is set as no, so skipping row number: "+count);
		}
		System.out.println("Executing Registration Test case");
		System.out.println(name+"==="+email+"==="+mobile+"==="+password+"==="+confpass);
		//webdriver code
		OpenBrowser();
		driver.get(CONFIG.getProperty("baseUrl"));
		getObject("logLink").click();
		getObject("regSignup").click();
		getObject("regname").sendKeys(name);
		getObject("regemail").sendKeys(email);
		getObject("regmobile").sendKeys(mobile);
		getObject("regpass").sendKeys(password);
		getObject("regconfpass").sendKeys(confpass);
		getObject("regsignupbutton").click();
		
	}
	
	@DataProvider
	public Object[][] getData(){
		return TestUtil.getTestData(newcarsxls, "Registration");
		
	}

}
