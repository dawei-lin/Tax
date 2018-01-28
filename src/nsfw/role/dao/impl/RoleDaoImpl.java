package nsfw.role.dao.impl;

import nsfw.role.dao.RoleDao;
import nsfw.role.entity.Role;

import org.hibernate.Query;

import core.dao.impl.BaseDaoImpl;

public class RoleDaoImpl extends BaseDaoImpl<Role> implements RoleDao {

	@Override
	public void deleteRolePrivilegeByRoleId(String roleId) {
		Query query = getSession().createQuery("delete from RolePrivilege where id.role.roleId=?");
		query.setParameter(0, roleId);
		query.executeUpdate();
	}
}
