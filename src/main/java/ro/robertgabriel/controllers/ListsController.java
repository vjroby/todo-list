package ro.robertgabriel.controllers;

import org.springframework.web.bind.annotation.*;
import ro.robertgabriel.dao.MongoDBItemsDao;
import ro.robertgabriel.dao.MongoDBListDao;
import ro.robertgabriel.model.ListModel;

import java.util.List;

@RestController
@RequestMapping("/services/lists")
public class ListsController {
    private MongoDBListDao mongoDBListDao;
    private MongoDBItemsDao mongoDBItemsDao;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody List getAllLists() {

        return  getMongoDBListDao().readAllList();
    }

    @RequestMapping(value = "/{listId}",method = RequestMethod.GET)
    public @ResponseBody ListModel getList(@PathVariable(value = "listId") String listId) {

        ListModel listModel = new ListModel();
        listModel.setId(listId);

        return getMongoDBListDao().readList(listModel);
    }

    @RequestMapping(value = "/{listId}/items", method = RequestMethod.GET)
    public @ResponseBody ListModel getListWithItems(@PathVariable(value = "listId") String listId) {

        ListModel listModel = new ListModel();
        listModel.setId(listId);
        listModel = getMongoDBListDao().readList(listModel);
        listModel.setItems(getMongoDBItemsDao().readItemsByListId(listModel));

        return listModel;

    }

    private MongoDBListDao getMongoDBListDao() {
        return mongoDBListDao;
    }

    public void setMongoDBListDao(MongoDBListDao mongoDBListDao) {
        this.mongoDBListDao = mongoDBListDao;
    }

    private MongoDBItemsDao getMongoDBItemsDao() {
        return mongoDBItemsDao;
    }

    public void setMongoDBItemsDao(MongoDBItemsDao mongoDBItemsDao) {
        this.mongoDBItemsDao = mongoDBItemsDao;
    }
}
