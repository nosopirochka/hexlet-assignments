package exercise.controller;

import org.apache.commons.lang3.StringUtils;
import exercise.util.Security;
import exercise.model.User;
import exercise.util.NamedRoutes;
import static io.javalin.rendering.template.TemplateUtil.model;
import exercise.repository.UserRepository;
import exercise.dto.users.UserPage;
import io.javalin.http.NotFoundResponse;
import io.javalin.http.Context;

import java.util.Collections;


public class UsersController {

    public static void build(Context ctx) throws Exception {
        ctx.render("users/build.jte");
    }

    // BEGIN
    public static void create(Context ctx) {
        var firstname = ctx.formParam("firstName");
        var lastname = ctx.formParam("lastName");
        var email = ctx.formParam("email");
        var password = ctx.formParam("password");
        var token = Security.generateToken();
        ctx.cookie("who-are-you", token);

        var newUser = new User(
                firstname,
                lastname,
                email,
                password,
                token
        );

        UserRepository.save(newUser);
        var userFromBd = UserRepository.getEntities().stream()
                .filter(user -> user.getToken().equals(token))
                .findFirst();
        var pathForRedirect = NamedRoutes.userPath(userFromBd.get().getId());
        ctx.redirect(pathForRedirect);
    }

    public static void show(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var cookieFromClient = ctx.cookie("who-are-you");
        var userFromBd = UserRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("User not found"));

        if (userFromBd.getToken().equals(cookieFromClient)) {
            var tempUser = new UserPage(userFromBd);
            ctx.render("users/show.jte", Collections.singletonMap("page", tempUser));
        } else {
            ctx.redirect(NamedRoutes.buildUserPath());
        }
    }
    // END
}
