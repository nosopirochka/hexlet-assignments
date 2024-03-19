package exercise.dto.posts;

import java.util.List;
import java.util.Map;
import io.javalin.validation.ValidationError;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

// BEGIN
public class EditPostPage {
    private Long id;
    private String name;
    private String body;
    private Map<String, List<ValidationError<Object>>> errors;

    public EditPostPage(Long id, String name, String body, Map<String, List<ValidationError<Object>>> errors) {
        this.id = id;
        this.name = name;
        this.body = body;
        this.errors = errors;
    }

    public EditPostPage(Long id, String name, String body) {
        this.id = id;
        this.name = name;
        this.body = body;
    }

    public Long getId() {
        return id;
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
// END
