public class SecondsPrinter implements Runnable {

    private Seconds msg;

    public SecondsPrinter(Seconds m) {
        this.msg = m;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (msg) {
                try {
                    System.out.println("С начала сессии прошло " + msg.getSeconds() + " секунд");
                    msg.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

}
