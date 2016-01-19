package com.gktech.usedcars;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.gktech.util.TestUtil;

public class SearchUsedCars extends TestSuiteBase{
	static int count=-1;
	@BeforeTest
	public void checkTestCaseSkip(){
		applogs.debug("Verifing SearchUsedCars test case runmode status");
		if(!TestUtil.testCaseRunnable(usedcarsxls, "SearchUsedCars")){
			applogs.debug("Runmode of the testcase SearchUsedCars is set as no, so skipping SearchUsedCars test case");
			throw new SkipException("Runmode of the testcase SearchUsedCars is set as no, so skipping SearchUsedCars test case");
		}
		applogs.debug("Getting SearchUsedCars test case runmodes");
		runmodes=TestUtil.gettestDataRunmodes(usedcarsxls, "SearchUsedCars");
	}
	
	//Testcase
	@Test(dataProvider="getData")
	public void searchUsedCars(String uname, String pass){		
		count++;
		if(!runmodes[count].equalsIgnoreCase("Y")){
			applogs.debug("Runmode of the SearchUsedCars test case is set as no, so skipping row number: "+count);
			throw new SkipException("Runmode of the SearchUsedCars test case is set as no, so skipping row number: "+count);
		}
		System.out.println("Executing SearchUsedCars Test case");
		applogs.debug(uname+"==="+pass);
		System.out.println(uname+"==="+pass);
		//webdriver code
	}
	
	@DataProvider
	public Object[][] getData(){
		return TestUtil.getTestData(usedcarsxls, "SearchUsedCars");
		
	}

}
