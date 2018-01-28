package nsfw.complain;

import java.util.Timer;

public class MyTimerTest {

	public static void main(String[] args) {
		Timer timer = new Timer();
		timer.schedule(new MyTimerTask(), 2000, 3000);

	}

}
