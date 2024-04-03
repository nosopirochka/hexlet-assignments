package exercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

// BEGIN
import exercise.daytime.Daytime;
@RestController
public class WelcomeController {

    @Autowired
    private Daytime dayTime;

    @GetMapping("/welcome")
    public String welcome() {
        return "It is " + dayTime.getName() + " now! Welcome to Spring!";
    }
}
// END
