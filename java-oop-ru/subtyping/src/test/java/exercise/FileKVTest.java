package exercise;

import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import com.fasterxml.jackson.databind.ObjectMapper;
// BEGIN
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Map;
// END


class FileKVTest {

    private static Path filepath = Paths.get("src/test/resources/file").toAbsolutePath().normalize();

    @BeforeEach
    public void beforeEach() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(new HashMap<String, String>());
        Files.writeString(filepath, content, StandardOpenOption.CREATE);
    }

    // BEGIN
    @Test
    public void testFileKV(){
        Map<String, String> map = new HashMap<>(Map.of("1", "one"));
        KeyValueStorage fileKV = new FileKV("src/test/resources/file", map);
        assertEquals(map, fileKV.toMap());

        map.put("2", "two");
        fileKV.set("2", "two");
        assertEquals(map, fileKV.toMap());

        map.remove("1");
        fileKV.unset("1");
        assertEquals(map, fileKV.toMap());
    }
    // END
}
