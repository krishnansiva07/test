package utility;


import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	
	public static XSSFWorkbook wBook = null;
	public static XSSFSheet wSheet = null;
	
public static void setExcel(String sheetName) throws IOException {	
	System.out.println(Constants.excelPath);
	FileInputStream fis = new FileInputStream(Constants.excelPath);
	wBook = new XSSFWorkbook(fis);
	wSheet = wBook.getSheet(sheetName);
}

public static String getDataFromExcel(int row, int cell) {
	return wSheet.getRow(row).getCell(cell).toString();
}

public static Object[][] getTableData(String sheet, int row, int col, int noOfrows, int noOfCols) throws IOException{

setExcel("setOfUsers");
Object[][] tableArray = new Object[noOfrows][noOfCols];

int colTemp = col;

int tableArrayRow = 0;
int tableArrayCol = 0;

for(int i=0; i<noOfrows; i++) {
	tableArrayCol = 0;
	col = colTemp;
	for(int j=0;j<noOfCols;j++) {
		tableArray[tableArrayRow][tableArrayCol] = getDataFromExcel(row,col);
		System.out.println("row: "+ tableArrayRow+" "+"col: "+ tableArrayCol+ " "  +tableArray[tableArrayRow][tableArrayCol]);
		col++;
		tableArrayCol++;
	}
	row++;
	tableArrayRow++;
}

return tableArray;	
}


	
}
