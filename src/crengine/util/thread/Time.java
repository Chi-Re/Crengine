package crengine.util.thread;

import crengine.util.exception.CrengineRuntimeException;

import java.util.Timer;
import java.util.TimerTask;

public class Time {
    /**这破引擎的threadLock，我要你有何用！*/
    static final Object threadLock = new Object();
    /**如果为true所有线程将会停止*/
    public static boolean timeStop = false;
    /**SEC:秒 MIN:分 HR:小时 MS:毫秒<br>*其实也不用这么严谨，直接填数字也不是不行*/
    public final static int MS=-1, SEC=0, MIN=1, HR=2;

    /**
     * @param lever 具体请看{@code toMillisecond()}
     * @param period 循环运行的间隔时间,以所有时间为单位的,根据lever来更改。
     */
    public static void runTask(float period, int lever, Runnable t) {
        long lperiod = toMillisecond(period, lever);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                //当结束开关打开时，清除所有定时器
                if (timeStop) {
                    timer.cancel();
                    return;
                }
                t.run();
            }
        }, 0, lperiod);
    }

    /**
     * 这里默认毫秒
     */
    public static void runTask(long period, Runnable t) {
        Time.runTask(period, Time.MS, t);
    }
    /**这里默认分钟*/
    public static void runTask(float period, Runnable t) {
        Time.runTask(period, Time.SEC, t);
    }

    /**秒*/
    public static float getSecond(long millisecond){
        return millisecond/1000F;
    }
    /**分钟*/
    public static float getMinute(long millisecond){
        return getSecond(millisecond)/60F;
    }
    /**小时*/
    public static float getHour(long millisecond){
        return getMinute(millisecond)/60F;
    }

    /**
     * 将其他单位的时间转化为毫秒。
     * @param time 换算的时间(分钟,秒,小时)
     * @param lever 换算等级 0:秒, 1:分钟, 2:小时 -1:毫秒(?)
     */
    public static long toMillisecond(float time, int lever){
        if (lever == 1){
            return (long) (time*1000F*60F);
        } else if (lever == 2){
            return (long) (time*1000F*60F*60F);
        } else if (lever == 0) {
            return (long) (time * 1000F);
        } else if (lever == -1) {
            return (long) time;
        } else {
            throw new CrengineRuntimeException("换算等级未知，请保持在-1-2");
        }
    }
}
