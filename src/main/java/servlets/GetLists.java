package main.java.servlets;

import com.google.gson.Gson;
import com.mongodb.MongoClient;
import main.java.dao.MongoDBListDao;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/lists")
public class GetLists {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllLists() {
        List allList = new ArrayList();

     try {

         MongoClient mongoClient = new MongoClient("localhost",27017);
         MongoDBListDao mongoDBListDAO  = new MongoDBListDao();

         allList = mongoDBListDAO.readAllList();

    }catch (UnknownHostException e){
        throw new RuntimeException();
    }

        Gson gson = new Gson();
        String jsonString = gson.toJson(allList);

        return Response.ok(jsonString).build();
    }
}
