@import exercise.dto.posts.PostPage
@param PostPage page

@template.layout.page(content = @`
    <p>id of post: ${page.getPost().getId()}</p>
    <h2>${page.getPost().getName()}</h2>
    <p>${page.getPost().getBody()}</p>
    <a href="/posts">In list of posts</a>
`)
