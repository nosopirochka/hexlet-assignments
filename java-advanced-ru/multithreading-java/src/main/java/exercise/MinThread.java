package exercise;

// BEGIN
public class MinThread extends Thread {

    private int minNumber;
    private int[] numbers;

    public MinThread(int[] numbers) {
        super();
        this.numbers = numbers;
    }

    @Override
    public void run() {
        if (numbers.length == 1) {
            minNumber = numbers[0];
            return;
        }
        var min = numbers[0];
        for (var i = 1; i < numbers.length; i++) {
            if (min > numbers[i]) {
                min = numbers[i];
            }
        }
        minNumber = min;
    }

    public int getMinNumber() {
        return minNumber;
    }
}
// END
