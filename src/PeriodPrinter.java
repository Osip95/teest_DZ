public class PeriodPrinter implements Runnable {
    private Seconds seconds;
    private final int period;

    public PeriodPrinter(Seconds seconds, int period) {
        this.seconds = seconds;
        this.period = period;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (seconds) {
                try {
                    seconds.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if (seconds.getSeconds() % period == 0) {
                    System.out.println("Сообщение каждые " + period + " секунд");
                }
            }
        }
    }
}
