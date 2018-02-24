package pengcheng.yin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

import static pengcheng.yin.TestCallable.getTime;

public class CallableTest {
    public static void main(String args[]){
        TestCallable callable = new TestCallable();
        FutureTask<String> futureTask = new FutureTask<String>(callable);

        Thread thread1 = new Thread(futureTask, "爸爸");
        thread1.start();

        System.out.println("儿子还没收到橘子" + " 时间：" + getTime());//验证主线程的执行情况
        try{
            System.out.println(futureTask.get());
            System.out.println("儿子收到橘子" + " 时间：" + getTime());//验证主线程的执行情况
        }catch (InterruptedException | ExecutionException e){
        }
    }
}
