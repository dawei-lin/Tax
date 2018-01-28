package test.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import test.dao.TestDao;
import test.entity.Person;

public class TestDaoImpl extends HibernateDaoSupport implements TestDao {
	
	@Override
	public void save(Person person) {
		getHibernateTemplate().save(person);
	}

}
