package rest;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.GsonBuilder;
import security.IUserFacade;
import security.UserFacadeFactory;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("all-users")
@RolesAllowed("Admin")
public class AllUsers {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllUsers(){
        IUserFacade facade = UserFacadeFactory.getInstance();
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setExclusionStrategies(new ExclusionStrategy() {
            @Override
            public boolean shouldSkipField(FieldAttributes fieldAttributes) {
                return fieldAttributes.getName().equals("users") || fieldAttributes.getName().equals("passwordHash");
            }

            @Override
            public boolean shouldSkipClass(Class<?> aClass) {
                return false;
            }
        });
        String jsonData = gsonBuilder.create().toJson(facade.getUsers());
        return "{\"message\" : "+jsonData+"}";
    }

}
