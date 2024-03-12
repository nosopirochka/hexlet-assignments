@import exercise.dto.users.UsersPage
@param UsersPage page

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Users</title>
</head>
<body>
    @if(page.getUsers().isEmpty())
        <p>Empty</p>
    @else
        @for(var user : page.getUsers())
            <div>
                <h2><a href="/users/${user.getId()}">${user.getFirstName() + " " + user.getLastName()}</a></h2>
            </div>
        @endfor
    @endif
</body>
</html>