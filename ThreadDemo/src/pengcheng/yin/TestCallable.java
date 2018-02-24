package pengcheng.yin;

import java.util.Date;
import java.util.concurrent.Callable;

public class TestCallable implements Callable {
    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName() + "：我买几个橘子去。你就在此地，不要走动" + " 时间：" + getTime());
        Thread.sleep(2000);//模拟买橘子的时间
        return Thread.currentThread().getName() + "：我买完橘子回来了" + " 时间：" + getTime();
    }
    public static String getTime(){
        Date date = new Date();
        return date.getMinutes()+"//"+date.getSeconds()+"";
    }
}
