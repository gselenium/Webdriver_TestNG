package com.gktech.usedcars;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.gktech.util.TestUtil;

public class UsedCarValuation extends TestSuiteBase{
	static int count=-1;
	@BeforeTest
	public void checkTestCaseSkip(){
		applogs.debug("Verifing UsedCarValuation test case runmode status");
		if(!TestUtil.testCaseRunnable(usedcarsxls, "UsedCarValuation")){
			applogs.debug("Runmode of the testcase UsedCarValuation is set as no, so skipping UsedCarValuation test case");
			throw new SkipException("Runmode of the testcase UsedCarValuation is set as no, so skipping UsedCarValuation test case");
		}
		applogs.debug("Getting UsedCarValuation test case runmodes");
		runmodes=TestUtil.gettestDataRunmodes(usedcarsxls, "UsedCarValuation");
	}
	
	//Testcase
	@Test(dataProvider="getData")
	public void usedCarValuation(String uname, String pass){		
		count++;
		if(!runmodes[count].equalsIgnoreCase("Y")){
			applogs.debug("Runmode of the UsedCarValuation test case is set as no, so skipping row number: "+count);
			throw new SkipException("Runmode of the UsedCarValuation test case is set as no, so skipping row number: "+count);
		}
		System.out.println("Executing UsedCarValuation Test case");
		applogs.debug(uname+"==="+pass);
		System.out.println(uname+"==="+pass);
		//webdriver code
	}
	
	@DataProvider
	public Object[][] getData(){
		return TestUtil.getTestData(usedcarsxls, "UsedCarValuation");
		
	}

}
