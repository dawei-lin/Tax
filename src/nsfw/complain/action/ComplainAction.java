package nsfw.complain.action;

import java.net.URLDecoder;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import nsfw.complain.entity.Complain;
import nsfw.complain.entity.ComplainReply;
import nsfw.complain.service.ComplainService;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

import core.action.BaseAction;
import core.util.QueryHelper;

public class ComplainAction extends BaseAction {
	@Resource
	private ComplainService complainService;
	private Complain complain;
	private ComplainReply complainReply;
	private String startTime;
	private String endTime;
	private String strTitle;
	private String strState;
	private Map<String,Object> return_data;
	public String listUI(){
		try {
			ActionContext.getContext().getContextMap().put("complainStateMap", Complain.COMPLAIN_STATE_MAP);
			QueryHelper queryHelper = new QueryHelper(Complain.class, "c");
			if(complain!=null){
				if(StringUtils.isNotBlank(complain.getToCompTitle())){
					complain.setToCompTitle(URLDecoder.decode(complain.getToCompTitle(), "utf-8"));
					queryHelper.addCondition("c.toCompTitle like ?","%"+complain.getToCompTitle()+"%");
				}
				if(StringUtils.isNotBlank(startTime)){
					startTime=URLDecoder.decode(startTime, "utf-8");
					queryHelper.addCondition("c.compDate >= ?",DateUtils.parseDate(startTime, "yyyy-MM-dd HH:mm"));
				}
				if(StringUtils.isNotBlank(endTime)){
					endTime=URLDecoder.decode(endTime, "utf-8");
					queryHelper.addCondition("c.compDate <= ?",DateUtils.parseDate(endTime, "yyyy-MM-dd HH:mm"));
				}
				if(StringUtils.isNotBlank(complain.getCompState())){
					queryHelper.addCondition("c.compState =?", complain.getCompState());
				}
			}
			pageResult=complainService.getObjects(queryHelper, pageSize, currentPage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "listUI";
	}
	public String dealUI(){
		ActionContext.getContext().getContextMap().put("complainStateMap", Complain.COMPLAIN_STATE_MAP);
		if(complain.getCompId()!=null){
			strTitle=complain.getToCompTitle();
			strState=complain.getCompState();
			complain=complainService.findById(complain.getCompId());
		}
		return "dealUI";
	}
	public String deal(){
		Complain tem=complainService.findById(complain.getCompId());
		if(!Complain.COMPLAIN_STATE_DONE.equals(tem.getCompState())){
			tem.setCompState(Complain.COMPLAIN_STATE_DONE);
		}
		complainReply.setComplain(tem);
		complainReply.setReplyDate(new Timestamp(new Date().getTime()));
		tem.getComplainReplies().add(complainReply);
		complainService.update(tem);
		return "list";
	}
	public String annualStatisticChartUI(){
		return "annualStatisticChartUI";
	}
	public String getAnnualStatistic(){
		String year = ServletActionContext.getRequest().getParameter("year");
		if(StringUtils.isNotBlank(year)){	
			List yearList=complainService.getAnnualStatistic(Integer.valueOf(year));
			return_data=new HashMap<String, Object>();
			return_data.put("msg", "success");
			return_data.put("chartData", yearList);
		}else{
			List yearList=complainService.getAnnualStatistic(Calendar.getInstance().get(Calendar.YEAR));
			return_data=new HashMap<String, Object>();
			return_data.put("msg", "success");
			return_data.put("chartData", yearList);
		}
		return "annualStatistic";
	}
	public Complain getComplain() {
		return complain;
	}
	public void setComplain(Complain complain) {
		this.complain = complain;
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
	public ComplainReply getComplainReply() {
		return complainReply;
	}
	public void setComplainReply(ComplainReply complainReply) {
		this.complainReply = complainReply;
	}
	public String getStrTitle() {
		return strTitle;
	}
	public void setStrTitle(String strTitle) {
		this.strTitle = strTitle;
	}
	public String getStrState() {
		return strState;
	}
	public void setStrState(String strState) {
		this.strState = strState;
	}
	public Map<String, Object> getReturn_data() {
		return return_data;
	}
}
