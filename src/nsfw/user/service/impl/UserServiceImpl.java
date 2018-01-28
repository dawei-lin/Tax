package nsfw.user.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;

import nsfw.user.dao.UserDao;
import nsfw.user.entity.User;
import nsfw.user.entity.UserRole;
import nsfw.user.service.UserService;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import core.service.impl.BaseServiceImpl;
import core.util.ExcelUtil;
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {
	private UserDao userDao;
	@Resource
	public void setUserDao(UserDao userDao) {
		super.setBaseDao(userDao);
		this.userDao = userDao;
	}


	@Override
	public void delete(Serializable id) {
		userDao.delete(id);
		userDao.deleteUserRoleByUserId(id);
	}

	public void exportExcel(List<User> userList,ServletOutputStream outputStream){
		ExcelUtil.exportUserExcel(userList, outputStream);
	}

	@Override
	public void importExcel(File userExcel,String userExcelFileName) {
		try {
				FileInputStream inputStream = new FileInputStream(userExcel);
				boolean flag = userExcelFileName.matches("^.+\\.(?i)(xls)$");
				Workbook workbook=flag?new HSSFWorkbook(inputStream):new XSSFWorkbook(inputStream);
				Sheet sheet = workbook.getSheetAt(0);
				if(sheet.getPhysicalNumberOfRows()>2){
					for(int i=2;i<sheet.getPhysicalNumberOfRows();i++){
						User user=new User();
						Row row = sheet.getRow(i);
						Cell cell0 = row.getCell(0);
						user.setName(cell0.getStringCellValue());
						Cell cell1 = row.getCell(1);
						user.setAccount(cell1.getStringCellValue());
						Cell cell2 = row.getCell(2);
						user.setDept(cell2.getStringCellValue());
						Cell cell3 = row.getCell(3);
						user.setGender(cell3.getStringCellValue().equals("男"));
						Cell cell4 = row.getCell(4);
						String mobile="";
						try {
							double value = cell4.getNumericCellValue();
							mobile = BigDecimal.valueOf(value).toString();
						} catch (Exception e) {
							mobile =cell4.getStringCellValue();
						}
						user.setMobile(mobile);
						Cell cell5 = row.getCell(5);
						user.setEmail(cell5.getStringCellValue());
						Cell cell6 = row.getCell(6);
						user.setBirthday(cell6.getDateCellValue());
						user.setPassword("123456");
						user.setState(User.USER_STATE_VALID);
						save(user);
					}
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<User> findByIdAndAccount(String id, String account) {
		return userDao.findByIdAndAccount(id,account);
	}

	@Override
	public void saveUserAndRole(User user, String... userRoleIds) {
		if(userRoleIds!=null){
			userDao.saveUserAndRole(user,userRoleIds);
		}else{
			userDao.save(user);
		}
		
	}

	@Override
	public void updateUserAndRole(User user, String... userRoleIds) {
		if(userRoleIds!=null){
			userDao.updateUserAndRole(user,userRoleIds);
		}else{
			userDao.update(user);;
		}
	}

	@Override
	public List<UserRole> getUserRoleByUserId(String id) {
		return userDao.getUserRoleByUserId(id);
	}

	@Override
	public List<User> findUserByAccountAndPass(User user) {
		return userDao.findUserByAccountAndPass(user);
	}

}
