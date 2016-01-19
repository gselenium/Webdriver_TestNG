package Rough;

import com.gktech.util.XLS_Reader;

public class GetTestData_ExcelFile {
	public static void main(String[] args) {
		XLS_Reader xls=new XLS_Reader("D:/Online_Batches/VineelaSelenium/Workspace/WebDriver_TestNG_DataDriven/src/com/gktech/xlsfiles/newcars.xlsx");
		getTestData(xls, "Login");
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
				System.out.print(xls.getCellData(sheetName, colNum, rowNum)+"===");
			}
			System.out.println();
		}
		return data;
	}

}
