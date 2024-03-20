package exercise.controller;

import static io.javalin.rendering.template.TemplateUtil.model;

import com.fasterxml.jackson.databind.util.Named;
import com.mifmif.common.regex.Main;
import exercise.dto.MainPage;
import exercise.dto.LoginPage;
import exercise.model.User;
import exercise.repository.UsersRepository;
import static exercise.util.Security.encrypt;

import exercise.util.Generator;
import exercise.util.NamedRoutes;
import exercise.util.Security;
import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;
import io.javalin.validation.ValidationException;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SessionsController {

    // BEGIN
    public static void root(Context ctx) {
        var sessionKey = ctx.sessionAttribute("access");
        if (sessionKey == null) {
            ctx.render("index.jte");
        } else {
            var user = new MainPage(sessionKey);
            ctx.render("index.jte", model("page", user));
        }
    }
    public static void build(Context ctx) {
        ctx.render("build.jte");
    }

    public static void login(Context ctx) {
        var name = ctx.formParam("name");
        try {
            var password = ctx.formParamAsClass("password", String.class)
                    .check(Objects::nonNull, "Wrong username or password.")
                    .get();
            var listOfUsers = Generator.getUsers();
            var userFromReq = listOfUsers.stream()
                    .filter(user -> user.getName().equals(name) && user.getPassword().equals(Security.encrypt(password)))
                    .findFirst();
            if (userFromReq.isPresent()) {
                ctx.sessionAttribute("access", name);
                ctx.redirect("/");
            } else {
                var user = new LoginPage(name, "Wrong username or password.");
                ctx.render("build.jte", model("page", user));
            }
        } catch (ValidationException e) {
            ctx.status(422);
            var returnLoginPage = new LoginPage(name, e.getMessage());
            ctx.render("build.jte", model("page", returnLoginPage));
        }
    }

    public static void delete(Context ctx) {
        ctx.sessionAttribute("access", null);
        ctx.redirect(NamedRoutes.rootPath());
    }
    // END
}
