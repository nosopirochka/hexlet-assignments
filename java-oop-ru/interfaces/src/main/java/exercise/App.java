package exercise;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
class App {
    public static List<String> buildApartmentsList(List<Home> homes, int amount) {
        return homes.stream()
                .sorted(Home::compareTo)
                .map(Home::toString)
                .limit(amount)
                .collect(Collectors.toList());
    }
}
// END
