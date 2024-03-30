package exercise;

import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

// BEGIN
public class App {
    public static void save(Path path, Car car) {
        String stringForFile = car.serialize();
        try {
            Files.writeString(path, stringForFile, StandardOpenOption.APPEND);
        } catch (Exception error) {
            System.out.println("Nothing");
        }
    }

    public static Car extract(Path path) {
        try {
            String stringFromFile = Files.readString(path);
            return Car.deserialize(stringFromFile);
        } catch (Exception error) {
            System.out.println("Nothing");
        }
        return new Car(
                1,
                "ok",
                "ok",
                "ok",
                new User(1, "1", "1", 1));
    }
}
// END
