package exercise.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;



public class LoginPage {
    private String name;
    private String error;

    public LoginPage(String name, String error) {
        this.name = name;
        this.error = error;
    }

    public String getName() {
        return name;
    }

    public String getError() {
        return error;
    }
}
