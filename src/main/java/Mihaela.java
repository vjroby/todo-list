package main.java;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/dragosteamea")
public class Mihaela {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getLove(){
        return "<h1>Mihaela, dragostea mea!</h1>";
    }
}
