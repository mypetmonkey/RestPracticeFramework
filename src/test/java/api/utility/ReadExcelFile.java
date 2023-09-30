package api.utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {
	
	public static FileInputStream fis;
	public static XSSFWorkbook workbook;
	public static XSSFSheet excelsheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public static String getCellValue(String filename,String sheetname,int rowno,int cellno) throws IOException {

			fis=new FileInputStream(filename);
			workbook=new XSSFWorkbook(fis);
			excelsheet=workbook.getSheet(sheetname);
			cell=workbook.getSheet(sheetname).getRow(rowno).getCell(cellno);
			workbook.close();
			return cell.toString();
			
	}
	
	
	
	public static int getRownum(String filename,String sheetname) throws Throwable {
		fis=new FileInputStream(filename);
		workbook=new XSSFWorkbook(fis);
		 excelsheet=workbook.getSheet(sheetname);
		 int trow=excelsheet.getLastRowNum()+1;
		 workbook.close();
		 return trow;
	}
	
	
	
	public static int getcolcount(String filename, String sheetname) throws IOException {
		
		fis=new FileInputStream(filename);
		workbook=new XSSFWorkbook(fis);
		excelsheet=workbook.getSheet(sheetname);
		int tcell = excelsheet.getRow(0).getLastCellNum();
		workbook.close();
		return tcell;
		
	}

}
