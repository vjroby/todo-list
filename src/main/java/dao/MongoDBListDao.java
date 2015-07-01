package main.java.dao;

import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import main.java.converter.ListConverter;
import main.java.model.ListModel;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

public class MongoDBListDAO {

    private DBCollection collection;

    public MongoDBListDAO(MongoClient mongoClient) {
        this.collection = mongoClient.getDB("local").getCollection("todo");
    }

    public ListModel createList(ListModel listModel) {
        DBObject dbObject = ListConverter.toDBObject(listModel);
        this.collection.insert(dbObject);
        ObjectId id = (ObjectId) dbObject.get("_id");
        listModel.setId(id.toString());
        return listModel;
    }
    //TODO need to implement
    public void updateList(ListModel listModel){

    }

    public List<ListModel> readAllList() {

        List<ListModel> data = new ArrayList<ListModel>();

        DBCursor dbCursor = collection.find();

        while (dbCursor.hasNext()){
            DBObject dbObject = dbCursor.next();
            ListModel listModel = ListConverter.toList(dbObject);
            data.add(listModel);
        }
        return data;
    }

    //TODO implement
    public void deleteList(ListModel listModel) {

    }

//    public ListModel readList(ListModel) {
//
//    }
}
