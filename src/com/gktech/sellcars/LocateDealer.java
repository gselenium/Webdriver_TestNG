package com.gktech.sellcars;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.gktech.util.TestUtil;

public class LocateDealer extends TestSuiteBase{
	static int count=-1;
	@BeforeTest
	public void checkTestCaseSkip(){
		applogs.debug("Verifing LocateDealer test case runmode status");
		if(!TestUtil.testCaseRunnable(sellcarsxls, "LocateDealer")){
			applogs.debug("Runmode of the testcase LocateDealer is set as no, so skipping LocateDealer test case");
			throw new SkipException("Runmode of the testcase LocateDealer is set as no, so skipping LocateDealer test case");
		}
		applogs.debug("Getting LocateDealer test case runmodes");
		runmodes=TestUtil.gettestDataRunmodes(sellcarsxls, "LocateDealer");
	}
	
	//Testcase
	@Test(dataProvider="getData")
	public void locateDealer(String uname, String pass){		
		count++;
		if(!runmodes[count].equalsIgnoreCase("Y")){
			applogs.debug("Runmode of the LocateDealer test case is set as no, so skipping row number: "+count);
			throw new SkipException("Runmode of the LocateDealer test case is set as no, so skipping row number: "+count);
		}
		System.out.println("Executing LocateDealer Test case");
		applogs.debug(uname+"==="+pass);
		System.out.println(uname+"==="+pass);
		//webdriver code
	}
	
	@DataProvider
	public Object[][] getData(){
		return TestUtil.getTestData(sellcarsxls, "LocateDealer");
		
	}

}
