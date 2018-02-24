package pengcheng.yin;

public class test {
    public static void main(String[] args) {
        SellTask sellTask = new SellTask();
        TicketRunnable runnable = new TicketRunnable(sellTask);
        Thread r1 = new Thread(runnable, "1号业务员");
        Thread r2 = new Thread(runnable, "2号业务员");
        Thread r3 = new Thread(runnable, "3号业务员");
        r1.start();
        r2.start();
        r3.start();
    }
}
