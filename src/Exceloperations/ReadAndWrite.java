package Exceloperations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadAndWrite {

	public static void main(String[] args) throws Throwable
	{
		FileInputStream fi = new FileInputStream("D:/Sample.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet ws = wb.getSheet("Emp");

		int rows = ws.getLastRowNum();
		System.out.println("No of rows are : "+rows);

		for(int i=1;i<=rows;i++)
		{
			String fname = ws.getRow(i).getCell(0).getStringCellValue();
			String mname = ws.getRow(i).getCell(1).getStringCellValue();
			String lname = ws.getRow(i).getCell(2).getStringCellValue();
			double Eid = ws.getRow(i).getCell(3).getNumericCellValue();
			System.out.println(fname+" "+mname+" "+lname+" "+Eid);

			ws.getRow(i).createCell(4).setCellValue("Pass");	    	    
		}

		fi.close();

		FileOutputStream fo = new FileOutputStream("D:/Results.xlsx");
		wb.write(fo);
		fo.close();
		wb.close();


	}

}
