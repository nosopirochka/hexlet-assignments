@template.layout.page(content = @`
        <form action="/users" method="post">
        <label>
            Firstname
            <input type="text" required name="firstName">
        </label>
        <label>
            Lastname
            <input type="text" required name="lastName">
        </label>
        <label>
            email
            <input type="email" required name="email">
        </label>
        <label>
            Password
            <input type="password" required name="password">
        </label>
            <input type="submit" value="Register">
        </form>
`)