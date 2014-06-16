package models;

import java.util.ArrayList;
import java.util.List;
import play.data.validation.Constraints.*;
import play.db.ebean.*;

import javax.persistence.*;
@Entity
public class Meta extends Model {
	@Id
	public Long id;
	@Required
	public String label;
	  
	public static List<Meta> all() {
		return find.all();
	  }
	  
	  public static void create(Meta meta) {
		  meta.save();
	  }
	  
	  public static void delete(Long id) {
		  find.ref(id).delete();
	  }
	  public static Finder<Long,Meta> find = new Finder(
			    Long.class, Meta.class
			  );

}
