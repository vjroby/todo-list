package main.java.dao;

import com.mongodb.*;
import main.java.converter.ItemConverter;
import main.java.model.ItemModel;
import main.java.model.ListModel;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class MongoDBItemsDao {

    private final DBCollection collection;

    public MongoDBItemsDao() {
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

            List<MongoCredential> listMongoCredentials = new ArrayList<MongoCredential>();

            listMongoCredentials.add(credential);

            MongoClient mongoClient = new MongoClient(new ServerAddress(host, port), listMongoCredentials);
            DB mongoDb = mongoClient.getDB(db);

            this.collection = mongoDb.getCollection("items");



        } catch (UnknownHostException e) {
            throw new RuntimeException("Failed to access Mongo server", e);
        }
    }

    public List<ItemModel> readItemsByListId(ListModel listModel) {
        List<ItemModel> data = new ArrayList<ItemModel>();

        BasicDBObject query = new BasicDBObject();
        BasicDBObject fields = new BasicDBObject("list_id", listModel.getId());

        DBCursor dbCursor = collection.find(query, fields);

        while (dbCursor.hasNext()){
            DBObject dbObject = dbCursor.next();
            ItemModel itemModel = ItemConverter.toItem(dbObject);
            data.add(itemModel);
        }

        return  data;
    }
}
