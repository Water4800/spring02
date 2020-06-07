package thread;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 实现定时任务
 */
public class TimerTest {

    public static void main(String[] args) throws ParseException {

        Timer timer = new Timer();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date firstTime = sdf.parse("2020-06-07 16:40:00");
        timer.schedule(new LogTimerTask(),firstTime,1000*2);

    }

}

class LogTimerTask extends TimerTask{


    @Override
    public void run() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String now  = sdf.format(new Date());
        System.out.println(now + "执行线程");

    }
}
