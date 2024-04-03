package exercise.controller;

import exercise.model.Comment;
import exercise.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.exception.ResourceNotFoundException;
import exercise.dto.PostDTO;
import exercise.dto.CommentDTO;

// BEGIN
@RestController
@RequestMapping("/posts")
public class PostsController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @GetMapping(path = "")
    public List<PostDTO> index() {
        return postRepository.findAll().stream()
                .map(this::toPostDTO)
                .toList();
    }

    @GetMapping(path = "/{id}")
    public PostDTO show(@PathVariable long id) {
        var post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post with id " + id + " not found!"));
        return this.toPostDTO(post);
    }

    public PostDTO toPostDTO(Post post) {
        var dtoPost = new PostDTO();
        dtoPost.setId(post.getId());
        dtoPost.setTitle(post.getTitle());
        dtoPost.setBody(post.getBody());
        var comments = commentRepository.findByPostId(post.getId())
                .stream()
                .map(this::toCommentDTO)
                .toList();
        dtoPost.setComments(comments);
        return dtoPost;
    }

    public CommentDTO toCommentDTO(Comment comment) {
        var commentDTO = new CommentDTO();
        commentDTO.setId(comment.getId());
        commentDTO.setBody(comment.getBody());
        return commentDTO;
    }
}
// END
