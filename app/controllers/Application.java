package controllers;

import org.slf4j.LoggerFactory;
import model.User;

import services.PostService;
import services.UserService;

import org.springframework.beans.factory.annotation.Autowired;

import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import views.html.*;

import model.UserPostInput;

import model.LoginInfo;
import org.slf4j.Logger;

import play.*;
import play.mvc.*;

import java.util.List;

@org.springframework.stereotype.Controller
public class Application extends Controller {
    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public Result add() {
        log.info("Someone Entering Add user");
        return ok(add.render("Cliff's Blogging Site", Form.form(User.class)));
    }

    public Result login() {
        log.info("Someone Entering main site");
        session().clear();
        return ok(login.render("Cliff's Blogging Site", Form.form(LoginInfo.class)));
    }

    public Result displayPost() {
        log.info("Someone Entering Posts");
        boolean hasLoginIn = check();
        if (hasLoginIn) {
            return ok(displayPost.render("Cliff's Blogging Site", Form.form(UserPostInput.class)));
        } else {
            log.info("Someone try entering the post without login");
            return redirect(controllers.routes.Application.login());
        }
    }

    public Result createNewPost() {
        log.info("Creating new Post");
        Form<UserPostInput> form = Form.form(UserPostInput.class).bindFromRequest();
        if (form.hasErrors()) {
            log.info("Errors in Form");
            log.info("the errors are {}",form.data());
            return badRequest(displayPost.render("Cliff's Blogging Site", form));
        }
        UserPostInput loginValue = form.get();
        String user = play.mvc.Controller.session("User:");
        log.info("Creating post with username: " + user);
        postService.addUserPost(loginValue.getInputField(), user);
        return redirect(controllers.routes.Application.displayPost());
    }

    public Result auth() {
        log.info("Checking auth");
        Form<LoginInfo> form = Form.form(LoginInfo.class).bindFromRequest();
        if (form.hasErrors()) {
            log.info("Errors in Login Form");
            log.info("the errors are {}",form.data());
            return badRequest(login.render("Cliff's Blogging Site", form));
        }
        LoginInfo loginValue = form.get();
        boolean exists = userService.checkUser(loginValue.getInputField());
        if (exists) {
            log.info("Checking auth complete they do exist");
            session("User:", loginValue.getInputField());
            return redirect(controllers.routes.Application.displayPost());
        }
        log.info("Checking auth complete they don't exist");
        return badRequest(login.render("Cliff's Blogging Site", form));
    }

    public Result getPost() {
        log.info("Getting All posts");
        List<model.UserPost> post = postService.getAllPost();
        return ok(Json.toJson(post));
    }

    public Result addUser() {
        log.info("Adding new user");
        Form<User> form = Form.form(User.class).bindFromRequest();
        if (form.hasErrors()) {
            log.info("Errors in Add User Form");
            log.info("the errors are {}",form.data());
            return badRequest(add.render("Cliff's Blogging Site", form));
        }
        User user = form.get();
        log.info("username : {}, first name : {}, last name : {}, Adding User", user.getUser(), user.getFirstName(),user.getLastName());
        userService.addUser(user);
        return redirect(controllers.routes.Application.login());
    }

    public boolean check() {
            String user = session("User:");
            return (user != null);
    }
}
