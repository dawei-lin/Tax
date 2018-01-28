package test;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

public class TestPOI {

	@Test
	public void testTo03execel() throws Exception {
		FileOutputStream outputStream = new FileOutputStream("F:/测试.xls");
		HSSFWorkbook workbook=new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet();
		HSSFRow row = sheet.createRow(2);
		HSSFCell cell = row.createCell(2);
		cell.setCellValue("hello");
		workbook.write(outputStream);
		workbook.close();
		outputStream.close();
	}
	@Test
	public void testTo07execel() throws Exception {
		FileOutputStream outputStream = new FileOutputStream("F:/测试.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet();
		XSSFRow row = sheet.createRow(2);
		XSSFCell cell = row.createCell(2);
		cell.setCellValue("hello");
		workbook.write(outputStream);
		workbook.close();
		outputStream.close();
	}
	@Test
	public void testToAllexecel() throws Exception {
		String fileName="F:/测试.xls";
		Boolean flag=false;
		if(fileName.substring(fileName.lastIndexOf(".")).contains(".xlsx")){
			flag=true;
		}
		FileOutputStream outputStream = new FileOutputStream(fileName);
		Workbook workbook=flag?new XSSFWorkbook():new HSSFWorkbook();
		Sheet sheet = workbook.createSheet();
		Row row = sheet.createRow(2);
		Cell cell = row.createCell(2);
		cell.setCellValue("hello");
		workbook.write(outputStream);
		workbook.close();
		outputStream.close();
	}
	@Test
	public void testReadFromexecel() throws Exception {
		FileInputStream inputStream=new FileInputStream("F:/测试.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheetAt(0);
		XSSFRow row = sheet.getRow(2);
		XSSFCell cell = row.getCell(2);
		String value = cell.getStringCellValue();
		System.out.println(value);
		workbook.close();
		inputStream.close();
	}
	@Test
	public void testStyle() throws Exception {
		FileOutputStream outputStream = new FileOutputStream("F:/测试.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook();
		CellRangeAddress address=new CellRangeAddress(2, 2, 2, 4);
		XSSFCellStyle cellStyle = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		//font.setFontHeight((short)16);
		font.setFontHeightInPoints((short)16);
		cellStyle.setFont(font);
		cellStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);
		cellStyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
		cellStyle.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
		cellStyle.setFillForegroundColor(HSSFColor.YELLOW.index);
		XSSFSheet sheet = workbook.createSheet();
		sheet.addMergedRegion(address);
		XSSFRow row = sheet.createRow(2);
		XSSFCell cell = row.createCell(2);
		cell.setCellValue("hello");
		cell.setCellStyle(cellStyle);
		workbook.write(outputStream);
		workbook.close();
		outputStream.close();
	}

}
