package nsfw.reserve.action;

import java.sql.Timestamp;
import java.util.Date;

import javax.annotation.Resource;

import nsfw.reserve.entity.Reserve;
import nsfw.reserve.service.ReserveService;
import nsfw.user.entity.User;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

import com.opensymphony.xwork2.ActionContext;

import core.action.BaseAction;
import core.util.QueryHelper;

public class ReserveAction extends BaseAction {
	@Resource
	private ReserveService reserveService;
	private Reserve reserve;
	private String startTime;
	private String endTime;
	private String strReserveNumber;
	private String strStartTime;
	private String strEndTime;
	private String strReserveState;
	public String listUI(){
		ActionContext.getContext().getContextMap().put("RESERVE_STATE_MAP", Reserve.RESERVE_STATE_MAP);
		User user = (User) ActionContext.getContext().getSession().get("user");
		QueryHelper queryHelper = new QueryHelper(Reserve.class, "r");
		queryHelper.addCondition("r.reserveItem.dealor=?", user.getName());
		try {
			if(reserve!=null){
				if(StringUtils.isNotBlank(reserve.getReserveNumber())){
					queryHelper.addCondition("r.reserveNumber like ?", "%"+reserve.getReserveNumber()+"%");
				}
				if(StringUtils.isNotBlank(reserve.getReserveState())){
					queryHelper.addCondition("r.reserveState=?", reserve.getReserveState());
				}
			}
			if(StringUtils.isNotBlank(startTime)){
				queryHelper.addCondition("r.reserveDate>?", DateUtils.parseDate(startTime, "yyyy-MM-dd HH:mm"));
			}
			if(StringUtils.isNotBlank(endTime)){
				queryHelper.addCondition("r.reserveDate<?", DateUtils.parseDate(endTime, "yyyy-MM-dd HH:mm"));
			}
			pageResult=reserveService.getObjects(queryHelper, pageSize, currentPage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "listUI";
	}
	public String dealUI(){
		ActionContext.getContext().getContextMap().put("RESERVE_STATE_MAP", Reserve.RESERVE_STATE_MAP);
		if(reserve!=null){
			if(StringUtils.isNotBlank(reserve.getReserveState())){
				strReserveState=reserve.getReserveState();
			}
			if(StringUtils.isNotBlank(reserve.getReserveNumber())){
				strReserveNumber=reserve.getReserveNumber();
			}
			if(StringUtils.isNotBlank(startTime)){
				strStartTime=startTime;
			}
			if(StringUtils.isNotBlank(endTime)){
				strEndTime=endTime;
			}
			reserve=reserveService.findById(reserve.getReserveId());
		}
		return "dealUI";
	}
	public String deal(){
		if(reserve!=null){
			Reserve tem=reserveService.findById(reserve.getReserveId());
			tem.setReplyDate(new Timestamp(new Date().getTime()));
			tem.setReplyor(reserve.getReplyor());
			tem.setReserveState(reserve.getReserveState());
			tem.setReserveState(reserve.getReserveState());
			tem.setReplyContent(reserve.getReplyContent());
			reserveService.update(tem);
		}
		return "list";
	}
	public Reserve getReserve() {
		return reserve;
	}
	public void setReserve(Reserve reserve) {
		this.reserve = reserve;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getStrReserveState() {
		return strReserveState;
	}
	public void setStrReserveState(String strReserveState) {
		this.strReserveState = strReserveState;
	}
	public String getStrReserveNumber() {
		return strReserveNumber;
	}
	public void setStrReserveNumber(String strReserveNumber) {
		this.strReserveNumber = strReserveNumber;
	}
	public String getStrStartTime() {
		return strStartTime;
	}
	public void setStrStartTime(String strStartTime) {
		this.strStartTime = strStartTime;
	}
	public String getStrEndTime() {
		return strEndTime;
	}
	public void setStrEndTime(String strEndTime) {
		this.strEndTime = strEndTime;
	}
	
}
