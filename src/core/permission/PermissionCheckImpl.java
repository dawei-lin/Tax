package core.permission;

import java.util.List;
import java.util.Set;

import nsfw.role.entity.RolePrivilege;
import nsfw.user.entity.User;
import nsfw.user.entity.UserRole;

public class PermissionCheckImpl implements PermissionCheck {

	@Override
	public boolean isAccessible(User user, String uri) {
		if(uri.contains("/nsfw/")){
			List<UserRole> userRoles = user.getUserRoles();
			for(UserRole userRole:userRoles){
				Set<RolePrivilege> privileges = userRole.getId().getRole().getPrivileges();
				for(RolePrivilege privilege:privileges){
					if("nsfw".equals(privilege.getId().getCode())){
						return true;
					}
				}
			}
			return false;
		}
		return true;
	}

}
