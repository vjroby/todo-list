package ro.robertgabriel;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/home")
public class Start {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getHome(){
        return "home";
    }
}
