package exercise;

import java.util.Map;

// BEGIN
public class SingleTag extends Tag {
    private String name;
    private Map<String, String> attr;

    public SingleTag(String name, Map<String, String> attr) {
        super(name, attr);
    }
}
// END
