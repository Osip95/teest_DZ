public class Chronometer implements Runnable {

    private Seconds msg;

    public Chronometer(Seconds msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        int seconds;
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            seconds = (int) (System.currentTimeMillis() - Main.startTime) / 1000;
            synchronized (msg) {
                msg.setSeconds(seconds);
                msg.notifyAll();
            }

        }
    }

}
