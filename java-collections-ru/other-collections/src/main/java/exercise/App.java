package exercise;

import java.util.*;

// BEGIN
class App {
    public static Map<String, String> genDiff(Map<String, Object> map1, Map<String, Object> map2) {
        Map<String, String> map = new LinkedHashMap<>();
        Set<String> set = new TreeSet<>(String::compareTo);
        set.addAll(map1.keySet());
        set.addAll(map2.keySet());
        for (String key: set) {
            Object value1 = map1.get(key);
            Object value2 = map2.get(key);
            if (value1 == value2) {
                map.put(key, "unchanged");
            } else {
                if (value1 == null) {
                    map.put(key, "added");
                } else if (value2 == null) {
                    map.put(key, "deleted");
                } else {
                    map.put(key, "changed");
                }
            }
        }

        return map;
    }
}
//END
