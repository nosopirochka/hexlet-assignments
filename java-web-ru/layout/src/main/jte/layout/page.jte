@import gg.jte.Content
@param Content content

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>Document</title>
</head>
<body>
    <header>
        <table>
            <tr>
                <td>
                    <a href="/">Main</a>
                </td>

                <td>
                    <a href="/users">Users</a>
                </td>
            </tr>
        </table>
    </header>
    <main>
        ${content}
    </main>
<footer>
    <h2>This is a footer</h2>
</footer>
</body>
</html>