package exercise;

// BEGIN
import java.util.HashMap;
import java.util.Map;
public class FileKV implements KeyValueStorage {
    private String pathForFile;

    public FileKV(String pathForFile, Map<String, String> fileKV) {
        this.pathForFile = pathForFile;
        Utils.writeFile(pathForFile, Utils.serialize(fileKV));
    }
    @Override
    public void set(String key, String value) {
        var fromFile = Utils.unserialize(Utils.readFile(pathForFile));
        fromFile.put(key, value);
        Utils.writeFile(pathForFile, Utils.serialize(fromFile));
    }

    @Override
    public void unset(String key) {
        Map<String, String> fromFile = new HashMap<>(Utils.unserialize(Utils.readFile(pathForFile)));
        fromFile.remove(key);
        Utils.writeFile(pathForFile, Utils.serialize(fromFile));
    }

    @Override
    public String get(String key, String defaultValue) {
        return Utils.unserialize(Utils.readFile(pathForFile)).getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        return Utils.unserialize(Utils.readFile(pathForFile));
    }
}
// END
