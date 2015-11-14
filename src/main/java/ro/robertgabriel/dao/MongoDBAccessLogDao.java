package ro.robertgabriel.dao;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import org.bson.types.ObjectId;
import ro.robertgabriel.converter.AccessLogConverter;
import ro.robertgabriel.model.AccessLogModel;

public class MongoDBAccessLogDao{

    private final DBCollection collection;

    public MongoDBAccessLogDao() {
        DB mongoClient = MongoDB.getMongoDB().getDbConnection();
        this.collection = mongoClient.getCollection("access_logs");
    }

    public AccessLogModel createAccessLog(AccessLogModel accessLogModel) {
        DBObject dbObject = AccessLogConverter.toDBObject(accessLogModel);
        this.collection.insert(dbObject);
        ObjectId id = (ObjectId) dbObject.get("_id");
        accessLogModel.setId(id.toString());
        return accessLogModel;
    }
}
