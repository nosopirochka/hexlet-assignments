@import exercise.dto.MainPage
@import exercise.util.NamedRoutes
@param MainPage page


@template.layout.page(content = @`
    @if(page != null)
        <h1>${page.getName().toString()}</h1>
        <form action="${NamedRoutes.logoutPath()}" method="post">
            <input type="submit" value="Выйти">
        </form>
    @else
        <form action="${NamedRoutes.loginPath()}" method="post">
            <input type="submit" value="Войти">
        </form>
    @endif
`)