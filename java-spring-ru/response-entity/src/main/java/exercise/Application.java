package exercise;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import exercise.model.Post;

@SpringBootApplication
@RestController
public class Application {
    // Хранилище добавленных постов
    private List<Post> posts = Data.getPosts();

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // BEGIN
    @GetMapping("/posts")
    public ResponseEntity<List<Post>> index() {
        return ResponseEntity.status(HttpStatus.OK)
                .header("X-Total-Count", String.valueOf(posts.size()))
                .body(posts);
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<Optional<Post>> show(@PathVariable String id) {
        var post = posts.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
        if (post.isPresent()) {
            return ResponseEntity.of(Optional.of(post));
        }
        return ResponseEntity.of(Optional.empty());
    }

    @PostMapping("/posts")
    public ResponseEntity<Post> create(@RequestBody Post post) {
        posts.add(post);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(post);
    }

    @PutMapping("posts/{id}")
    public ResponseEntity<Post> update(@PathVariable String id, @RequestBody Post data) {
        var post = posts.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
        if (post.isPresent()) {
            var oldPost = post.get();
            oldPost.setId(data.getId());
            oldPost.setTitle(data.getTitle());
            oldPost.setBody(data.getBody());
            return ResponseEntity.status(HttpStatus.OK)
                    .body(data);
        }

        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body(data);
    }
    // END

    @DeleteMapping("/posts/{id}")
    public void destroy(@PathVariable String id) {
        posts.removeIf(p -> p.getId().equals(id));
    }
}
