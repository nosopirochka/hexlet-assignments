@import exercise.dto.users.UserPage
@param UserPage page

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User</title>
</head>
<body>
    <h2>Page of ${page.getUser().getFirstName() + " " + page.getUser().getLastName()}</h2>
    <p>Id: ${page.getUser().getId()}</p>
</body>
</html>