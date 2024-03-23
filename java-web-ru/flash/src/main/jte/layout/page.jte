@import exercise.dto.posts.PostsPage
@import gg.jte.Content
@param Content content
@param PostsPage page = null

<h1>
    @if(page != null && page.getFlash() != null)
        ${page.getFlash()}
    @endif
</h1>
${content}

