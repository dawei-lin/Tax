package nsfw.reserve.entity;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * ReserveItem entity. @author MyEclipse Persistence Tools
 */

public class ReserveItem implements java.io.Serializable {

	// Fields

	private String itemId;
	private String itemNumber;
	private String itemName;
	private String dealDept;
	private String dealor;
	private String state;
	private Set reserves = new HashSet(0);
	public static Map<String, String> ITEM_STATE_MAP=new HashMap<String, String>();
	public static String ITEM_STATE_VALIB="1";
	public static String ITEM_STATE_INVALIB="0";
	static{
		ITEM_STATE_MAP.put(ITEM_STATE_VALIB, "有效");
		ITEM_STATE_MAP.put(ITEM_STATE_INVALIB, "无效");
	}

	// Constructors

	/** default constructor */
	public ReserveItem() {
	}

	/** full constructor */
	public ReserveItem(String itemNumber, String itemName, String dealDept,
			String dealor, String state, Set reserves) {
		this.itemNumber = itemNumber;
		this.itemName = itemName;
		this.dealDept = dealDept;
		this.dealor = dealor;
		this.state = state;
		this.reserves = reserves;
	}

	// Property accessors

	public String getItemId() {
		return this.itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getItemNumber() {
		return this.itemNumber;
	}

	public void setItemNumber(String itemNumber) {
		this.itemNumber = itemNumber;
	}

	public String getItemName() {
		return this.itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getDealDept() {
		return this.dealDept;
	}

	public void setDealDept(String dealDept) {
		this.dealDept = dealDept;
	}

	public String getDealor() {
		return this.dealor;
	}

	public void setDealor(String dealor) {
		this.dealor = dealor;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Set getReserves() {
		return this.reserves;
	}

	public void setReserves(Set reserves) {
		this.reserves = reserves;
	}

}