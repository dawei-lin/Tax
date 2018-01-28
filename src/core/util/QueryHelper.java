package core.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

public class QueryHelper {
	private String fromClause="";
	private String whereClause="";
	private String orderClause="";
	private List<Object> paramters;
	public QueryHelper(Class clazz,String alias){
		fromClause="from "+clazz.getSimpleName()+" "+alias;
	}
	public void addCondition(String condition,Object... params){
		if(whereClause.length()>0){
			whereClause+=" and "+condition;
		}else{
			whereClause+=" where "+condition;
		}
		if(paramters==null){
			paramters=new ArrayList<Object>();
		}
		if(params!=null){
			for(Object param:params){
				paramters.add(param);
			}
		}
	}
	public void addOrderProperty(String property,String order){
		if(orderClause.length()>1){
			orderClause+=","+property+" "+order;
		}else{	
			orderClause+=" order by "+property+" "+order;
		}
	}
	public String getQueryHql(){
		return fromClause+whereClause+orderClause;
	}
	public String getQueryCountHql(){
		return "select count(*) "+fromClause+whereClause;
	}
	public List<Object>  getQueryParamters(){
		return paramters;
	}
}
