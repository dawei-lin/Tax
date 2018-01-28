package nsfw.user.dao.impl;

import java.io.Serializable;
import java.util.List;

import nsfw.role.entity.Role;
import nsfw.user.dao.UserDao;
import nsfw.user.entity.User;
import nsfw.user.entity.UserRole;
import nsfw.user.entity.UserRoleId;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;

import core.dao.impl.BaseDaoImpl;

public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	@Override
	public List<User> findByIdAndAccount(String id, String account) {
		String hql="from User where account=?";
		if(StringUtils.isNotBlank(id)){
			hql=hql+" and id!=?";
		}
		Query query = getSession().createQuery(hql);
		query.setParameter(0, account);
		if(StringUtils.isNotBlank(id)){
			query.setParameter(1, id);
		}
		return query.list();
	}

	@Override
	public void saveUserAndRole(User user, String[] userRoleIds) {
		save(user);
		for(int i=0;i<userRoleIds.length;i++){
		getHibernateTemplate().save(new UserRole(new UserRoleId(new Role(userRoleIds[i]),user.getId())));
		}
	}

	@Override
	public List<UserRole> getUserRoleByUserId(Serializable id) {
		Query query = getSession().createQuery("from UserRole where id.userId=?");
		query.setParameter(0, id);
		return query.list();
	}

	@Override
	public void updateUserAndRole(User user, String[] userRoleIds) {
		update(user);
		deleteUserRoleByUserId(user.getId());
		for(int i=0;i<userRoleIds.length;i++){
			getHibernateTemplate().save(new UserRole(new UserRoleId(new Role(userRoleIds[i]),user.getId())));
		}
	}

	public void deleteUserRoleByUserId(Serializable id) {
		Query query = getSession().createQuery("delete from UserRole where id.userId=?");
		query.setParameter(0, id);
		query.executeUpdate();
	}

	@Override
	public List<User> findUserByAccountAndPass(User user) {
		Query query = getSession().createQuery("from User where account=? and password=?");
		query.setParameter(0, user.getAccount());
		query.setParameter(1, user.getPassword());
		return query.list();
	}
}
