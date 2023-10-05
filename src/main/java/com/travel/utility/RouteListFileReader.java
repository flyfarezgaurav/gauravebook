package com.travel.utility;
	
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class RouteListFileReader
{	
	public String readFromExcelFile(String excelFilePath) throws IOException{
		
		String value="";
		FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
		Workbook workbook = getWorkbook(inputStream, excelFilePath);
		Sheet sheet = workbook.getSheetAt(0);
		Iterator<Row> iterator = sheet.iterator();
		System.out.println("SheetName:: "+sheet.getSheetName());
		int column_index_1 = 0;
	    int column_index_2 = 0;
		while(iterator.hasNext()){
			Row nextRow = iterator.next();
			//System.out.println("RowNum::"+nextRow.getRowNum());
			Iterator<Cell> cellIterator = nextRow.cellIterator();
			while(cellIterator.hasNext()){
				Cell cell = cellIterator.next();
				//int columnIndex = cell.getColumnIndex();
				//System.out.println("value::"+cell.getStringCellValue());
				switch(cell.getStringCellValue()){
				case "Origin":
					column_index_1 = cell.getColumnIndex();
					break;
				case "Destination":
					column_index_2 = cell.getColumnIndex();
					break;
				}
			}
		}
		
		for (Row r : sheet) {
	        if (r.getRowNum()==0) continue;
	        Cell c_1 = r.getCell(column_index_1);
	        Cell c_2 = r.getCell(column_index_2);
	        if (c_1 != null && c_1.getCellType() != Cell.CELL_TYPE_BLANK &&c_2 != null && c_2.getCellType() != Cell.CELL_TYPE_BLANK) 
	        {
	            System.out.print("  "+c_1 + "   " + c_2+"\n");
	        }
	    }
		
		return value;
	}
	
	private Workbook getWorkbook(FileInputStream inputStream, String excelFilePath) throws IOException{
		Workbook workbook = null;
		if(excelFilePath.endsWith("xlsx")){
			workbook = new XSSFWorkbook(inputStream);
		}else if(excelFilePath.endsWith("xls")){
			workbook = new HSSFWorkbook(inputStream);
		}else {
			throw new IllegalArgumentException("The specified file is not Excel File");
		}
		
		return workbook;
	}
}
