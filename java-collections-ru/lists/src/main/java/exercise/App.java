package exercise;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

// BEGIN
public class App {
    public static boolean scrabble(String letters, String word) {
        if (letters.isEmpty() || letters.length() < word.length()) {
            return false;
        } else if (word.isEmpty()) {
            return true;
        } else {
            var arrayLetters = letters.split("");
            var arrayWord = word.toLowerCase().split("");
            List<String> arrayListLetters = new ArrayList<>(Arrays.asList(arrayLetters));
            for (var letter: arrayWord) {
                arrayListLetters.remove(letter);
            }
            return arrayListLetters.size() == arrayLetters.length - arrayWord.length;
        }
    }
}
//END
