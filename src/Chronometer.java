public class Chronometer implements Runnable {

    private Seconds seconds;

    public Chronometer(Seconds seconds) {
        this.seconds = seconds;
    }

    @Override
    public void run() {
        int time;
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            time = (int) (System.currentTimeMillis() - Main.startTime) / 1000;
            synchronized (seconds) {
                seconds.setSeconds(time);
                seconds.notifyAll();
            }

        }
    }

}
