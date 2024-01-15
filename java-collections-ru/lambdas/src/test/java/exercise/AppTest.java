package exercise;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

// BEGIN
class AppTest {
    @Test
    void testEnlargeArrayImageUsual() {

        String[][] array = {
                {"0", "1", "0"},
                {"1", "0", "1"},
                {"0", "1", "0"}
        };

        String[][] array1 = {
                {"0", "0", "1", "1", "0", "0"},
                {"0", "0", "1", "1", "0", "0"},
                {"1", "1", "0", "0", "1", "1"},
                {"1", "1", "0", "0", "1", "1"},
                {"0", "0", "1", "1", "0", "0"},
                {"0", "0", "1", "1", "0", "0"}
        };

        assertThat(App.enlargeArrayImage(array)).isEqualTo(array1);
    }

    @Test
    void testEnlargeArrayImageWithDifferentArrays() {
        String[][] array = new String[3][];
        array[0] = new String[1];
        array[1] = new String[2];
        array[2] = new String[3];

        array[0][0] = "1";

        array[1][0] = "1";
        array[1][1] = "2";

        array[2][0] = "1";
        array[2][1] = "2";
        array[2][2] = "1";

        String[][] array1 = {
                {"1", "1"},
                {"1", "1"},
                {"1", "1", "2", "2"},
                {"1", "1", "2", "2"},
                {"1", "1", "2", "2", "1", "1"},
                {"1", "1", "2", "2", "1", "1"}
        };

        assertThat(App.enlargeArrayImage(array)).isEqualTo(array1);
    }

    @Test
    void testEnlargeArrayImageWithEmptyArrays() {
        String[][] array = {{}, {}};
        String[][] array1 = {{}, {}, {}, {}};
        assertThat(App.enlargeArrayImage(array)).isEqualTo(array1);
    }
}
// END
