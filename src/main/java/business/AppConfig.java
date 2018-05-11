package business;

import java.util.HashSet;
import java.util.Set;
import business.UserResource;
import javax.ws.rs.core.Application;

public class AppConfig extends Application{
	
	public Set<Class<?>> getClasses(){
		Set<Class<?>> resources = new HashSet<>();
		resources.add(UserResource.class);
		return resources;
	}
}
