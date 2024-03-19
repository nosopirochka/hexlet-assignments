package exercise.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public final class Post {

    private Long id;
    private String name;
    private String body;

    public Post(String name, String body) {
        this.name = name;
        this.body = body;
    }

    public Post(Long id, String name, String body) {
        this.name = name;
        this.body = body;
        this.id = id;
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
