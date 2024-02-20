package exercise;

import java.util.Arrays;

// BEGIN
public class ReversedSequence implements CharSequence {
    private String reversedSequence;
    public ReversedSequence(String reversedSequence) {
        this.reversedSequence =  Arrays.stream(reversedSequence.split(""))
                .reduce("", (char1, char2) -> char2 + char1);
    }

    public int length() {
        return reversedSequence.length();
    }

    public char charAt(int index) {
        if (length() <= 0) {
            throw new IndexOutOfBoundsException();
        }
        return reversedSequence.charAt(index);
    }

    public ReversedSequence subSequence(int start, int end) {
        if (start < 0 || end > reversedSequence.length()) {
            throw new IndexOutOfBoundsException();
        }
        return new ReversedSequence(reversedSequence.substring(start, end));
    }

    @Override
    public String toString() {
        return reversedSequence;
    }
}
// END
