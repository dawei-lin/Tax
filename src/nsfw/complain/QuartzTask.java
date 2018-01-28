package nsfw.complain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class QuartzTask {
	public void doSimpleTriggerTask(){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("1当前时间:"+dateFormat.format(new Date()));
	}
	public void doCronTriggerTask(){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("2当前时间:"+dateFormat.format(new Date()));
	}
}
