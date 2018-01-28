package nsfw.complain;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;

public class MyTimerTask extends TimerTask {

	@Override
	public void run() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		System.out.println("当前时间:"+dateFormat.format(new Date()));
	}

}
