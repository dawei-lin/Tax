package nsfw.complain.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import nsfw.complain.dao.ComplainDao;
import nsfw.complain.entity.Complain;
import nsfw.complain.service.ComplainService;

import org.springframework.stereotype.Component;

import core.service.impl.BaseServiceImpl;
import core.util.QueryHelper;
@Component("complainService")
public class ComplainServiceImpl extends BaseServiceImpl<Complain> implements
		ComplainService {
	private ComplainDao complainDao;
	@Resource
	public void setComplainDao(ComplainDao complainDao) {
		super.setBaseDao(complainDao);
		this.complainDao = complainDao;
	}
	@Override
	public void autoDeal() {
		QueryHelper queryHelper=new QueryHelper(Complain.class, "c");
		queryHelper.addCondition("c.compState=?", Complain.COMPLAIN_STATE_UNDONE);
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		queryHelper.addCondition("c.compDate<?",calendar.getTime() );
		List<Complain> list = getObjects(queryHelper);
		if(list!=null&&list.size()>0){
			for(Complain c:list){
				c.setCompState(Complain.COMPLAIN_STATE_INVILIB);
				update(c);
			}
		}
	}
	@Override
	public List<Map> getAnnualStatistic(int year) {
		List<Object[]> monthList = complainDao.getAnnualStatistic(year);
		List<Map> dataList=new ArrayList<Map>();
		Map<String,Object> monthMap=null;
		int curYear=Calendar.getInstance().get(Calendar.YEAR);
		int curMonth=Calendar.getInstance().get(Calendar.MONTH)+1;
		int temMonth=0;
		if(monthList!=null){
			if(year<curYear){
				for(Object[] data:monthList){
					temMonth=Integer.valueOf(data[0]+"");
					monthMap=new HashMap<String,Object>();
					monthMap.put("label", temMonth+"月");
					monthMap.put("value", data[1]==null?"0":data[1]);
					dataList.add(monthMap);
				}
			}else{
				for(Object[] data:monthList){
					temMonth=Integer.valueOf(data[0]+"");
					monthMap=new HashMap<String,Object>();
					monthMap.put("label", temMonth+"月");
					if(temMonth>curMonth){
						monthMap.put("value", "");
					}else{
						monthMap.put("value", data[1]==null?0:data[1]);
					}
					dataList.add(monthMap);
				}
			}
			
		}
		return dataList;
	}
	
}
