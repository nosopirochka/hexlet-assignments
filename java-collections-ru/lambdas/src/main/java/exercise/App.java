package exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

// BEGIN
class App {
    public static String[][] enlargeArrayImage(String[][] image) {
        Function<String[], String[]> modifySubArray = (array) -> {
            int length = array.length;
            String[] result = new String[length * 2];
            int j = 0;
            for (int i = 0; i < length * 2; i++, j++) {
                result[i] = array[j];
                i++;
                result[i] = array[j];
            }

            return result;
        };

        String[][] array = Arrays.stream(image)
                .map(modifySubArray)
                .toArray(String[][]::new);

        return modifyArray(array);
    }

    public static String[][] modifyArray(String[][] array) {
        int length = array.length;
        String[][] result = new String[length * 2][];
        int j = 0;
        for (int i = 0; i < length * 2; i++, j++) {
            result[i] = array[j];
            i++;
            result[i] = array[j];
        }

        return result;
    }
}
// END
