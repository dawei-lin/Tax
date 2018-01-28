package nsfw.complain.dao.impl;

import java.util.List;

import org.hibernate.SQLQuery;

import nsfw.complain.dao.ComplainDao;
import nsfw.complain.entity.Complain;
import core.dao.impl.BaseDaoImpl;

public class ComplainDaoImpl extends BaseDaoImpl<Complain> implements
		ComplainDao {

	@Override
	public List<Object[]> getAnnualStatistic(int year) {
		StringBuffer sb=new StringBuffer();
		sb.append("SELECT imonth,COUNT(comp_id)");
		sb.append(" FROM nmonth LEFT JOIN complain");
		sb.append(" ON imonth=MONTH(comp_date) AND YEAR(comp_date) = ?");
		sb.append(" GROUP BY imonth");
		sb.append(" ORDER BY imonth");
		SQLQuery sqlQuery = getSession().createSQLQuery(sb.toString());
		sqlQuery.setParameter(0, year);
		return sqlQuery.list();
	}
}