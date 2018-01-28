package core.util;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;

import nsfw.user.entity.User;

public class ExcelUtil {
	public static void exportUserExcel(List<User> userList,ServletOutputStream outputStream){
		try {
			HSSFWorkbook workbook=new HSSFWorkbook();
			CellRangeAddress address=new CellRangeAddress(0, 0, 0, 4);
			HSSFCellStyle titleStyle1 = getStyle(workbook, (short)16);
			HSSFCellStyle titleStyle2 = getStyle(workbook, (short)13);
			HSSFSheet sheet = workbook.createSheet();
			sheet.addMergedRegion(address);
			sheet.setDefaultColumnWidth(25);
			HSSFRow row1 = sheet.createRow(0);
			HSSFCell cell1 = row1.createCell(0);
			cell1.setCellValue("用户列表");
			cell1.setCellStyle(titleStyle1);
			HSSFRow row2 = sheet.createRow(1);
			String[] titleName={"用户名","账号","所属部门","性别","电子邮箱"};
			for(int i=0;i<titleName.length;i++){
				HSSFCell cell2 = row2.createCell(i);
				cell2.setCellValue(titleName[i]);
				cell2.setCellStyle(titleStyle2);
			}
			if(userList!=null){
			for(int j=0;j<userList.size();j++){
			HSSFRow row3 = sheet.createRow(j+2);
			HSSFCell cell3 = row3.createCell(0);
			cell3.setCellValue(userList.get(j).getName());
			HSSFCell cell4 = row3.createCell(1);
			cell4.setCellValue(userList.get(j).getAccount());
			HSSFCell cell5 = row3.createCell(2);
			cell5.setCellValue(userList.get(j).getDept());
			HSSFCell cell6 = row3.createCell(3);
			cell6.setCellValue(userList.get(j).isGender()?"男":"女");
			HSSFCell cell7 = row3.createCell(4);
			cell7.setCellValue(userList.get(j).getEmail());
			}
			}
			workbook.write(outputStream);
			outputStream.close();
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private static HSSFCellStyle getStyle(HSSFWorkbook workbook,short size){
		HSSFCellStyle cellStyle = workbook.createCellStyle();
		HSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeightInPoints(size);
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		cellStyle.setFont(font);
		return cellStyle;
	}
}
