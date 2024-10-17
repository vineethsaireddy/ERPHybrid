package Exceloperations;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class AlternateMethodToReadCellData {

	public static void main(String[] args) throws IOException {

		
		FileInputStream fi = new FileInputStream("D:/Sample.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet ws = wb.getSheet("Emp");
		
	    int rc = ws.getLastRowNum();
		System.out.println("No of rows are :"+rc);
		
		String fname = ws.getRow(8).getCell(0).getStringCellValue();
		String mname = ws.getRow(3).getCell(1).getStringCellValue();
		String lname = ws.getRow(3).getCell(2).getStringCellValue();
		int EID = (int)ws.getRow(5).getCell(3).getNumericCellValue();
		
		System.out.println(fname+" "+mname+" "+lname+" "+EID);
		fi.close();
		wb.close();
		
	}

}
