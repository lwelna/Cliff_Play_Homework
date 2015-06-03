package controllers;

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

    private UserDb user;

    public UserDb getUser() {
        return user;
    }

    public void setUser(UserDb user) {
        this.user = user;
    }

    public Result index() {
        return play.mvc.Controller.ok(index.render("Cliff's Blogging Site", Form.form(model.User.class)));

    }

    public Result login() {

        return play.mvc.Controller.ok(login.render("Cliff's Blogging Site", Form.form(Input.class)));

    }

    public Result post() {

        return play.mvc.Controller.ok(post.render("Cliff's Blogging Site", Form.form(Input.class)));

    }

    public Result create() {
        Form<Input> form = Form.form(Input.class).bindFromRequest();
        Input loginValue = form.get();
        String user = play.mvc.Controller.session("connected");
        System.out.println(user);
        postService.addPost(loginValue.getInput(), user);
        return play.mvc.Controller.redirect(controllers.routes.Application.post());

    }

    public Result auth() {
        Form<Input> form = Form.form(Input.class).bindFromRequest();
        Input loginValue = form.get();

        boolean exists = userService.checkUser(loginValue.getInput());
        if (exists) {
            System.out.println(loginValue.getInput());
            play.mvc.Controller.session("connected", loginValue.getInput());
            return play.mvc.Controller.redirect(controllers.routes.Application.post());
        }
        return play.mvc.Controller.ok(login.render("Cliff's Blogging Site", Form.form(Input.class)));
    }

    public Result getPost() {
        List<Post> posts = postService.getAllPost();
        return ok(play.libs.Json.toJson(posts));
    }

//    public Result getUsers() {
//
//        return ok(play.libs.Json.toJson());
//    }
//    public static void connection(){
//        Connection conn = null;
//        try {
//            conn =DriverManager.getConnection("jdbc:mysql://localhost/admin","admin","admin");
//        } catch (Exception ex) {
//            System.out.println("failed");
//        }
//    }
    public Result addUser() {
//
        Form<User> form = Form.form(User.class).bindFromRequest();
        User user = form.get();
        System.out.println(user.getFirstName());
        System.out.println(user.getLastName());
        System.out.println(user.getUser());

        // userService.addUser(user);
        // return play.mvc.Controller.redirect(controllers.routes.Application.index());
//
//
//
////        play.data.Form<models.User> form = play.data.Form.form(models.User.class).bindFromRequest();
        if (form.hasErrors()) {
            System.out.println("bad stuff");
            return badRequest(index.render("Cliff's Blogging Site", form));
        }
        else {
            // model.User task = form.get();
            userService.addUser(user);
            return play.mvc.Controller.redirect(controllers.routes.Application.post());
        }
    }
}
