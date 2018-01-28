package core.constant;

import java.util.HashMap;
import java.util.Map;

public class Constant {
	public static String PRIVILEGE_XZGL="xzgl";
	public static String PRIVILEGE_HQFW="hqfw";
	public static String PRIVILEGE_ZXXX="zxxx";
	public static String PRIVILEGE_NSFW="nsfw";
	public static String PRIVILEGE_SPACE="space";
	public static Map<String,String> privilegeMap=new HashMap<String, String>();
	static{
		privilegeMap.put(PRIVILEGE_XZGL, "行政管理");
		privilegeMap.put(PRIVILEGE_HQFW, "后勤服务");
		privilegeMap.put(PRIVILEGE_ZXXX, "在线学习");
		privilegeMap.put(PRIVILEGE_NSFW, "纳税服务");
		privilegeMap.put(PRIVILEGE_SPACE, "我的空间");
	}
}
