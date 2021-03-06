package models;

import java.util.*;

import javax.persistence.*;

import play.db.ebean.*;
import play.data.validation.Constraints.*;

import play.db.ebean.Model;

import models.*;

@Entity
public class Teacher extends Model {
	
	@Id
	public String name;
	
	@ManyToMany(cascade = CascadeType.REMOVE)
	public List<Course> courses = new ArrayList<>();
	
	public static Finder<String, Teacher> find = new Finder<String, Teacher>(String.class, Teacher.class);

	public Teacher(String name) {
		this.name = name;
		courses = new ArrayList<>();
	}


    public static int count() {
        return find.findRowCount();
    }
	
	public static List<Teacher> all() {
	  return find.all();
	}

	public static void create(Teacher teacher) {
		System.out.println("teacher :\n"
				+ "name : " + teacher.name);
	  teacher.save();
	  teacher.saveManyToManyAssociations("courses");
	}
	
	public static void delete(String name, String s) {
	  find.byId(name).delete();
	}
	
}
