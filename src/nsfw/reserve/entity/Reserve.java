package nsfw.reserve.entity;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

/**
 * Reserve entity. @author MyEclipse Persistence Tools
 */

public class Reserve implements java.io.Serializable {

	// Fields

	private String reserveId;
	private ReserveItem reserveItem;
	private String reserveNumber;
	private Timestamp reserveDate;
	private String reserveAddress;
	private String reserveExplain;
	private String reservor;
	private String reservorMobile;
	private Timestamp replyDate;
	private String replyor;
	private String reserveState;
	private String replyContent;
	public static Map<String,String> RESERVE_STATE_MAP;
	public static String RESERVE_STATE_PENDING="0";
	public static String RESERVE_STATE_FAIL="1";
	public static String RESERVE_STATE_SUCCESS="2";
	static{
		RESERVE_STATE_MAP=new HashMap<String, String>();
		RESERVE_STATE_MAP.put(RESERVE_STATE_PENDING, "待处理");
		RESERVE_STATE_MAP.put(RESERVE_STATE_FAIL, "预约失败");
		RESERVE_STATE_MAP.put(RESERVE_STATE_SUCCESS, "预约成功");
	}

	// Constructors

	/** default constructor */
	public Reserve() {
	}

	/** minimal constructor */
	public Reserve(Timestamp reserveDate, Timestamp replyDate) {
		this.reserveDate = reserveDate;
		this.replyDate = replyDate;
	}

	/** full constructor */
	public Reserve(ReserveItem reserveItem, String reserveNumber,
			Timestamp reserveDate, String reserveAddress,
			String reserveExplain, String reservor, String reservorMobile,
			Timestamp replyDate, String replyor, String reserveState,
			String replyContent) {
		this.reserveItem = reserveItem;
		this.reserveNumber = reserveNumber;
		this.reserveDate = reserveDate;
		this.reserveAddress = reserveAddress;
		this.reserveExplain = reserveExplain;
		this.reservor = reservor;
		this.reservorMobile = reservorMobile;
		this.replyDate = replyDate;
		this.replyor = replyor;
		this.reserveState = reserveState;
		this.replyContent = replyContent;
	}

	// Property accessors

	public String getReserveId() {
		return this.reserveId;
	}

	public void setReserveId(String reserveId) {
		this.reserveId = reserveId;
	}

	public ReserveItem getReserveItem() {
		return this.reserveItem;
	}

	public void setReserveItem(ReserveItem reserveItem) {
		this.reserveItem = reserveItem;
	}

	public String getReserveNumber() {
		return this.reserveNumber;
	}

	public void setReserveNumber(String reserveNumber) {
		this.reserveNumber = reserveNumber;
	}

	public Timestamp getReserveDate() {
		return this.reserveDate;
	}

	public void setReserveDate(Timestamp reserveDate) {
		this.reserveDate = reserveDate;
	}

	public String getReserveAddress() {
		return this.reserveAddress;
	}

	public void setReserveAddress(String reserveAddress) {
		this.reserveAddress = reserveAddress;
	}

	public String getReserveExplain() {
		return this.reserveExplain;
	}

	public void setReserveExplain(String reserveExplain) {
		this.reserveExplain = reserveExplain;
	}

	public String getReservor() {
		return this.reservor;
	}

	public void setReservor(String reservor) {
		this.reservor = reservor;
	}

	public String getReservorMobile() {
		return this.reservorMobile;
	}

	public void setReservorMobile(String reservorMobile) {
		this.reservorMobile = reservorMobile;
	}

	public Timestamp getReplyDate() {
		return this.replyDate;
	}

	public void setReplyDate(Timestamp replyDate) {
		this.replyDate = replyDate;
	}

	public String getReplyor() {
		return this.replyor;
	}

	public void setReplyor(String replyor) {
		this.replyor = replyor;
	}

	public String getReserveState() {
		return this.reserveState;
	}

	public void setReserveState(String reserveState) {
		this.reserveState = reserveState;
	}

	public String getReplyContent() {
		return this.replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	

}