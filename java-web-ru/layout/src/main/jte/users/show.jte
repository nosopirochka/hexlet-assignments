@import exercise.dto.users.UserPage
@param UserPage page

@template.layout.page(
        content = @`<h1>This page is ${page.getUser().getFirstName() + " " + page.getUser().getLastName()} page</h1>`)