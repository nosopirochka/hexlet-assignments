package exercise.dto.posts;

import java.util.List;
import java.util.Map;

import io.javalin.validation.ValidationError;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


public class BuildPostPage {
    private String name;
    private String body;
    private Map<String, List<ValidationError<Object>>> errors;

    public BuildPostPage() {
    }

    public BuildPostPage(String name, String body, Map<String, List<ValidationError<Object>>> errors) {
        this.name = name;
        this.body = body;
        this.errors = errors;
    }

    public String getName() {
        return name;
    }

    public String getBody() {
        return body;
    }

    public Map<String, List<ValidationError<Object>>> getErrors() {
        return errors;
    }
}
