package models;

import java.util.ArrayList;
import java.util.List;
import play.data.validation.Constraints.*;
import play.db.ebean.*;
import java.util.Date;

import javax.persistence.*;
@Entity
public class Meta extends Model {
	@Id
	public Long id;
	@Required
	public String label;
	public Boolean completa;
	public Date conclusao;
	
	public static Finder<Long,Meta> find = new Finder(Long.class, Meta.class);

	
	public static List<Meta> all() {
		return find.all();
	  }
	public static List<Meta> imcompletas(){
		List<Meta> listaResultante = find.all();
		for(Meta meta : listaResultante){
			if(meta.completa){
				listaResultante.remove(meta);
			}
		}
		return listaResultante;
	}
	
	public static List<Meta> completas(){
		List<Meta> listaResultante = find.all();
		for(Meta meta : listaResultante){
			if(!(meta.completa)){
				listaResultante.remove(meta);
			}
		}
		return listaResultante;
	}
	  
	  public static void create(Meta meta) {
		  meta.completa = true;
		  meta.save();
	  }
	  
	  public static void delete(Long id) {
		  find.ref(id).delete();
	  }
	  public static void completar(Long id2) {
		  find.ref(id2).completa = true;
	  }
}
