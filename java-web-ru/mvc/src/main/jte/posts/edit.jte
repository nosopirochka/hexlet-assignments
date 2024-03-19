@import exercise.dto.posts.EditPostPage
@import exercise.util.NamedRoutes
@param EditPostPage page

@template.layout.page(content = @`
    @if(page.getErrors() != null)
        <ul>
            @for(var value : page.getErrors().values())
                @for(var error : value)
                <li>
                    ${error.getMessage()}
                </li>
                @endfor
            @endfor
    @endif
        </ul>

    <form action="${NamedRoutes.postPath(page.getId())}" method="post">
        <label>
            Name
            <input type="text" name="name" value="${page.getName()}">
        </label>
        <label>
            Content
            <textarea name="body">${page.getBody()}</textarea>
        </label>
        <input type="submit" value="Save">
    </form>
`)