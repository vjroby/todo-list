package main.java.dao;

import com.mongodb.*;
import main.java.converter.ListConverter;
import main.java.model.ListModel;
import org.bson.types.ObjectId;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class MongoDBListDao {

    private DBCollection collection;

    public MongoDBListDao() {
        String host = System.getenv("OPENSHIFT_MONGODB_DB_HOST");
        String sport = System.getenv("OPENSHIFT_MONGODB_DB_PORT");
        String db = System.getenv("OPENSHIFT_APP_NAME");
        if(db == null)
            db = "todo";
        String user = System.getenv("OPENSHIFT_MONGODB_DB_USERNAME");
        String password = System.getenv("OPENSHIFT_MONGODB_DB_PASSWORD");
        int port = Integer.decode(sport);

        try {
            MongoCredential credential = MongoCredential.createCredential(user,
                    db,
                    password.toCharArray());

            List <MongoCredential> listMongoCredentials = new ArrayList<MongoCredential>();

            listMongoCredentials.add(credential);

            MongoClient mongoClient = new MongoClient(new ServerAddress(host, port), listMongoCredentials);
            DB mongoDb = mongoClient.getDB(db);

            this.collection = mongoDb.getCollection("todo");



        } catch (UnknownHostException e) {
            throw new RuntimeException("Failed to access Mongo server", e);
        }


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
        DBObject query = BasicDBObjectBuilder.start()
                .append("_id", new ObjectId(listModel.getId())).get();
        DBObject data = this.collection.findOne(query);

        return ListConverter.toList(data);
    }
}
