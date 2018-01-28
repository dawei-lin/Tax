package nsfw.user.dao;

import java.io.Serializable;
import java.util.List;

import nsfw.user.entity.User;
import nsfw.user.entity.UserRole;
import core.dao.BaseDao;

public interface UserDao extends BaseDao<User> {

	public List<User> findByIdAndAccount(String id, String account);

	public void saveUserAndRole(User user, String[] userRoleIds);

	public List<UserRole> getUserRoleByUserId(Serializable id);

	public void updateUserAndRole(User user, String[] userRoleIds);
	public void deleteUserRoleByUserId(Serializable id);

	public List<User> findUserByAccountAndPass(User user);

}
