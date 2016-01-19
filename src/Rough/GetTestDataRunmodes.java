package Rough;

import com.gktech.util.XLS_Reader;

public class GetTestDataRunmodes {
	public static void main(String[] args) {
		XLS_Reader xls=new XLS_Reader("D:/Online_Batches/VineelaSelenium/Workspace/WebDriver_TestNG_DataDriven/src/com/gktech/xlsfiles/newcars.xlsx");
		gettestDataRunmodes(xls, "Login");
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
	

}
