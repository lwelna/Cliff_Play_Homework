package models;

import play.db.ebean.Model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User extends Model {
    @play.data.validation.Constraints.Required
    public String first_name;
    @play.data.validation.Constraints.Required
    public String last_name;
    @play.data.validation.Constraints.Required
    public String user;
    public Date date;
    @Id
    public int id;

   // public String contents;

}