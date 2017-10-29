package rest;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by adam on 10/29/2017.
 */
@Path("random-number")
@RolesAllowed("User")
public class RandomNumber {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getRandomNumber(){
        return "{\"message\" : \""+Math.random()+"\"}";
    }

}
