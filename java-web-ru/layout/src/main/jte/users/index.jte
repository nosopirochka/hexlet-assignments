@import exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
    content = @`
    <div>
    @if(page.getUsers().isEmpty())
        <h2>Users list is empty</h2>
        @else
        @for(var user : page.getUsers())
            <h2><a href="/users/${user.getId()}">${user.getFirstName() + " " + user.getLastName()}</a></h2>
        @endfor
    @endif
    </div>
`
)