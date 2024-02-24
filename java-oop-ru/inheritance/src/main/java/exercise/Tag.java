package exercise;

import java.util.stream.Collectors;
import java.util.Map;

// BEGIN
public abstract class Tag {
    private String name;
    private Map<String, String> attr;

    public Tag(String name, Map<String, String> attr) {
        this.name = name;
        this.attr = attr;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        var result = new StringBuilder("<");
        result.append(name);

        for (var key : attr.keySet()) {
            result.append(String.format(" %s=\"%s\"", key, attr.get(key)));
        }
        result.append(">");

        return result.toString();
    }
}
// END
