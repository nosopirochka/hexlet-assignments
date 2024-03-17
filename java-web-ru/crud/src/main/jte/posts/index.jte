@import exercise.dto.posts.PostsPage
@param PostsPage page

@template.layout.page(content = @`
    @for(var post: page.getPosts())
        <h2><a href="/posts/${post.getId()}">${post.getName()}</a></h2>
    @endfor
    <h3>
        <a href="/posts/?page=${page.getPageOfPosts() - 1}">Previous page</a>
        <a href="/posts/?page=${page.getPageOfPosts() + 1}">Next page</a>
    </h3>
`)