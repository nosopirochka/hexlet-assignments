package exercise;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.List;
import java.time.LocalDate;
import java.util.stream.Collectors;

// BEGIN
class Sorter {
    public static List<String> takeOldestMans(List<Map<String, String>> people) {
        List<Map<String, String>> dates = new ArrayList<>(List.copyOf(people));
        dates.sort(Comparator.comparing(user -> user.get("birthday")));
        return dates.stream()
                .filter(user -> user.get("gender").equals("male"))
                .map(user -> user.get("name"))
                .collect(Collectors.toList());
    }
}
// END
