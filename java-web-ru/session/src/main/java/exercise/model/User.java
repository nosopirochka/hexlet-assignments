package exercise.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public final class User {

    private Long id;

    @ToString.Include
    private String name;

    private String password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public User(Long id, String name, String password) {
        this.name = name;
        this.password = password;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
