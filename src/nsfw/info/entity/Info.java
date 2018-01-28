package nsfw.info.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class Info implements Serializable {
	private String infoId;
	private String type;
	private String source;
	private String title;
	private String content;
	private String memo;
	private String creator;
	private Timestamp createTime;
	private String state;
	
	public static String INFO_STATE_VALID="1";
	public static String INFO_STATE_INVALID="0";
	
	public static String TYPE_TZGG="tzgg";
	public static String TYPE_ZCSD="zcsd";
	public static String TYPE_NSZD="nszd";
	public static Map<String,String> TYPE_MAP=new HashMap<String, String>();
	static{
		TYPE_MAP.put(TYPE_TZGG, "通知公告");
		TYPE_MAP.put(TYPE_ZCSD, "政策速递");
		TYPE_MAP.put(TYPE_NSZD, "纳税指导");
	}
	public String getInfoId() {
		return infoId;
	}
	public void setInfoId(String infoId) {
		this.infoId = infoId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	public Info(String infoId, String type, String source, String title,
			String content, String memo, String creator, Timestamp createTime,
			String state) {
		super();
		this.infoId = infoId;
		this.type = type;
		this.source = source;
		this.title = title;
		this.content = content;
		this.memo = memo;
		this.creator = creator;
		this.createTime = createTime;
		this.state = state;
	}
	public Info() {
	}
	
}
