package home.action;

import java.net.URLDecoder;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import nsfw.complain.entity.Complain;
import nsfw.complain.service.ComplainService;
import nsfw.info.entity.Info;
import nsfw.info.service.InfoService;
import nsfw.reserve.entity.Reserve;
import nsfw.reserve.entity.ReserveItem;
import nsfw.reserve.service.ReserveItemService;
import nsfw.reserve.service.ReserveService;
import nsfw.user.entity.User;
import nsfw.user.service.UserService;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.struts2.ServletActionContext;
import org.json.JSONObject;

import com.opensymphony.xwork2.ActionContext;

import core.action.BaseAction;
import core.util.QueryHelper;

public class HomeAction extends BaseAction {
	@Resource
	private UserService userService;
	@Resource
	private ComplainService complainService;
	@Resource
	private InfoService infoService;
	@Resource
	private ReserveItemService reserveItemService;
	@Resource
	private ReserveService reserveService;
	private Complain complain;
	private Info info;
	private Reserve reserve;
	private ReserveItem reserveItem;
	private String strReserveDate;
	private Map<String,Object> return_map;
	public String execute(){
		ActionContext.getContext().getContextMap().put("type_map", Info.TYPE_MAP);
		QueryHelper queryHelper1 = new QueryHelper(Info.class, "i");
		queryHelper1.addOrderProperty("i.createTime", "DESC");
		ActionContext.getContext().getContextMap().put("infoList", infoService.getObjects(queryHelper1, 6, 1).getItems());
		
		ActionContext.getContext().getContextMap().put("complainStateMap", Complain.COMPLAIN_STATE_MAP);
		QueryHelper queryHelper2 = new QueryHelper(Complain.class, "c");
		User user = (User) ActionContext.getContext().getSession().get("user");
		queryHelper2.addCondition("c.compName=?", user.getName());
		queryHelper2.addOrderProperty("c.compDate", "ASC");
		ActionContext.getContext().getContextMap().put("complainList", complainService.getObjects(queryHelper2, 6, 1).getItems());
		return "execute";
	}
	public String complainAddUI(){
		return "complainAddUI";
	}
	public void getUserJson(){
		try {
			String dept = ServletActionContext.getRequest().getParameter("dept");
			if(StringUtils.isNotBlank(dept)){
				QueryHelper queryHelper = new QueryHelper(User.class, "u");
				queryHelper.addCondition("u.dept like ?","%"+ dept);
				List<User> userList = userService.getObjects(queryHelper);
				JSONObject json = new JSONObject();
				json.put("msg", "success");
				json.accumulate("userList", userList);
				
				HttpServletResponse response = ServletActionContext.getResponse();
				response.setContentType("text/html");
				ServletOutputStream outputStream = response.getOutputStream();
				outputStream.write(json.toString().getBytes("utf-8"));
				outputStream.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getUserJson2(){
			String dept = ServletActionContext.getRequest().getParameter("dept");
			if(StringUtils.isNotBlank(dept)){
				QueryHelper queryHelper = new QueryHelper(User.class, "u");
				queryHelper.addCondition("u.dept like ?","%"+ dept);
				List<User> userList = userService.getObjects(queryHelper);
				return_map=new HashMap<String, Object>();
				return_map.put("msg", "success");
				return_map.put("userList", userList);
			}
			return SUCCESS;
	}
	public void complainAdd(){
		try {
			if(complain!=null){
				complain.setCompState(Complain.COMPLAIN_STATE_UNDONE);
				complain.setCompDate(new Timestamp(new Date().getTime()));
				complainService.save(complain);
				
				HttpServletResponse response = ServletActionContext.getResponse();
				response.setContentType("text/html");
				ServletOutputStream outputStream = response.getOutputStream();
				outputStream.write("success".getBytes("utf-8"));
				outputStream.close();
			}
		}  catch (Exception e) {
			e.printStackTrace();
		}
	}
	public String complainViewUI(){
		if(complain!=null){
			ActionContext.getContext().getContextMap().put("complainStateMap", Complain.COMPLAIN_STATE_MAP);
			complain = complainService.findById(complain.getCompId());
		}
		return "complainViewUI";
	}
	public String infoViewUI(){
		if(info!=null){
			ActionContext.getContext().getContextMap().put("type_map", Info.TYPE_MAP);
			info=infoService.findById(info.getInfoId());
		}
		return "infoViewUI";
	}
	public String reserveAddUI(){
		List<ReserveItem> reserveItemList = reserveItemService.getAll();
		if(reserveItemList!=null){
			List<String> itemNameList=new ArrayList<String>();
			for(ReserveItem reserveItem:reserveItemList){
				if(StringUtils.isNotBlank(reserveItem.getItemName())){
					itemNameList.add(reserveItem.getItemName());
				}
			}
			ActionContext.getContext().getContextMap().put("itemNameList", itemNameList);
		}
		return "reserveAddUI";
	}
	public String reserveAdd(){
		try {
			if(reserve!=null){
				SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
				String curDate = sdf.format(new Date());
				String reserveNo= (String) ActionContext.getContext().getApplication().get("reserveNo");
				if(StringUtils.isNotBlank(reserveNo)){
					int tem=(Integer.valueOf(reserveNo)+1);
					if(tem<10){
						reserveNo="00"+tem;
					}else if(tem<100){
						reserveNo="0"+tem;
					}else{
						reserveNo=tem+"";
					}
					/*reserveNo=(Integer.valueOf(reserveNo)+1)+"";*/
					ActionContext.getContext().getApplication().put("reserveNo", reserveNo);
				}else{
					reserveNo="001";
					ActionContext.getContext().getApplication().put("reserveNo", reserveNo);
				}
				reserve.setReserveNumber(curDate+reserveNo);
				if(StringUtils.isNotBlank(strReserveDate)){
					reserve.setReserveDate(new Timestamp(DateUtils.parseDate(strReserveDate, "yyyy-MM-dd HH:mm").getTime()));
				}
				if(reserveItem!=null){
					QueryHelper queryHelper = new QueryHelper(ReserveItem.class, "r");
					queryHelper.addCondition("r.itemName=?", URLDecoder.decode(reserveItem.getItemName(), "utf-8"));
					reserve.setReserveItem(reserveItemService.getObjects(queryHelper).get(0));
				}
				reserve.setReserveState(Reserve.RESERVE_STATE_PENDING);
				reserveService.save(reserve);
			}
		}  catch (Exception e) {
			e.printStackTrace();
		}
		return "execute";
	}
	public Map<String, Object> getReturn_map() {
		return return_map;
	}
	public Complain getComplain() {
		return complain;
	}
	public void setComplain(Complain complain) {
		this.complain = complain;
	}
	public Info getInfo() {
		return info;
	}
	public void setInfo(Info info) {
		this.info = info;
	}
	public Reserve getReserve() {
		return reserve;
	}
	public void setReserve(Reserve reserve) {
		this.reserve = reserve;
	}
	public ReserveItem getReserveItem() {
		return reserveItem;
	}
	public void setReserveItem(ReserveItem reserveItem) {
		this.reserveItem = reserveItem;
	}
	public String getStrReserveDate() {
		return strReserveDate;
	}
	public void setStrReserveDate(String strReserveDate) {
		this.strReserveDate = strReserveDate;
	}
	
}
