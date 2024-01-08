package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class App {
    public static Map<String, Integer> getWordCount(String sentense) {
        if (sentense.isEmpty()) {
            return new HashMap<>();
        }
        Map<String, Integer> words= new HashMap<>();
        var listSentence = sentense.split(" ");
        for (String word: listSentence) {
            var countWord = words.getOrDefault(word, 0);
            countWord += 1;
            words.put(word, countWord);
        }

        return words;
    }

    public static String toString(Map<String, Integer> words) {
        if (words.isEmpty()) {
            return "{}";
        }
        var string = new StringBuilder("{\n");
        for (Map.Entry<String, Integer> word: words.entrySet()) {
            System.out.println();
            var someString = String.format("  %s: %d\n", word.getKey(), word.getValue());
            string.append(someString);
        }
        string.append("}");

        return string.toString();
    }
}
//END
