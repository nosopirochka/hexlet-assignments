package exercise;

import java.util.Map;
import java.util.logging.Logger;
import java.util.logging.Level;

class App {
    private static final Logger LOGGER = Logger.getLogger("AppLogger");

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6};
        System.out.println(getMinMax(numbers));
    }

    // BEGIN
    public static Map<String, Integer> getMinMax(int[] numbers) {
        var minThread = new MinThread(numbers);
        var maxThread = new MaxThread(numbers);

        minThread.start();
        LOGGER.info("Thread " + minThread.getName() + " started");
        maxThread.start();
        LOGGER.info("Thread " + maxThread.getName() + " started");

        try {
            minThread.join();
            LOGGER.info("Thread " + minThread.getName() + " finished");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            maxThread.join();
            LOGGER.info("Thread " + maxThread.getName() + " finished");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return Map.of("min", minThread.getMinNumber(), "max", maxThread.getMaxNumber());
    }
    // END
}
