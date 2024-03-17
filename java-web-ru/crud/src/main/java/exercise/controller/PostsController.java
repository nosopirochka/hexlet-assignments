package exercise.controller;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import exercise.dto.posts.PostsPage;
import exercise.dto.posts.PostPage;
import exercise.model.Post;
import exercise.repository.PostRepository;

import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;
import io.javalin.validation.ValidationException;

public class PostsController {

    // BEGIN
    public static void showPost(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var postFromReq = PostRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Page not found"));
        var postForResp = new PostPage(postFromReq);
        ctx.render("posts/show.jte", Collections.singletonMap("page", postForResp));
    }

    public static void showPosts(Context ctx) {
        int page = ctx.queryParamAsClass("page", Integer.class).getOrDefault(1);
        if (page == 0) {
            ctx.redirect("/posts/?page=1");
        } else if (page > PostRepository.getEntities().size() / 5) {
            var forRedirect = PostRepository.getEntities().size() / 5;
            ctx.redirect("/posts/?page=" + forRedirect);
        } else {
            var listOfPosts = new PostsPage(PostRepository.getEntities()
                    .subList(page * 5 - 5, page * 5), page);
            ctx.render("posts/index.jte", Collections.singletonMap("page", listOfPosts));
        }
//        var sizeOfPostsList = PostRepository.getEntities().size();
//        page = page <= 0 ? 1 : (page * 5 > sizeOfPostsList ? sizeOfPostsList / 5 : page);
    }
    // END
}
