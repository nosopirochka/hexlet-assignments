package exercise;

import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.stream.Stream;

// BEGIN
class App {
    static final int LENGTH_OF_SUBLINE_OF_ENV_VAR = 12;

    public static void main(String[] args) {
        System.out.println(getForwardedVariables(""));
    }

    public static String getForwardedVariables(String string) {
        String[] someArray1 = Stream.of(string.split("\n"))
                .filter(str -> str.contains("environment"))
                .map(str -> str.replaceAll("\"", ""))
                .map(str -> str.replaceAll("environment=", ""))
                .map(String::trim)
                .map(str -> str.split(","))
                .flatMap(Arrays::stream)
                .filter(str -> str.contains("X_FORWARDED_"))
                .map(str -> str.substring(LENGTH_OF_SUBLINE_OF_ENV_VAR))
                .toArray(String[]::new);

        return String.join(",", someArray1);
    }
}
//END
