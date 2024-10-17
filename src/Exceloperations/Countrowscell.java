package Exceloperations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Countrowscell {

	public static void main(String[] args) throws Throwable 
	{

		FileInputStream fi = new FileInputStream("D:/Sample.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet ws = wb.getSheet("Emp");
		
		int rc = ws.getLastRowNum();
		
        XSSFRow row = ws.getRow(0);
        
        int cc = row.getLastCellNum();
        
       // System.out.println("No of rows are ::"+rc+" "+"No of cells are::"+cc);
        System.out.println("No of rows are : "+ rc);
        System.out.println("No of cells are :"+ cc);
        
        
		fi.close();
		wb.close();
		
		
	}

}
