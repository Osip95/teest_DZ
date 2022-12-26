public class Main {
    static long startTime = System.currentTimeMillis();

    public static void main(String[] args) {

        Seconds seconds = new Seconds();

        SecondsPrinter secondsPrinter = new SecondsPrinter(seconds);
        new Thread(secondsPrinter).start();

        PeriodPrinter periodPrinter1 = new PeriodPrinter(seconds, 5);
        new Thread(periodPrinter1).start();

        PeriodPrinter periodPrinter2 = new PeriodPrinter(seconds, 7);
        new Thread(periodPrinter2).start();

        Chronometer chronometer = new Chronometer(seconds);
        new Thread(chronometer).start();

    }
}



