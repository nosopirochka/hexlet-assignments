@import exercise.dto.users.UsersPage
@param UsersPage page


@template.layout.page(
    content = @`
    <form action="/users" method="get">
        <input type="search" value="${page.getTerm()}" name="term">
        <input type="submit" value="Filter">
    </form>
    @if(!page.getUsers().isEmpty())
        @for(var user : page.getUsers())
            <h2>${user.getFirstName() + " " + user.getLastName()}</h2>
        @endfor
    @endif
`)