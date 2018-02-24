package pengcheng.yin;

public class TicketRunnable implements Runnable {
    SellTask sellTask;
    public TicketRunnable(SellTask sellTask){
        this.sellTask = sellTask;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            sellTask.sellTicket();
        }
    }
}
