package ro.robertgabriel.dao;

import com.mongodb.*;
import com.sun.jersey.api.NotFoundException;
import ro.robertgabriel.converter.ListConverter;
import ro.robertgabriel.model.ListModel;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

public class MongoDBListDao extends  MongoDB{

    private DBCollection collection;


    public MongoDBListDao() {

        DB mongoClient = getDbConnection();
        this.collection = mongoClient.getCollection("lists");

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

    public ListModel readList(ListModel listModel) {
        try {
            DBObject query = BasicDBObjectBuilder.start()
                    .append("_id", new ObjectId(listModel.getId())).get();
            DBObject data = this.collection.findOne(query);

            if (data == null){
                throw new NotFoundException();
            }

            return ListConverter.toList(data);
        }catch (IllegalArgumentException e){
            throw new NotFoundException();
        }

    }


}
