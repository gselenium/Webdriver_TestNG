package com.gktech.newcars;

import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;
import com.gktech.base.TestBase;
import com.gktech.util.TestUtil;

public class TestSuiteBase extends TestBase{
	@BeforeSuite
	public void checkSuiteSkip() throws Exception{		
		Initialize();
		applogs.debug("Verifiying newcars suite run status");
		if(!TestUtil.isSuiteRunnable(Suitexls, "newcars")){
			applogs.debug("Runmode of the newcars suite is set as no, so skipping newcars suite");
			throw new SkipException("Runmode of the newcars suite is set as no, so skipping newcars suite");
		}
	}

}
