package exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Map.Entry;

// BEGIN
class App {
    public static List<Map<String, String>> findWhere(List<Map<String, String>> books, Map<String, String> book) {
        List<Map<String, String>> booksForResult = new ArrayList<>();
        first: for (var bookInBooks: books) {
            for (Map.Entry<String, String> bookInBook : book.entrySet()) {
                var key = bookInBook.getKey();
                var value = bookInBook.getValue();
                if (!(bookInBooks.get(key).equals(value))) {
                    continue first;
                }
            }
            booksForResult.add(bookInBooks);
        }

        return booksForResult;
    }
}
//END
