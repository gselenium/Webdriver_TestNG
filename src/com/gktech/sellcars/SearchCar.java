package com.gktech.sellcars;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.gktech.util.TestUtil;

public class SearchCar extends TestSuiteBase{
	static int count=-1;
	@BeforeTest
	public void checkTestCaseSkip(){
		applogs.debug("Verifing SearchCar test case runmode status");
		if(!TestUtil.testCaseRunnable(sellcarsxls, "SearchCar")){
			applogs.debug("Runmode of the testcase SearchCar is set as no, so skipping SearchCar test case");
			throw new SkipException("Runmode of the testcase SearchCar is set as no, so skipping SearchCar test case");
		}
		applogs.debug("Getting SearchCar test case runmodes");
		runmodes=TestUtil.gettestDataRunmodes(sellcarsxls, "SearchCar");
	}
	
	//Testcase
	@Test(dataProvider="getData")
	public void searchCar(String uname, String pass){		
		count++;
		if(!runmodes[count].equalsIgnoreCase("Y")){
			applogs.debug("Runmode of the SearchCar test case is set as no, so skipping row number: "+count);
			throw new SkipException("Runmode of the SearchCar test case is set as no, so skipping row number: "+count);
		}
		System.out.println("Executing SearchCar Test case");
		applogs.debug(uname+"==="+pass);
		System.out.println(uname+"==="+pass);
		//webdriver code
	}
	
	@DataProvider
	public Object[][] getData(){
		return TestUtil.getTestData(sellcarsxls, "SearchCar");
		
	}

}
