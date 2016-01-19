package com.gktech.util;

public class TestUtil {
	//to check the runmode of the test suite whether suite is runnable or not
	public static boolean isSuiteRunnable(XLS_Reader xls, String suiteName){
		boolean isExecutable=false;
		for(int i=2;i<=xls.getRowCount("Testsuites");i++){
			String suite=xls.getCellData("Testsuites", "TSID", i);
			String runmode=xls.getCellData("Testsuites", "Runmode", i);
			System.out.println(suite+"==="+runmode);
			if(suite.equalsIgnoreCase(suiteName)){
				if(runmode.equalsIgnoreCase("Y")){
					isExecutable=true;
				}
			}
		}
		return isExecutable;
	}
	//to check the runmode of the test case whether test case is runnable or not
	public static boolean testCaseRunnable(XLS_Reader xls, String testCaseName){
		boolean isExecutable=false;
		for(int i=2;i<=xls.getRowCount("Testcases");i++){
			String testcase=xls.getCellData("Testcases", "TCID", i);
			String runmode=xls.getCellData("Testcases", "Runmode", i);
			System.out.println(testcase+"==="+runmode);
			if(testcase.equalsIgnoreCase(testCaseName)){
				if(runmode.equalsIgnoreCase("Y")){
					isExecutable=true;
				}
			}
		}
		return isExecutable;		
	}
	//Get the runmodes of the test data for the particular test case
	public static String[] gettestDataRunmodes(XLS_Reader xls, String sheetName){
		String[] runmodes;
		if(!xls.isSheetExist(sheetName)){
			System.err.println("Test Data Sheet Not found");
		}
		//size declaration
		runmodes = new String[xls.getRowCount(sheetName)-1];
		//values declaration
		for(int i=2;i<=xls.getRowCount(sheetName);i++){
			runmodes[i-2]=xls.getCellData(sheetName, "Runmode", i);
			System.out.println(xls.getCellData(sheetName, "Runmode", i));
		}
		return runmodes;		
	}
	//get the test data from paraticular test case
	public static Object[][] getTestData(XLS_Reader xls, String sheetName){
		if(!xls.isSheetExist(sheetName)){
			System.err.println("Test Data Sheet Not found");
		}
		int rows=xls.getRowCount(sheetName);
		int cols=xls.getColumnCount(sheetName);
		System.out.println("Total rows in the test data: "+rows);
		System.out.println("Total cols in the tast data: "+cols);
		//size declaration
		Object[][] data=new Object[rows-1][cols-1];
		//values declaration
		for(int rowNum=2;rowNum<=rows;rowNum++){
			for(int colNum=0;colNum<=cols-2;colNum++){
				data[rowNum-2][colNum]=xls.getCellData(sheetName, colNum, rowNum);
				//System.out.print(xls.getCellData(sheetName, colNum, rowNum)+"===");
			}
			System.out.println();
		}
		return data;
	}
}
