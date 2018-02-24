package pengcheng.yin;

public class TicketThread extends Thread{
    private int ticket = 5;
    private String name;

    public TicketThread(String name) {
        this.name = name;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            if (ticket > 0) {
                System.out.println("T公司"+name + "卖了一张票，编号为t" + (ticket--));
            }
        }
    }
}
