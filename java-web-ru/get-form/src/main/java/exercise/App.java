package exercise;

import io.javalin.Javalin;
import java.util.List;
import exercise.model.User;
import exercise.dto.users.UsersPage;
import java.util.Collections;
import org.apache.commons.lang3.StringUtils;

public final class App {

    // Каждый пользователь представлен объектом класса User
    private static final List<User> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });

        // BEGIN
        app.get("/users", ctx -> {
            var queryParam = ctx.queryParam("term");

            if (queryParam == null) {
                ctx.render("users/index.jte", Collections.singletonMap("page", new UsersPage(USERS)));
            } else {
                var resultOfFilter = USERS.stream()
                        .filter(user -> {
                            var nameOfUser = user.getFirstName().toLowerCase();
                            return nameOfUser.startsWith(queryParam.toLowerCase());
                        })
                        .toList();
                ctx.render("users/index.jte", Collections.singletonMap("page", new UsersPage(resultOfFilter, queryParam)));
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
