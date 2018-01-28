package core.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import core.dao.BaseDao;
import core.page.PageResult;
import core.util.QueryHelper;

public abstract class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {
	private Class<T> clazz;
	public BaseDaoImpl(){
		ParameterizedType pt=(ParameterizedType) this.getClass().getGenericSuperclass();
		clazz=(Class<T>) pt.getActualTypeArguments()[0];
	}
	@Override
	public void save(T t) {
		getHibernateTemplate().save(t);
		
	}

	@Override
	public void update(T t) {
		getHibernateTemplate().update(t);
		
	}

	@Override
	public void delete(Serializable id) {
		getHibernateTemplate().delete(findById(id));
		
	}

	@Override
	public T findById(Serializable id) {
		return getHibernateTemplate().get(clazz, id);
	}

	@Override
	public List<T> getAll() {
		return (List<T>) getSession().createQuery("From "+clazz.getSimpleName()).list();
	}
	@Override
	public List<T> getObjects(String hql, List<Object> paramters) {
		Query query = getSession().createQuery(hql);
		if(paramters!=null){
		for(int i=0;i<paramters.size();i++){
			query.setParameter(i, paramters.get(i));
		}
		}
		return (List<T>)query.list();
	}
	@Override
	public List<T> getObjects(QueryHelper queryHelper) {
		Query query = getSession().createQuery(queryHelper.getQueryHql());
		if(queryHelper.getQueryParamters()!=null){
		for(int i=0;i<queryHelper.getQueryParamters().size();i++){
			query.setParameter(i, queryHelper.getQueryParamters().get(i));
		}
		}
		return (List<T>)query.list();
	}
	@Override
	public PageResult getObjects(QueryHelper queryHelper, int pageSize,
			int currentPage) {
		Query query = getSession().createQuery(queryHelper.getQueryHql());
		if(queryHelper.getQueryParamters()!=null){
		for(int i=0;i<queryHelper.getQueryParamters().size();i++){
			query.setParameter(i, queryHelper.getQueryParamters().get(i));
		}
		}
		if(pageSize==0){
			pageSize=3;
		}
		query.setFirstResult((currentPage-1)*pageSize);
		query.setMaxResults(pageSize);
		List params = query.list();
		Query queryCount = getSession().createQuery(queryHelper.getQueryCountHql());
		if(queryHelper.getQueryParamters()!=null){
			for(int i=0;i<queryHelper.getQueryParamters().size();i++){
				queryCount.setParameter(i, queryHelper.getQueryParamters().get(i));
			}
		}
		long totalCount = (Long)queryCount.uniqueResult();
		if(currentPage<1){
			currentPage=1;
		}
		PageResult pageResult=new PageResult(totalCount, currentPage, pageSize, params);
		return pageResult;
	}
	
}
