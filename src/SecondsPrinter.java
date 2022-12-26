public class SecondsPrinter implements Runnable {

    private Seconds seconds;

    public SecondsPrinter(Seconds seconds) {
        this.seconds = seconds;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (seconds) {
                try {
                    System.out.println("С начала сессии прошло " + seconds.getSeconds() + " секунд");
                    seconds.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

}
