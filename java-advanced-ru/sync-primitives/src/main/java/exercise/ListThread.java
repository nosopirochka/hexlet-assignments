package exercise;


// BEGIN
public class ListThread extends Thread {

    private SafetyList array;

    public ListThread(SafetyList array) {
        super();
        this.array = array;
    }

    @Override
    public void run() {
        var i = 0;
        while (i < 1000) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            array.add(i++);
        }
    }
}
// END
