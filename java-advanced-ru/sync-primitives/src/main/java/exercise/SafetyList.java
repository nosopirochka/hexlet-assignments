package exercise;

class SafetyList {

    public static void main(String[] args) {
        var sl = new SafetyList(3);
        sl.add(1);
        sl.add(2);
        sl.add(3);

        System.out.println(sl.getSize());
        System.out.println(sl.getCapacity());
        System.out.println();
        sl.add(4);
        System.out.println(sl.getSize());
        System.out.println(sl.getCapacity());

        System.out.println();
        sl.look();

    }
    // BEGIN
    private int[] array;
    private int index;
    private int size;

    public SafetyList() {
        this.array = new int[16];
        this.index = 0;
        this.size = 0;
    }

    public SafetyList(int capacity) {
        this.array = new int[capacity];
        this.index = 0;
        this.size = 0;
    }

    public synchronized void add(int number) {
        try {
            array[index] = number;
            index += 1;
            size++;
        } catch (Exception error) {
            moreCapacity();
            array[index++] = number;
            size++;
        }
    }

    public void look() {
        for (var number : array) {
            System.out.println(number);
        }
    }

    public synchronized int getSize() {
        return size;
    }

    public synchronized int get(int i) {
        return array[i];
    }

    public void moreCapacity() {
        int[] newArray = new int[(getCapacity() * 3) / 2 + 1];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    public int getCapacity() {
        return array.length;
    }
    // END
}
