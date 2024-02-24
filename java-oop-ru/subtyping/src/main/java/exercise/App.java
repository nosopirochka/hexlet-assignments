package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.HashSet;

// BEGIN
public class App {
    public static void swapKeyValue(KeyValueStorage keyValueStorage) {
        Set<String> keysForRemove = new HashSet<>(keyValueStorage.toMap().keySet());
        keysForRemove.removeAll(keyValueStorage.toMap().values());
        for (Map.Entry<String, String> keyValue : keyValueStorage.toMap().entrySet()) {
            keyValueStorage.set(keyValue.getValue(), keyValue.getKey());
            System.out.println(keyValueStorage.toMap());
        }
        for (var key : keysForRemove) {
            keyValueStorage.unset(key);
        }
    }
}
// END
