@import exercise.dto.LoginPage
@import exercise.util.NamedRoutes
@param LoginPage page


@template.layout.page(content = @`
    <h1>Log in</h1>
    <form action="${NamedRoutes.loginPath()}" method="post">
        <label>
            Name
            @if(page != null)
                <input type="text" name="name" value="${page.getName()}">
                <p>${page.getError()}</p>
            @else
                <input type="text" name="name">
            @endif
        </label>
        <label>
            Password
            <input type="text" name="password">
        </label>
        <input type="submit" value="Log in">
    </form>

`)