package com.gktech.sellcars;

import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;

import com.gktech.base.TestBase;
import com.gktech.util.TestUtil;

public class TestSuiteBase extends TestBase{
	@BeforeSuite
	public void checkSuiteSkip() throws Exception{		
		Initialize();
		applogs.debug("Verifiying sellcars suite run status");
		if(!TestUtil.isSuiteRunnable(Suitexls, "sellcars")){
			applogs.debug("Runmode of the sellcars suite is set as no, so skipping sellcars suite");
			throw new SkipException("Runmode of the sellcars suite is set as no, so skipping sellcars suite");
		}
	}

}
