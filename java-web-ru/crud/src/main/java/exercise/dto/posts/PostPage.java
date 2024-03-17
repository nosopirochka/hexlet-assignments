package exercise.dto.posts;

import exercise.model.Post;

import lombok.AllArgsConstructor;
import lombok.Getter;


public class PostPage {
    private Post post;

    public PostPage(Post post) {
        this.post = post;
    }

    public Post getPost() {
        return post;
    }
}
