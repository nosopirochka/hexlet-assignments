package exercise.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@ToString
public final class Article {

    private Long id;

    @ToString.Include
    private String title;

    private String content;

    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
