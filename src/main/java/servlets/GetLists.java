package main.java.servlets;

import com.google.gson.Gson;
import main.java.dao.MongoDBListDao;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;


@Path("/lists")
public class GetLists {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllLists() {
        List allList = new ArrayList();


         MongoDBListDao mongoDBListDAO  = new MongoDBListDao();

         allList = mongoDBListDAO.readAllList();

        Gson gson = new Gson();
        String jsonString = gson.toJson(allList);

        return Response.ok(jsonString).build();
    }

}
