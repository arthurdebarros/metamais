package controllers;

import play.*;
import play.mvc.*;
import models.*;
import play.data.*;

import views.html.*;

public class Application extends Controller {
	
	static Form<Meta> metaForm = Form.form(Meta.class);
	
    public static Result index() {
        return redirect(routes.Application.verMetas());
    }
    
    
    public static Result verMetas(){
    	return ok(views.html.index.render(Meta.all(), metaForm));
    }
    
    public static Result novaMeta() {
    	Form<Meta> filledForm = metaForm.bindFromRequest();
    	  if(filledForm.hasErrors()) {
    	    return badRequest(
    	      views.html.index.render(Meta.all(), filledForm)
    	    );
    	  } else {
    	    Meta.create(filledForm.get());
    	    return redirect(routes.Application.verMetas());  
    	  }
	}
    
    public static Result deleteMeta(Long id){
    	Meta.delete(id);
    	return redirect(routes.Application.verMetas());
    }
    

}
