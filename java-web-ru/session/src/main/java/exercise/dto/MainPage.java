package exercise.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;


public class MainPage {
    private Object name;

    public MainPage(Object name) {
        this.name = name;
    }

    public Object getName() {
        return name;
    }
}
