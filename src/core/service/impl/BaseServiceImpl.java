package core.service.impl;

import java.io.Serializable;
import java.util.List;

import core.dao.BaseDao;
import core.page.PageResult;
import core.service.BaseService;
import core.util.QueryHelper;

public class BaseServiceImpl<T> implements BaseService<T> {
	private BaseDao<T> baseDao;
	public void setBaseDao(BaseDao<T> baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public void save(T t) {
		baseDao.save(t);

	}

	@Override
	public void update(T t) {
		baseDao.update(t);

	}

	@Override
	public void delete(Serializable id) {
		baseDao.delete(id);

	}

	@Override
	public T findById(Serializable id) {
		
		return (T) baseDao.findById(id);
	}

	@Override
	public List<T> getAll() {
		
		return baseDao.getAll();
	}

	@Override
	public List<T> getObjects(String hql, List<Object> paramters) {
		return baseDao.getObjects(hql, paramters);
	}

	@Override
	public List<T> getObjects(QueryHelper queryHelper) {
		return baseDao.getObjects(queryHelper);
	}

	@Override
	public PageResult getObjects(QueryHelper queryHelper, int pageSize,
			int currentPage) {
		return baseDao.getObjects(queryHelper,pageSize,currentPage);
	}

}
