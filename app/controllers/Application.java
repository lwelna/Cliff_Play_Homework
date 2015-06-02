package controllers;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.persistence.EntityManager;
import play.*;
import play.mvc.*;

import views.html.*;
import java.util.List;
import java.util.Date;
import java.util.Iterator;


import org.hibernate.*;
import org.hibernate.cfg.Configuration;


@org.springframework.stereotype.Controller
public class Application extends Controller {

    public static Result index() {
//        connection();

        return ok(index.render("hello, world.", play.data.Form.form(models.User.class)));

    }
    public static Result getUsers() {
        java.util.List<models.User> tasks = new play.db.ebean.Model.Finder(String.class, models.User.class).all();
        return ok(play.libs.Json.toJson(tasks));
    }
//    public static void connection(){
//        Connection conn = null;
//        try {
//            conn =DriverManager.getConnection("jdbc:mysql://localhost/admin","admin","admin");
//        } catch (Exception ex) {
//            System.out.println("failed");
//        }
//    }
    public static Result addUser() {
        play.data.Form<models.User> form = play.data.Form.form(models.User.class).bindFromRequest();
        if (form.hasErrors()) {
            return badRequest(index.render("hello, world", form));
        }
        else {
            models.User task = form.get();
            task.save();
            return redirect(routes.Application.index());
        }
    }
    public static void createUser(){

    }
    public static void checkUser(){

    }
}
