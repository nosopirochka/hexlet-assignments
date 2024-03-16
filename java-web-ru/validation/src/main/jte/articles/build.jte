@import exercise.dto.articles.BuildArticlePage
@param BuildArticlePage page

@template.layout.page(content = @`
    @if(page.getErrors() != null)
    <ul>
    @for(var value : page.getErrors().values())
        @for (var error : value)
            <li>
                ${error.getMessage()}
            </li>
        @endfor
    @endfor
    @endif
    </ul>
    <form action="/articles" method="post">
    <div>
        <label>
            Title
            <input type="text" name="title" value="${page.getTitle()}">
        </label>
    </div>
        <div>
            <label>
                Content
                <textarea name="content">${page.getContent()}</textarea>
            </label>
        </div>
        <div>
            <input type="submit" value="Create">
        </div>
    </form>
`)