package models;

import java.util.ArrayList;
import java.util.List;
import play.data.validation.Constraints.*;

public class Meta {
	
	public Long id;
	@Required
	public String label;
	  
	public static List<Meta> all() {
		return new ArrayList<Meta>();
	  }
	  
	  public static void create(Meta meta) {
	  }
	  
	  public static void delete(Long id) {
	  }

}
