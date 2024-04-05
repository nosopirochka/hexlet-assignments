package exercise;

// BEGIN
public class MaxThread extends Thread {
    private int[] numbers;
    private int maxNumber;

    public MaxThread(int[] numbers) {
        super();
        this.numbers = numbers;
    }

    @Override
    public void run() {
        if (numbers.length == 1) {
            maxNumber = numbers[0];
            return;
        }
        int max = numbers[0];
        for (var i = 1; i < numbers.length; i++) {
           if (max < numbers[i]) {
               max = numbers[i];
           }
        }
        maxNumber = max;
    }

    public int getMaxNumber() {
        return maxNumber;
    }
}
// END
