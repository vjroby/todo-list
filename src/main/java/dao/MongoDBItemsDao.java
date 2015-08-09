package main.java.dao;

import com.mongodb.*;
import main.java.converter.ItemConverter;
import main.java.model.ItemModel;
import main.java.model.ListModel;

import java.util.ArrayList;
import java.util.List;

public class MongoDBItemsDao extends MongoDB{

    private final DBCollection collection;

    public MongoDBItemsDao() {
        DB mongoClient = getDbConnection();
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
