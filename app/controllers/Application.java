package controllers;

import org.slf4j.LoggerFactory;
import model.User;

import models.UserDb;

import services.PostService;
import services.UserService;

import org.springframework.beans.factory.annotation.Autowired;

import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import views.html.*;

import org.slf4j.Logger;
import model.Post;
import model.Input;

import play.*;
import play.mvc.*;

import java.util.List;

@org.springframework.stereotype.Controller
public class Application extends Controller {
    @Autowired
    private UserService userService;
    
    @Autowired
    private PostService postService;

    private static final Logger log =LoggerFactory.getLogger(Application.class);

    public Result add() {
        log.info("Someone Entering Add user");
        return ok(add.render("Cliff's Blogging Site", Form.form(User.class)));
    }

    public Result login() {
        log.info("Someone Entering main site");
        session().clear();
        return ok(login.render("Cliff's Blogging Site", Form.form(Input.class)));
    }

    public Result post() {
        log.info("------------------------------------Someone Entering Posts-----------------------------------------------");
        boolean hasLoginIn = check();
        if (hasLoginIn) {
            return play.mvc.Controller.ok(post.render("Cliff's Blogging Site", Form.form(Input.class)));
        } else {
            return play.mvc.Controller.redirect(controllers.routes.Application.login());
        }
    }

    public Result create() {
        log.info("Creating user");
        Form<Input> form = Form.form(Input.class).bindFromRequest();
        Input loginValue = form.get();
        String user = play.mvc.Controller.session("connected");
        log.info("Creating user with username"+ user );
        postService.addPost(loginValue.getInput(), user);
        return play.mvc.Controller.redirect(controllers.routes.Application.post());
    }

    public Result auth() {
        log.info("Checking auth");
        Form<Input> form = Form.form(Input.class).bindFromRequest();
        Input loginValue = form.get();

        boolean exists = userService.checkUser(loginValue.getInput());
        if (exists) {
            log.info("Checking auth complete they exist");
            //System.out.println(loginValue.getInput());
            play.mvc.Controller.session("connected", loginValue.getInput());
            return play.mvc.Controller.redirect(controllers.routes.Application.post());
        }
        log.info("Checking auth complete they don't exist");
        return badRequest(login.render("Cliff's Blogging Site", form));
    }

    public Result getPost() {
        log.info("Getting All posts");
        List<Post> post = postService.getAllPost();
        return play.mvc.Controller.ok(Json.toJson(post));
    }

    public Result addUser() {
        log.info("Adding new user-----------------------------------------");
        Form<User> form = Form.form(User.class).bindFromRequest();
        if (form.hasErrors()) {
            log.info("Errors in Form");
            return badRequest(add.render("Cliff's Blogging Site", form));    
        }
        User user = form.get();
        log.info(user.getFirstName());
        log.info(user.getLastName());
        log.info(user.getUser());
            log.info("Adding User");
            userService.addUser(user);
            return redirect(controllers.routes.Application.post());
    }
    
    public boolean check() {
        try {
            String user = session("connected");
            return (user != null);
        } catch (Exception ex) {
            return false;
        }
    }
}
