package Exceloperations;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class RowData {

	public static void main(String[] args) throws IOException 
	{
		FileInputStream fi = new FileInputStream("D:/Sample.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet ws = wb.getSheet("Emp");
		
		int num =  ws.getLastRowNum();
		System.out.println("No of rows are :"+num);
	 	XSSFRow row = ws.getRow(10);
		
		int cell = row.getLastCellNum();
        System.out.println(cell);
        
        XSSFCell c1 = row.getCell(0);
        XSSFCell c2 = row.getCell(1);
        XSSFCell c3 = row.getCell(2);
        XSSFCell c4 = row.getCell(3);
        XSSFCell c5 = row.getCell(4);

        String fname = c1.getStringCellValue();
        String mname = c2.getStringCellValue();
        String lname = c3.getStringCellValue();
        double EID = c4.getNumericCellValue();
        
        System.out.println(fname+" "+mname+" "+lname+" "+EID);

	}

}
