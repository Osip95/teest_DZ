public class PeriodPrinter implements Runnable {
    private Seconds msg;
    private final int period;

    public PeriodPrinter(Seconds m, int period) {
        this.msg = m;
        this.period = period;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (msg) {
                try {
                    msg.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if (msg.getSeconds() % period == 0) {
                    System.out.println("Сообщение каждые " + period + " секунд");
                }
            }
        }
    }
}
