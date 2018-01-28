package nsfw.reserve.action;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import nsfw.reserve.entity.ReserveItem;
import nsfw.reserve.service.ReserveItemService;
import nsfw.user.entity.User;
import nsfw.user.service.UserService;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

import core.action.BaseAction;
import core.util.QueryHelper;

public class ReserveItemAction extends BaseAction {
	@Resource
	private ReserveItemService reserveItemService;
	@Resource
	private UserService userService;
	private ReserveItem reserveItem;
	private Map<String,Object> return_data;
	private String strItemNumber;
	private String strItemName;
	private String strDealDept;
	public String listUI(){
		ActionContext.getContext().getContextMap().put("ITEM_STATE_MAP", ReserveItem.ITEM_STATE_MAP);
		QueryHelper queryHelper = new QueryHelper(ReserveItem.class, "r");
		try {
			if(reserveItem!=null){
				if(StringUtils.isNotBlank(reserveItem.getItemNumber())){
					reserveItem.setItemNumber(URLDecoder.decode(reserveItem.getItemNumber(), "utf-8"));
					queryHelper.addCondition("r.itemNumber like ?", "%"+reserveItem.getItemNumber()+"%");
				}
				if(StringUtils.isNotBlank(reserveItem.getItemName())){
					reserveItem.setItemName(URLDecoder.decode(reserveItem.getItemName(), "utf-8"));
					queryHelper.addCondition("r.itemName like ?", "%"+reserveItem.getItemName()+"%");
				}
				if(StringUtils.isNotBlank(reserveItem.getDealDept())){
					reserveItem.setDealDept(URLDecoder.decode(reserveItem.getDealDept(), "utf-8"));
					queryHelper.addCondition("r.dealDept=?", reserveItem.getDealDept());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		pageResult = reserveItemService.getObjects(queryHelper, pageSize, currentPage);
		return "listUI";
	}
	public String addUI(){
		try {
			if(reserveItem!=null){
				if(StringUtils.isNotBlank(reserveItem.getItemNumber())){
					strItemNumber=URLDecoder.decode(reserveItem.getItemNumber(), "utf-8");
					reserveItem.setItemNumber("");
				}
				if(StringUtils.isNotBlank(reserveItem.getItemName())){
					strItemName=URLDecoder.decode(reserveItem.getItemName(), "utf-8");
					reserveItem.setItemName("");
				}
				if(StringUtils.isNotBlank(reserveItem.getDealDept())){
					strDealDept=URLDecoder.decode(reserveItem.getDealDept(), "utf-8");
					reserveItem.setDealDept("");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "addUI";
	}
	public String getDealors(){
		String dealDept = ServletActionContext.getRequest().getParameter("dealDept");
		if(StringUtils.isNotBlank(dealDept)){
			QueryHelper queryHelper = new QueryHelper(User.class, "u");
			queryHelper.addCondition("u.dept like ?", "%"+dealDept);
			List<User> userList = userService.getObjects(queryHelper);
			return_data=new HashMap<String, Object>();
			return_data.put("msg", "success");
			return_data.put("userList", userList);
		}
		return "success";
	}
	public String add(){
		if(reserveItem!=null){
			reserveItemService.save(reserveItem);
		}
		return "list";
	}
	public String editUI(){
		try {
			if(reserveItem!=null){
				if(StringUtils.isNotBlank(reserveItem.getItemNumber())){
					strItemNumber=URLDecoder.decode(reserveItem.getItemNumber(), "utf-8");
				}
				if(StringUtils.isNotBlank(reserveItem.getItemName())){
					strItemName=URLDecoder.decode(reserveItem.getItemName(), "utf-8");
				}
				if(StringUtils.isNotBlank(reserveItem.getDealDept())){
					strDealDept=URLDecoder.decode(reserveItem.getDealDept(), "utf-8");
				}
				reserveItem=reserveItemService.findById(reserveItem.getItemId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "editUI";
	}
	public String edit(){
		if(reserveItem!=null){
			System.out.println(strItemNumber+"什么鬼");
			reserveItemService.update(reserveItem);
		}
		return "list";
	}
	public String delete(){
		if(reserveItem!=null){
			reserveItemService.delete(reserveItem.getItemId());
		}
		return "list";
	}
	public String deleteSelected(){
		if(selectedRow.length>0){
			for(String itemId:selectedRow){
				reserveItemService.delete(itemId);
			}
		}
		return "list";
	}
	public ReserveItem getReserveItem() {
		return reserveItem;
	}
	public void setReserveItem(ReserveItem reserveItem) {
		this.reserveItem = reserveItem;
	}
	public Map<String, Object> getReturn_data() {
		return return_data;
	}
	public String getStrItemNumber() {
		return strItemNumber;
	}
	public void setStrItemNumber(String strItemNumber) {
		this.strItemNumber = strItemNumber;
	}
	public String getStrItemName() {
		return strItemName;
	}
	public void setStrItemName(String strItemName) {
		this.strItemName = strItemName;
	}
	public String getStrDealDept() {
		return strDealDept;
	}
	public void setStrDealDept(String strDealDept) {
		this.strDealDept = strDealDept;
	}
	
	
}
