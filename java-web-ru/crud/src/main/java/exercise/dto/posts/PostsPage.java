package exercise.dto.posts;

import java.util.List;
import exercise.model.Post;

import lombok.AllArgsConstructor;
import lombok.Getter;


// BEGIN
public class PostsPage {
    private List<Post> posts;
    private int pageOfPosts;

    public PostsPage(List<Post> posts, int pageOfPosts) {
        this.posts = posts;
        this.pageOfPosts = pageOfPosts;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public int getPageOfPosts() {
        return pageOfPosts;
    }
}
// END


