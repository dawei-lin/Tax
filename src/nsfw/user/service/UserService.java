package nsfw.user.service;

import java.io.File;
import java.util.List;

import javax.servlet.ServletOutputStream;

import nsfw.user.entity.User;
import nsfw.user.entity.UserRole;
import core.service.BaseService;

public interface UserService extends BaseService<User>{
	public void exportExcel(List<User> userList,ServletOutputStream outputStream);
	public void importExcel(File userExcel,String userExcelFileName);
	public List<User> findByIdAndAccount(String id, String account);
	public void saveUserAndRole(User user, String... userRoleIds);
	public void updateUserAndRole(User user, String... userRoleIds);
	public List<UserRole> getUserRoleByUserId(String id);
	public List<User> findUserByAccountAndPass(User user);
}
