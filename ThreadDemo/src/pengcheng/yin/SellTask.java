package pengcheng.yin;

public class SellTask {
    private int ticket = 10;
    public synchronized void sellTicket(){
        if (ticket > 0) {
            try{
                Thread.sleep(500);
                System.out.println("R公司"+Thread.currentThread().getName() + "卖了一张票，编号为r" + (ticket--));
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
