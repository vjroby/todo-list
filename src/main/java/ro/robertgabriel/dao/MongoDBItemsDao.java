package ro.robertgabriel.dao;

import com.mongodb.*;
import ro.robertgabriel.converter.ItemConverter;
import ro.robertgabriel.model.ItemModel;
import ro.robertgabriel.model.ListModel;

import java.util.ArrayList;
import java.util.List;

public class MongoDBItemsDao{

    private final DBCollection collection;

    public MongoDBItemsDao() {
        DB mongoClient = MongoDB.getMongoDB().getDbConnection();
        this.collection = mongoClient.getCollection("items");
    }

    public List<ItemModel> readItemsByListId(ListModel listModel) {
        List<ItemModel> data = new ArrayList<ItemModel>();

        BasicDBObject query = new BasicDBObject();
        query.put("list_id", listModel.getId());

        DBCursor dbCursor = collection.find(query);

        while (dbCursor.hasNext()){
            DBObject dbObject = dbCursor.next();
            ItemModel itemModel = ItemConverter.toItem(dbObject);
            data.add(itemModel);
        }

        return  data;
    }
}
