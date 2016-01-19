package Rough;

import com.gktech.util.XLS_Reader;

public class TestCaseRunnable {
	public static void main(String[] args) {
		XLS_Reader xls=new XLS_Reader("D:/Online_Batches/VineelaSelenium/Workspace/WebDriver_TestNG_DataDriven/src/com/gktech/xlsfiles/newcars.xlsx");
		System.out.println(testCaseRunnable(xls, "Login"));
	}
	
	//get runmode of the test case
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

}
