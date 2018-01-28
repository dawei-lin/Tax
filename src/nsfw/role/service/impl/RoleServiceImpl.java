package nsfw.role.service.impl;

import javax.annotation.Resource;

import nsfw.role.dao.RoleDao;
import nsfw.role.entity.Role;
import nsfw.role.service.RoleService;

import org.springframework.stereotype.Service;

import core.service.impl.BaseServiceImpl;
@Service("roleService")
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService {
	private RoleDao roleDao;
	@Resource
	public void setRoleDao(RoleDao roleDao) {
		super.setBaseDao(roleDao);
		this.roleDao = roleDao;
	}

	@Override
	public void update(Role role) {
		roleDao.deleteRolePrivilegeByRoleId(role.getRoleId());
		roleDao.update(role);

	}
}
