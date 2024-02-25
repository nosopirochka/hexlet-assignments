package exercise;

import java.lang.reflect.Field;
// BEGIN
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Validator {

    public static List<String> validate(Address obj) {
        List<String> result = new ArrayList<>();
        var fields = Address.class.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(NotNull.class)) {
                try {
                    field.setAccessible(true);
                    if(field.get(obj) == null) {
                        result.add(field.getName());
                    };
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        }
        return result;
    }

    public static Map<String, List<String>> advancedValidate(Address obj) {
        Map<String, List<String>> result = new HashMap<>();
        var fields = Address.class.getDeclaredFields();

        for (Field field : fields) {

            List<String> errorsMessage = new ArrayList<>();

            try {
                field.setAccessible(true);
                var fieldValue = field.get(obj);

                if (field.isAnnotationPresent(NotNull.class)) {
                    if (fieldValue == null) {
                        errorsMessage.add("can not be null");
                    }
                }

                if (fieldValue != null) {
                    if (field.isAnnotationPresent(MinLength.class)) {
                        MinLength annot = field.getAnnotation(MinLength.class);
                        if (((String) fieldValue).length() < annot.minLength()) {
                            errorsMessage.add("length less than 4");
                        }
                    }
                }
                if (!errorsMessage.isEmpty()) {
                    result.put(field.getName(), errorsMessage);
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        return result;
    }
}
// END
