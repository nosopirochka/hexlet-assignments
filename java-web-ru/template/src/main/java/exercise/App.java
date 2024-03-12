package exercise;

import io.javalin.Javalin;
import java.util.List;

import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;
import exercise.model.User;
import exercise.dto.users.UserPage;
import exercise.dto.users.UsersPage;
import java.util.Collections;

public final class App {

    // Каждый пользователь представлен объектом класса User
    private static final List<User> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });

        // BEGIN
//        var users = new UsersPage(USERS);
        app.get("/users", ctx -> {
            ctx.render("users/index.jte", Collections.singletonMap("page", new UsersPage(USERS)));
        });

        app.get("/users/{id}", ctx -> {
           int idOfUser = ctx.pathParamAsClass("id", int.class).get();
           if (USERS.size() < idOfUser || idOfUser < 0) {
               throw new NotFoundResponse("Not found page");
           } else {
               for (var user : USERS) {
                   if (user.getId() == idOfUser) {
                       ctx.render("users/show.jte", Collections.singletonMap("page", new UserPage(user)));
                       break;
                   }
               }
           }
        });
        // END

        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
