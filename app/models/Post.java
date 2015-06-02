package models;

import play.db.ebean.Model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
public class Post extends Model {
    @play.data.validation.Constraints.Required
    public String user_name;
    public Date date;
    public int id_post;
    public String post;
    @Id
    public int id;

   // public String contents;

}