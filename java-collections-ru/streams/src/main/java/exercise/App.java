package exercise;

import java.util.List;
import java.util.Arrays;

// BEGIN
class App {
    public static long getCountOfFreeEmails(List<String> emails) {
        return emails.stream()
                .filter(App::getAnswer)
                .count();


    }

    public static boolean getAnswer(String email) {
        List<String> emails= List.of("gmail.com", "yandex.ru", "hotmail.com");
        var index = email.indexOf("@");
        var emailSubstring = email.substring(index + 1);

        return emails.contains(emailSubstring);
    }
}
// END
