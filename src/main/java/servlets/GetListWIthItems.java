package main.java.servlets;

import com.google.gson.Gson;
import main.java.dao.MongoDBItemsDao;
import main.java.dao.MongoDBListDao;
import main.java.model.ListModel;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/lists/{id}")
public class GetListWIthItems {


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getList(@PathParam("id") String listId) {


        MongoDBListDao mongoDBListDAO  = new MongoDBListDao();

        ListModel listModel = new ListModel();
        listModel.setId(listId);

        listModel = mongoDBListDAO.readList(listModel);

        Gson gson = new Gson();
        String jsonString = gson.toJson(listModel);

        return Response.ok(jsonString).build();
    }

    @Path("/items")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getListWIthItems(@PathParam("id") String listId) {


        MongoDBListDao mongoDBListDAO  = new MongoDBListDao();
        MongoDBItemsDao mongoDBItemsDao = new MongoDBItemsDao();

        ListModel listModel = new ListModel();
        listModel.setId(listId);

        listModel = mongoDBListDAO.readList(listModel);
        listModel.setItems(mongoDBItemsDao.readItemsByListId(listModel));

        Gson gson = new Gson();
        String jsonString = gson.toJson(listModel);

        return Response.ok(jsonString).build();
    }
}
