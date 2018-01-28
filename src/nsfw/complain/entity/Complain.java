package nsfw.complain.entity;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Complain entity. @author MyEclipse Persistence Tools
 */

public class Complain implements java.io.Serializable {

	// Fields

	private String compId;
	private Boolean isNm;
	private String compName;
	private String compCompany;
	private String compPhone;
	private Timestamp compDate;
	private String toCompDept;
	private String toCompName;
	private String toCompTitle;
	private String toCompContent;
	private String compState;
	private Set complainReplies = new HashSet(0);
	
	public static String COMPLAIN_STATE_UNDONE="0";
	public static String COMPLAIN_STATE_DONE="1";
	public static String COMPLAIN_STATE_INVILIB="2";
	public static Map<String,String> COMPLAIN_STATE_MAP;
	static{
		COMPLAIN_STATE_MAP=new HashMap<String, String>();
		COMPLAIN_STATE_MAP.put(COMPLAIN_STATE_UNDONE, "待处理");
		COMPLAIN_STATE_MAP.put(COMPLAIN_STATE_DONE, "已处理");
		COMPLAIN_STATE_MAP.put(COMPLAIN_STATE_INVILIB, "已过时");
	}

	// Constructors

	/** default constructor */
	public Complain() {
	}

	/** full constructor */
	public Complain(Boolean isNm, String compName, String compCompany,
			String compPhone, Timestamp compDate, String toCompDept,
			String toCompName, String toCompTitle, String toCompContent,
			String copmState, Set complainReplies) {
		this.isNm = isNm;
		this.compName = compName;
		this.compCompany = compCompany;
		this.compPhone = compPhone;
		this.compDate = compDate;
		this.toCompDept = toCompDept;
		this.toCompName = toCompName;
		this.toCompTitle = toCompTitle;
		this.toCompContent = toCompContent;
		this.compState = copmState;
		this.complainReplies = complainReplies;
	}

	// Property accessors

	public String getCompId() {
		return this.compId;
	}

	public void setCompId(String compId) {
		this.compId = compId;
	}

	public Boolean getIsNm() {
		return this.isNm;
	}

	public void setIsNm(Boolean isNm) {
		this.isNm = isNm;
	}

	public String getCompName() {
		return this.compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
	}

	public String getCompCompany() {
		return this.compCompany;
	}

	public void setCompCompany(String compCompany) {
		this.compCompany = compCompany;
	}

	public String getCompPhone() {
		return this.compPhone;
	}

	public void setCompPhone(String compPhone) {
		this.compPhone = compPhone;
	}

	public Timestamp getCompDate() {
		return this.compDate;
	}

	public void setCompDate(Timestamp compDate) {
		this.compDate = compDate;
	}

	public String getToCompDept() {
		return this.toCompDept;
	}

	public void setToCompDept(String toCompDept) {
		this.toCompDept = toCompDept;
	}

	public String getToCompName() {
		return this.toCompName;
	}

	public void setToCompName(String toCompName) {
		this.toCompName = toCompName;
	}

	public String getToCompTitle() {
		return this.toCompTitle;
	}

	public void setToCompTitle(String toCompTitle) {
		this.toCompTitle = toCompTitle;
	}

	public String getToCompContent() {
		return this.toCompContent;
	}

	public void setToCompContent(String toCompContent) {
		this.toCompContent = toCompContent;
	}

	public String getCompState() {
		return this.compState;
	}

	public void setCompState(String compState) {
		this.compState = compState;
	}

	public Set getComplainReplies() {
		return this.complainReplies;
	}

	public void setComplainReplies(Set complainReplies) {
		this.complainReplies = complainReplies;
	}

}