package exercise;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AppTest {

    @Test
    void testTake() {
        // BEGIN
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        List<Integer> list1 = Arrays.asList();
        Assertions.assertEquals(App.take(list, 2), Arrays.asList(1, 2));
        Assertions.assertEquals(App.take(list, 8), Arrays.asList(1, 2, 3, 4));
        Assertions.assertEquals(App.take(list, 0), Arrays.asList());
        //empty list
        Assertions.assertEquals(App.take(list1, 2), Arrays.asList());
        // END
    }
}
